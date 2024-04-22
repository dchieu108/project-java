package com.example.demo.controller;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.entity.Product;
import com.example.demo.service.PaymentService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService ;
    @GetMapping("")
    public List<PaymentMethod> PayAll() {
        return paymentService.PayAll();
    }
    @PostMapping("")
    String savePayment(@RequestBody PaymentDTO payment) {
        String massage = paymentService.savePayment(payment);
        return massage;
    }
    @PutMapping("")
    String updatePayment(@RequestParam("id")int id, @RequestBody PaymentDTO paymentDTO ){
        String message = paymentService.updatePayment(id, paymentDTO);
        return message;
    }

    // xóa sinh viên theo id
    @DeleteMapping("")
    String deletePayment(@RequestParam("id") int id){
        String message =paymentService.deletePayment(id);
        return message;
    }
}
