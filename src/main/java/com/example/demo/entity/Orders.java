package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IDORDERS")
    private String idorders;

    @Column(name = "ORDERS_DATE")
    private LocalDateTime ordersDate;

    @Column(name = "IDCUSTOMER")
    private Integer idcustomer;

    @Column(name = "TOTAL_MONEY")
    private double totalMoney;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "NAME_RECIVER")
    private String nameReciver;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;



}
