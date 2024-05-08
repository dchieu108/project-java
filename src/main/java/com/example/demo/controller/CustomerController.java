package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/customerr")
public class CustomerController {
    @Autowired
    private CustomerService customerService ;
    @GetMapping("")
    public List<Customer> CustAll() {
        return customerService.CustAll();
    }

}
