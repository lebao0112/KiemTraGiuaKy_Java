package com.example.demo.service;

import com.example.demo.model.NhanVien;

import com.example.demo.repository.NhanVienRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NhanVienService {
    private final NhanVienRepository nhanVienRepository;



    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }
    public Optional<NhanVien> getNhanVienById(String id) {
        return nhanVienRepository.findById(id);
    }
    public NhanVien addNhanVien(@Valid NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }
    public NhanVien updateNhanVien(@NotNull NhanVien nhanVien) {
        NhanVien existingNhanVien = nhanVienRepository.findById(nhanVien.getId())
                .orElseThrow(() -> new IllegalStateException("Nhan vien co ID " +
                        nhanVien.getId() + " khong ton tai."));
        existingNhanVien.setTenNv(nhanVien.getTenNv());
        existingNhanVien.setId(nhanVien.getId());
        existingNhanVien.setPhai(nhanVien.getPhai());
        existingNhanVien.setLuong(nhanVien.getLuong());
        existingNhanVien.setNoiSinh(nhanVien.getNoiSinh());
        existingNhanVien.setPhongBan(nhanVien.getPhongBan());
        return nhanVienRepository.save(existingNhanVien);
    }
    // Delete a product by its id
    public void deleteNhanVienById(String id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new IllegalStateException("Nhan vien co " + id + " khong ton tai.");
        }
        nhanVienRepository.deleteById(id);
    }

    public Page<NhanVien> getAllNhanVien(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

}
