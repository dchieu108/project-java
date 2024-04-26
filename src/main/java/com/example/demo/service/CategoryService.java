package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Customer;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.repository.CategoryRespotion;
import com.example.demo.repository.CustomerRepotion;
import com.example.demo.repository.TransportReposition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
    @Autowired
    CategoryRespotion categoryRespotion;

    public List<Category> CateAll(){
        List<Category> category = categoryRespotion.findAll();
        return category;
    }

}
