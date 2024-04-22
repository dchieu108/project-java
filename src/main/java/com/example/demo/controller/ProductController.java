package com.example.demo.controller;
import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.entity.Product;
import com.example.demo.entity.TransportMethod;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService ;


    @GetMapping("")
    public List<Product> findAll() {
        return productService.findAll();
    }
    // thêm sinh viên
    @PostMapping("")
    String save(@RequestBody ProductDTO product) {
        String massage = productService.save(product);
        return massage;
    }

    //sửa sinh viên theo id
    @PutMapping("")
    String update(@RequestParam("id")int id, @RequestBody ProductDTO productDTO ){
        String message = productService.update(id, productDTO);
        return message;
    }

    // xóa sinh viên theo id
    @DeleteMapping("")
    String delete(@RequestParam("id") int id){
        String message =productService.delete(id);
        return message;
    }
}
