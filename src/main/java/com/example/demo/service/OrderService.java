package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Orders;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.repository.OrderRespotion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequiredArgsConstructor
@Service
public class OrderService {
    @Autowired
    OrderRespotion orderRespotion;


    public Orders findByIdOrder(int id){
        Optional<Orders> optionalOrders = orderRespotion.findById(id);
        if(optionalOrders.isEmpty()){
            System.out.println("Không tìm thấy sản phẩm");
            return null;
        }
        return optionalOrders.get();
    }
    public List<Orders> OrderAll(){
        List<Orders> orders = orderRespotion.findAll();
        return orders;
    }
    @Transactional
    public void updateOrderStatus(int Orderid, int status) {
        Optional<Orders> optionalOrder = orderRespotion.findById(Orderid);
        if (optionalOrder.isPresent()) {
            Orders orders = optionalOrder.get();
            orders.setStatus(String.valueOf(status));
            orderRespotion.save(orders);
        } else {
            throw new RuntimeException("Không tìm thấy đơn hàng có ID: " + Orderid);
        }
    }
}
