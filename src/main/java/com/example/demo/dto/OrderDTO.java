package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Integer id;
    private String idorder;
    private String idcustomer;
    private String ordersDate;
    private String address;
    private double totalMoney;
    private int phone;
    private String notes;
    private String nameReciver;
}
