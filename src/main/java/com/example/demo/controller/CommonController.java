package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.TransportDTO;
import com.example.demo.entity.Orders;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.entity.Product;
import com.example.demo.entity.TransportMethod;
import com.example.demo.projection.IOrders;
import com.example.demo.repository.OrderRespotion;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.Order;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class CommonController {
    @Autowired
    private OrderRespotion orderRespotion;
    @Autowired
    private OrderService orderService;
    @GetMapping("/login")
    public String showLogin(){
        return "layout/login";
    }
    @GetMapping("/register")
    public String showRegister(){
        return "layout/register";
    }
    @GetMapping("/loginadmin")
    public String showLoginadmin(){
        return "layout/loginadmin";
    }
    @GetMapping("/order/{id}")
    List<IOrders> getOrderById(@PathVariable int id){
        return orderRespotion.findOrdersById(id);
    }
    @GetMapping("/orders_details/{id}")
    public String getOrderById(@PathVariable("id") int id, Model model) {
        List<IOrders> orders = orderRespotion.findOrdersById(id);
        List<IOrders> orders_details = orderRespotion.findOrdersDetailsById(id);
        Orders ordersDTO = orderService.findByIdOrder(id);
        model.addAttribute("Orders", orders);
        model.addAttribute("Orders_details", orders_details);

        model.addAttribute("id",id);
        return "layout/orders_details";
    }

    @PostMapping("/update_status")
    public String updateOrderStatus(@RequestParam("Orderid") int Orderid,
                                    @RequestParam("status") int status) {
        orderService.updateOrderStatus(Orderid, status);
        return "redirect:/orders_details";
    }


//    @PostMapping("/updateorders/{id}")
//    public String updateOrder(@PathVariable("id") int id,
//                                @ModelAttribute("orders") Orders orders) {
//        orderService.updateOrder(id, (IOrders) orders);
//        return "redirect:/orders";
//
//    }


//    @GetMapping("/update-product/{id}")
//    public String UpdateStudent(Model model,
//                                @PathVariable("id") int id) {
//        model.addAttribute("id", id);
//        Product productDTO = productService.findById(id);
//        model.addAttribute("productDTO", productDTO);
//        return "function/Update-student";
//    }
}
