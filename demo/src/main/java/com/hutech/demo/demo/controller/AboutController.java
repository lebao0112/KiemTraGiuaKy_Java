package com.hutech.demo.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller // Đánh dấu lớp này là một Controller trong Spring MVC.
@RequestMapping("/about")
@RequiredArgsConstructor
public class AboutController {
    @GetMapping("/about")
    public String showProductList(Model model) {
        return "/about";
    }
}
