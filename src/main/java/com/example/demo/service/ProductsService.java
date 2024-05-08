package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Product;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface ProductsService {
//    void saveUser(CustomerDTO customerDTO);
//    Boolean CheckPasswordUser(String username, String password);
//    Boolean CheckUserbyUsername(String username);
//    User getUserbyUsername(String username);
    Page<Product> findAll(Integer pageNo);
    Page<Product> searchProduct(String keyword, Integer pageNo);
}
