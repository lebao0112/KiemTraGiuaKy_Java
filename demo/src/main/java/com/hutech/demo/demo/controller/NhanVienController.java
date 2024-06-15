package com.hutech.demo.demo.controller;

import com.hutech.demo.demo.model.NhanVien;
import com.hutech.demo.demo.model.Product;
import com.hutech.demo.demo.service.CategoryService;
import com.hutech.demo.demo.service.NhanVienService;
import com.hutech.demo.demo.service.PhongBanService;
import com.hutech.demo.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showNhanVienList(Model model) {
        model.addAttribute("dsNhanVien", nhanVienService.getAllNhanVien());
        return "/nhanvien/nhanvien-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanVien", new Product());
        model.addAttribute("dsPhongBan", phongBanService.getAllPhongBan());

        return "/nhanvien/add-nhanvien";
    }
    // Process the form for adding a new product
    @PostMapping("/add")
    public String addProduct(@Valid NhanVien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            return "nhanvien/add-nhanvien";
        }

        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/";
    }
    // For editing a product
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id)
                .orElseThrow(() -> new IllegalArgumentException("Khong hop le! Ma:" + id));
        model.addAttribute("nhanvien", nhanVien);
        model.addAttribute("dsPhongBan", phongBanService.getAllPhongBan());
        return "/nhanvien/update-nhanvien";
    }
    // Process the form for updating a product
    @PostMapping("/update/{id}")
    public String updateNhanVien(@PathVariable String id, @Valid NhanVien nhanVien,
                                BindingResult result) {
        if (result.hasErrors()) {
            nhanVien.setId(id);
            return "/nhanvien/update-nhanvien";
        }
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/";
    }
    // Handle request to delete a product
    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable String id) {
        nhanVienService.deleteNhanVienById(id);
        return "redirect:/";
    }
}
