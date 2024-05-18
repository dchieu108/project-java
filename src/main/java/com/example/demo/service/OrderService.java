package com.example.demo.service;

import com.example.demo.dto.Orders_detailsDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.OrderRespotion;
import com.example.demo.repository.OrdersDetailsRespotion;
import com.example.demo.repository.ProductReposition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRespotion orderRespotion;
    @Autowired
    ProductReposition productReposition;
    @Autowired
    OrdersDetailsRespotion ordersDetailsRespotion;


    public Orders findByIdOrder(int id) {
        Optional<Orders> optionalOrders = orderRespotion.findById(id);
        if (optionalOrders.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm");
            return null;
        }
        return optionalOrders.get();
    }

    public List<Orders> OrderAll() {
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

    public String saveOrder(int Orderid, Orders_detailsDTO ordersDetailsDTO) {
        OrdersDetails ordersDetails1 = new OrdersDetails();
        ordersDetails1.setIdord(Orderid); // Gán idorder từ DTO
        ordersDetails1.setIdproduct(ordersDetailsDTO.getIdproduct()); // Gán idproduct từ DTO
        ordersDetailsRespotion.save(ordersDetails1); // Lưu đối tượng OrdersDetails vào cơ sở dữ liệu
        return "Thêm thành công";
    }


    public String deleteProduct(int id) {
        boolean existsById = ordersDetailsRespotion.existsById(id);
        if (!existsById) return "Không có sinh viên có id = " +id;
        ordersDetailsRespotion.deleteById(id);
        return "Xóa thành công";
    }
}
