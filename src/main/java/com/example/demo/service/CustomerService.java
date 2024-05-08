package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepotion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CustomerService {
    @Autowired
    CustomerRepotion customerRepotion;
    public List<Customer> CustAll(){
        List<Customer> customer = customerRepotion.findAll();
        return customer;
    }

}
