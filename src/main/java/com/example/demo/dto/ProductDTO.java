package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Integer id;
    private String tenSanPham;
    private String anh;
    private float gia;
    private int sales;
    private String note;
    private String category;
    private int quantity;
}
