package com.example.demo.controller;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.TransportDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.entity.Product;

import com.example.demo.entity.TransportMethod;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PaymentService;
import com.example.demo.service.ProductService;

import com.example.demo.service.TransportService;
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
    @Autowired
    private TransportService transportService ;
    @Autowired
    private CategoryService categoryService ;
    // hiển thị trang sản phẩm-user
    @GetMapping("/showAll")
    public String FindAll (Model model){
        List<Product> product = productService.findAll();
        model.addAttribute("productAll", product);
        return "layout/index";
    }
    // hiển thị trang sản phẩm-admin
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
    // hiển thị trang thanh toán-admin
    @GetMapping("/payment_method")
    public String Paymentmethod (Model model){
        List<PaymentMethod> payment = paymentService.PayAll();
        model.addAttribute("PayAll", payment);
        return "layout/payment_method";
    }
    // hiển thị trang vận chuyển-admin
    @GetMapping("/transport_method")
    public String Transportmethod (Model model){
        List<TransportMethod> transport = transportService.TranAll();
        model.addAttribute("TranAll", transport);
        return "layout/transport_method";
    }
    // hiển thị trang loại-admin
    @GetMapping("/category")
    public String Category (Model model){
        List<Category> category = categoryService.CateAll();
        model.addAttribute("CateAll", category);
        return "layout/category";
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


    // chuyển đến trang thêm phương thức thanh toán
    @GetMapping("/add-payment")
    public String AddPayment(Model model){
        model.addAttribute("payment" ,new PaymentMethod());
        return "function/Add-payment";
    }
    // thêm phương thức thanh toán
    @PostMapping("/addpayment")
    public String addPayment(@ModelAttribute("payment") PaymentDTO payment) {
        paymentService.savePayment(payment);
        return "redirect:/payment_method";
    }

    // chuyển đến trang thêm phương thức vận chuyển
    @GetMapping("/add-transport")
    public String AddTransport(Model model){
        model.addAttribute("transport" ,new TransportMethod());
        return "function/Add-transport";
    }
    // thêm phương thức thanh toán
    @PostMapping("/addtransport")
    public String addTransport(@ModelAttribute("transport") TransportDTO trasport) {
        transportService.saveTransport(trasport);
        return "redirect:/transport_method";
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


    // chuyển đến trang sửa thanh toán
    @GetMapping("/update-payment/{id}")
    public String UpdatePayment(Model model,
                                @PathVariable("id") int id) {
        model.addAttribute("id", id);
        PaymentMethod paymentDTO = paymentService.findByIdPayment(id);
        model.addAttribute("paymentDTO", paymentDTO);
        return "function/Update-payment";
    }

    // sửa thanh toán
    @PostMapping("/updatepayment/{id}")
    public String updatePayment(@PathVariable("id") int id,
                                @ModelAttribute("paymentDTO") PaymentDTO paymentDTO) {
        paymentService.updatePayment(id, paymentDTO);
        return "redirect:/payment_method";

    }

    // chuyển đến trang sửa vận chuyển
    @GetMapping("/update-transport/{id}")
    public String UpdateTransport(Model model,
                                @PathVariable("id") int id) {
        model.addAttribute("id", id);
        TransportMethod transportDTO = transportService.findByIdTransport(id);
        model.addAttribute("transportDTO", transportDTO);
        return "function/Update-transport";
    }

    // sửa thanh toán
    @PostMapping("/updatetransport/{id}")
    public String updateTransport(@PathVariable("id") int id,
                                @ModelAttribute("transportDTO") TransportDTO transportDTO) {
        transportService.updateTransport(id, transportDTO);
        return "redirect:/transport_method";

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

    // chuyển đến trang xoá thanh toán
    @GetMapping("/delete-payment/{id}")
    public String Deletepayment(Model model,
                                @PathVariable("id") int id){
        model.addAttribute("id", id);
        return "function/Delete-payment";
    }

    // Xóa thanh toán theo ID
    @PostMapping("/deletepayment/{id}")
    public String deletePayment(@PathVariable("id") int id) {
        paymentService.deletePayment(id);
        return "redirect:/payment_method";
    }


    // chuyển đến trang xoá vận chuyển
    @GetMapping("/delete-transport/{id}")
    public String Deletetranport(Model model,
                                @PathVariable("id") int id){
        model.addAttribute("id", id);
        return "function/Delete-transport";
    }

    // Xóa vận chuyển theo ID
    @PostMapping("/deletetransport/{id}")
    public String deleteTransport(@PathVariable("id") int id) {
        transportService.deleteTransport(id);
        return "redirect:/transport_method";
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
