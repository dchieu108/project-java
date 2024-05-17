package com.example.demo.controller;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.TransportDTO;
import com.example.demo.entity.*;

import com.example.demo.service.*;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
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
    @Autowired
    private CustomerService customerService ;
    @Autowired
    private OrderService orderService ;



     //hiển thị trang sản phẩm-user
    @GetMapping("/showAll")
    public String FindAll (Model model, @Param("keyword") String keyword){
        List<Product> products = productService.findall();
        if ( keyword != null){
            products=this.productService.searchProduct(keyword);
        }
        model.addAttribute("productAll", products);
        return "layout/index";
    }
    // hiển thị trang sản phẩm-admin
    @GetMapping("/admin-product")
    public String Adminproduct(Model model, @RequestParam(name = "pageNo",defaultValue = "1") Integer pageNo,
                               @RequestParam(name = "keyword", required = false) String keyword) {
        Page<Product> product;
        if (keyword != null) {
            product = productService.searchProduct(keyword, pageNo);
        } else {
            product = productService.findAll(pageNo);
        }

        model.addAttribute("totalPage",product.getTotalPages());
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("productAll", product);
        return "layout/admin-product";
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

    // hiển thị trang quản lý người dùng-admin
    @GetMapping("/customer")
    public String Customer (Model model){
        List<Customer> customer = customerService.CustAll();
        model.addAttribute("CustAll", customer);
        return "layout/customer";
    }
    // hiển thị trang order dùng-admin
    @GetMapping("/orders")
    public String Orders (Model model){
        List<Orders> orders = orderService.OrderAll();
        model.addAttribute("OrdersAll", orders);
        return "layout/orders";
    }










    //chuyển đến trang thêm sản phẩm
    @GetMapping("/add-product")
    public String AddProduct(Model model){
        model.addAttribute("product" ,new Product());
        return "function/Add-student";
    }
    // thêm sản phẩm
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
    // thêm phương thức vận chuyển
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


    // chuyển đến trang sửa sản phẩm
    @GetMapping("/update-product/{id}")
    public String UpdateStudent(Model model,
                                @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Product productDTO = productService.findById(id);
        model.addAttribute("productDTO", productDTO);
        return "function/Update-student";
    }

    // sửa sản phẩm
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

    // sửa vận chuyển
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
