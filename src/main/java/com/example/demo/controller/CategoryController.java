package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categori")

public class CategoryController {
    @Autowired
    private CategoryService categoryService ;
    @GetMapping("")
    public List<Category> CateAll() {
        return categoryService.CateAll();
    }
}
