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
    private String name;
    private String image;
    private float price;
    private int sales;
    private String notes;
    private String category;
    private int quantity;
    private String createdDate;
    private String updatedDate;
    private String idcategory;
//    private CategoryDTO categoryDTO;
    private String isactive;

}
