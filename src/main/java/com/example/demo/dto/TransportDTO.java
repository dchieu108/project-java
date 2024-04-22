package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransportDTO {
    private Integer id;
    private String name;
    private String images;
    private float price;
    private String createdDate;
    private String isactive;
}
