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
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "SALES")
    private Integer sales;

    @Column(name = "QUATITY")
    private Integer quatity;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

    @Column(name = "ISACTIVE")
    private java.lang.Byte isactive;

    @Column(name = "IDCATEGORY")
    private java.lang.Byte idcategory;
}
