package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Product;
import com.example.demo.projection.IOrders;
import com.example.demo.repository.OrderRespotion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    // sửa sinh viên theo id
//    public String updateOrder(int id, IOrders iOrders) {
//        // Kiểm tra xem đơn hàng có tồn tại không
//        Optional<Orders> optionalOrder = orderRespotion.findById(id);
//        if (!optionalOrder.isPresent()) {
//            return "Không tìm thấy đơn hàng có id = " + id;
//        }
//
//
//        Orders order = optionalOrder.get();
//
//        // Cập nhật thông tin của đơn hàng từ dữ liệu của IOrders
//        order.setId(order.getId());
//        order.setIdorders(order.getIdorders());
//        order.setOrdersDate(order.getOrdersDate());
//        order.setTotalMoney(order.getTotalMoney());
//        order.setNotes(order.getNotes());
//        order.setNameReciver(order.getNameReciver());
//        order.setAddress(order.getAddress());
//        order.setPhone(order.getPhone());
//        iOrders.getPaymentmethodname();
//        iOrders.getTransportmethodname();
//        iOrders.getTransportmethodprice();
//        orderRespotion.save(order);
//
//        return "Cập nhật thành công";
//    }

}
