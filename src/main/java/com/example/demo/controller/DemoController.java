package com.example.demo.controller;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.entity.Product;

import com.example.demo.entity.TransportMethod;
import com.example.demo.service.PaymentService;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private ProductService productService ;
    @Autowired
    private PaymentService paymentService ;

    @GetMapping("/showAll")
    public String FindAll (Model model){
        List<Product> product = productService.findAll();
        model.addAttribute("productAll", product);
        return "layout/index";
    }

    @GetMapping("/admin-product")
    public String Adminproduct (Model model){
        List<Product> product = productService.findAll();
        model.addAttribute("productAll", product);
        return "layout/admin-product";
    }
    @GetMapping("/orders")
    public String Orders (Model model){
        List<Product> product = productService.findAll();
        model.addAttribute("productAll", product);
        return "layout/orders";
    }

    @GetMapping("/payment_method")
    public String Paymentmethod (Model model){
        List<PaymentMethod> paymentMethods = productService.PayAll();
        model.addAttribute("PayAll", paymentMethods);
        return "layout/payment_method";
    }
    @GetMapping("/transport_method")
    public String Transportmethod (Model model){
        List<TransportMethod> transportMethods = productService.TranAll();
        model.addAttribute("TranAll", transportMethods);
        return "layout/transport_method";
    }



    //chuyển đến trang thêm sinh viên
    @GetMapping("/add-product")
    public String AddProduct(Model model){
        model.addAttribute("product" ,new Product());
        return "function/Add-student";
    }
    // thêm sinh viên
    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute("product") ProductDTO product) {
        productService.save(product);
        return "redirect:/admin-product";
    }


    // thêm phương thức thanh toán
    @GetMapping("/add-payment")
    public String AddPayment(Model model){
        model.addAttribute("payment" ,new PaymentMethod());
        return "function/Add-payment";
    }
    @PostMapping("/addpayment")
    public String addPayment(@ModelAttribute("payment") PaymentDTO payment) {
        paymentService.savePayment(payment);
        return "redirect:/payment_method";
    }


    // chuyển đến trang sửa sinh viên
    @GetMapping("/update-product/{id}")
    public String UpdateStudent(Model model,
                                @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Product productDTO = productService.findById(id);
        model.addAttribute("productDTO", productDTO);
        return "function/Update-student";
    }

    // sửa sinh viên
    @PostMapping("/updateproduct/{id}")
    public String updateStudent(@PathVariable("id") int id,
                                @ModelAttribute("productDTO") ProductDTO productDTO) {
        productService.update(id, productDTO);
        return "redirect:/admin-product";

    }
    // chuyển đến trang xoá sinh viên
    @GetMapping("/delete-product/{id}")
    public String Deleteproduct(Model model,
                                @PathVariable("id") int id){
        model.addAttribute("id", id);
        return "function/Delete-student";
    }


    // Xóa sinh viên theo ID
    @PostMapping("/deleteproduct/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/admin-product";
    }

    //chuyển đế trang chi tiết sản phẩm
    @GetMapping("/chitietsanpham/{id}")
    public String Chitiet(Model model,
                          @PathVariable("id") int id ){
        model.addAttribute("id", id);
        Product productDTO = productService.findById(id);
        model.addAttribute("productDTO", productDTO);
        return "layout/chitietsanpham";
    }
}
