package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders_details")
public class OrdersDetails {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IDORD")
    private Integer idord;

    @Column(name = "IDPRODUCT")
    private Integer idproduct;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "QTY")
    private Integer qty;

}
