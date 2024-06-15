package com.example.demo.controller;


import com.example.demo.model.NhanVien;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;


@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showNhanVienList(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<NhanVien> nhanVienPage = nhanVienService.getAllNhanVien(PageRequest.of(page, 5));

        model.addAttribute("dsNhanVien", nhanVienPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", nhanVienPage.getTotalPages());

        return "/nhanviens/nhanvien-list";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("dsPhongBan", phongBanService.getAllPhongBan());

        return "/nhanviens/add-nhanvien";
    }
    // Process the form for adding a new product
    @PostMapping("/add")
    public String addProduct(@Valid NhanVien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            return "nhanviens/add-nhanvien";
        }

        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }
    // For editing a product
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id)
                .orElseThrow(() -> new IllegalArgumentException("Khong hop le! Ma:" + id));
        System.out.println("NhanVien found: " + nhanVien);
        model.addAttribute("nhanvien", nhanVien);
        model.addAttribute("dsPhongBan", phongBanService.getAllPhongBan());
        return "/nhanviens/update-nhanvien";
    }
    // Process the form for updating a product
    @PostMapping("/update/{id}")
    public String updateNhanVien(@PathVariable String id, @Valid NhanVien nhanVien,
                                BindingResult result) {
        if (result.hasErrors()) {
            nhanVien.setId(id);
            return "/nhanviens/update-nhanvien";
        }
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }
    // Handle request to delete a product
    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable String id) {
        nhanVienService.deleteNhanVienById(id);
        return "redirect:/nhanvien";
    }
}
