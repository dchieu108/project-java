package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private Integer id;
    private Integer idparent;
    private String name;
    private String notes;
    private String createdDate;
    private String updatedDate;
    private String isactive;
}
