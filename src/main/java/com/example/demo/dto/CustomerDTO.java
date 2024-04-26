package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String address;
    private String email;
    private int phone;
    private String createdDate;
    private String isactive;
}
