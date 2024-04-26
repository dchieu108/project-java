package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Orders;
import com.example.demo.projection.IOrders;
import com.example.demo.repository.OrderRespotion;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
