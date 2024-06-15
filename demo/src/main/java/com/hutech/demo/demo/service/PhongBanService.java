package com.hutech.demo.demo.service;

import com.hutech.demo.demo.model.Category;

import com.hutech.demo.demo.model.PhongBan;
import com.hutech.demo.demo.repository.PhongBanRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class PhongBanService {
    private final PhongBanRepository phongBanRepository;

    public PhongBanService(PhongBanRepository phongBanRepository) {
        this.phongBanRepository = phongBanRepository;
    }

    public List<PhongBan> getAllPhongBan() {
        return phongBanRepository.findAll();
    }

    public Optional<PhongBan> getPhongBanById(String id) {
        return phongBanRepository.findById(id);
    }

    public void addPhongBan(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }

    public void updatePhongBan(@NotNull PhongBan phongBan) {
        PhongBan existingPhongBan = phongBanRepository.findById(phongBan.getPhongbanId())
                .orElseThrow(() -> new IllegalStateException("Phong ban co ID " +
                        phongBan.getPhongbanId() + " khong ton tai."));
        existingPhongBan.setName(phongBan.getName());
        phongBanRepository.save(existingPhongBan);
    }
    public void deletePhongBanById(String id) {
        if (!phongBanRepository.existsById(id)) {
            throw new IllegalStateException("Phong ban co ID " + id + "khong ton tai");
        }
        phongBanRepository.deleteById(id);
    }
}
