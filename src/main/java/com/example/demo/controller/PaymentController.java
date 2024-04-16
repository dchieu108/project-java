package com.example.demo.controller;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.service.PaymentService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class PaymentController {
    @Autowired
    private PaymentService paymentService ;


    @PostMapping("")
    String savePayment(@RequestBody PaymentDTO payment) {
        String massage = paymentService.savePayment(payment);
        return massage;
    }
}
