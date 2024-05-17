package com.example.demo.controller;

import com.example.demo.entity.CartItem;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.entity.Product;
import com.example.demo.entity.TransportMethod;
import com.example.demo.service.PaymentService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ShoppingCartService;
import com.example.demo.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shopping")

public class ShoppingCartController {
    @Autowired
    ProductService productService;
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    TransportService transportService;
    @Autowired
    PaymentService paymentService;
    @GetMapping("/cart")
    public String viewCart(Model model){
        List<TransportMethod> transport = transportService.TranAll();
        model.addAttribute("TranAll", transport);
        double total = shoppingCartService.getTotal();
        model.addAttribute("CartItem",shoppingCartService.getAllItems());
        model.addAttribute("total",String.format("%.2f", total));
        return "layout/cart";
    }
    @GetMapping("/thanhtoan/{id}")
    public String Thanhtoan(Model model){
        List<TransportMethod> transport = transportService.TranAll();
        model.addAttribute("TranAll", transport);
        double total = shoppingCartService.getTotal();
        model.addAttribute("CartItem",shoppingCartService.getAllItems());
        model.addAttribute("total",String.format("%.2f", total));
        return "layout/thanhtoan";
    }
    @GetMapping("/add/{id}")
    public String addCart(@PathVariable("id") Integer id){
        Product product =productService.findById(id);
        if (product != null){
            CartItem item = new CartItem();
            item.setProductId(product.getId());
            item.setName(product.getName());
            item.setPrice(Double.parseDouble(product.getPrice()));
            item.setQty(1);
            shoppingCartService.add(item);
        }
        return "redirect:/shopping/cart";
    }
    @PostMapping("/remove/{id}")
    public String removeItem(@PathVariable("id") Integer id){
        shoppingCartService.remove(id);
        return "redirect:/shopping/cart";
    }
    @GetMapping("/update/{id}")
    public String updateItem(@PathVariable("id") int productId, @RequestParam("qty") int qty){
        shoppingCartService.updatee(productId, qty);
        return "redirect:/shopping/cart";
    }
}
