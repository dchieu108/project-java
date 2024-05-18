package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.projection.IOrders;
import com.example.demo.repository.OrderRespotion;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
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
    @Autowired
    private ProductService productService;
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
        List<Product> product = productService.findall();
        model.addAttribute("productAll", product);
        Orders ordersDTO = orderService.findByIdOrder(id);
        model.addAttribute("Orders", orders);
        model.addAttribute("Orders_details", orders_details);

        model.addAttribute("id",id);
        return "layout/orders_details";
    }

//    @PostMapping("/update_status")
//    public String updateOrderStatus(@RequestParam("Orderid") int Orderid,
//                                    @RequestParam("status") int status) {
//        orderService.updateOrderStatus(Orderid, status);
//        return "redirect:/orders_details";
//    }


    //chuyển đến trang thêm sản phẩm
    @GetMapping("/add-orders/{Orderid}")
    public String addProduct(Model model, @PathVariable("Orderid") int Orderid) {
        List<IOrders> orders = orderRespotion.findOrdersById(Orderid);
        List<IOrders> orders_details = orderRespotion.findOrdersDetailsById(Orderid);
        Product productDTO = productService.findById(Orderid);
        List<Product> productList = productService.findall();
        model.addAttribute("ordersDetails", new OrdersDetails());
        model.addAttribute("productDTO", productDTO);
        model.addAttribute("Orders", orders);
        model.addAttribute("orders_details", orders_details);
        model.addAttribute("Orderid", Orderid);
        model.addAttribute("productList", productList); // Thêm Orderid vào model để sử dụng trong template
        return "function/Add-orders";
    }

    // thêm sản phẩm
    @PostMapping("/orders_details/{Orderid}")
    public String addProduct(@PathVariable("Orderid") int Orderid,
                             @ModelAttribute Orders_detailsDTO orders_detailsDTO,
                             Model model) {
        orderService.saveOrder(Orderid, orders_detailsDTO);
        return "redirect:/orders_details/" + Orderid;
    }




    //chuyển đến xoá sản phẩm
    @GetMapping("/delete-orders/{Orderid}/{id}")
    public String showDelete(Model model,
                             @PathVariable("id") int id) {
//        List<IOrders> orders = orderRespotion.findOrdersById(id);
//        List<IOrders> orders_details = orderRespotion.findOrdersDetailsById(Orderid);
//        model.addAttribute("Orders", orders);
//        model.addAttribute("orders_details", orders_details);
//        model.addAttribute("Orderid", Orderid);
        model.addAttribute("id", id);
        return "function/Delete-orders";
    }

    @PostMapping("/deleteorders/{id}")
    public String deleteProduct(
                                @PathVariable("id") int id) {
        orderService.deleteProduct(id);
        return "redirect:/orders";
    }

}

