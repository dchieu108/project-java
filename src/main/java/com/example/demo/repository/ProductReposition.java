package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReposition extends JpaRepository<Product,Integer> {
@Query(value = " SELECT c FROM Product  c WHERE c.name LIKE %?1%")
    List<Product> searchProduct(String keyword);

}
