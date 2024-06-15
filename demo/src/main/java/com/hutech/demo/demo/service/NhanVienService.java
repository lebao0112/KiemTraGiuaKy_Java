package com.hutech.demo.demo.service;

import com.hutech.demo.demo.model.NhanVien;
import com.hutech.demo.demo.model.Product;
import com.hutech.demo.demo.repository.NhanVienRepository;
import com.hutech.demo.demo.repository.ProductRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public NhanVien addNhanVien(NhanVien nhanVien) {
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

        return nhanVienRepository.save(existingNhanVien);
    }
    // Delete a product by its id
    public void deleteNhanVienById(String id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new IllegalStateException("Nhan vien co " + id + " khong ton tai.");
        }
        nhanVienRepository.deleteById(id);
    }
}
