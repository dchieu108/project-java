package com.example.demo.repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CustomerRepotion extends JpaRepository<Customer,Integer> {
}
