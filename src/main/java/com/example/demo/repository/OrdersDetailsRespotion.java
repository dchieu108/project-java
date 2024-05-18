package com.example.demo.repository;

import com.example.demo.entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetailsRespotion extends JpaRepository<OrdersDetails,Integer> {
}
