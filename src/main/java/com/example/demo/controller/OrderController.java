package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Orders;
import com.example.demo.projection.IOrders;
import com.example.demo.repository.OrderRespotion;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("")
public class OrderController {
    @Autowired
    private OrderService orderService ;
    @Autowired
    private OrderRespotion orderRespotion;
    @GetMapping("")
    public List<Orders> CustAll() {
        return orderService.OrderAll();
    }

    @DeleteMapping("")
    String deleteProduct(@RequestParam("id") int id){
        String message =orderService.deleteProduct(id);
        return message;
    }
}
