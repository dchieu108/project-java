package com.example.demo.service;
import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.entity.Product;

import com.example.demo.entity.TransportMethod;
import com.example.demo.repository.PaymentReposition;
import com.example.demo.repository.ProductReposition;
import com.example.demo.repository.TransportReposition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ProductService {
    @Autowired
    private ProductReposition productReposition;
    @Autowired
    private PaymentReposition paymentReposition;
    @Autowired
    private TransportReposition transportReposition;


    public Product findById(int id){
        Optional<Product> optionalProduct = productReposition.findById(id);
        if(optionalProduct.isEmpty()){
            System.out.println("Không tìm thấy sản phẩm");
            return null;
        }
        return optionalProduct.get();
    }

    public List<Product> findAll() {
        List<Product> products = productReposition.findAll();
        return products;
    }
    public List<PaymentMethod> PayAll(){
        List<PaymentMethod> paymentMethods = paymentReposition.findAll();
        return paymentMethods;
    }

    public  List<TransportMethod> TranAll(){
        List<TransportMethod> transportMethods = transportReposition.findAll();
        return  transportMethods;
    }
    //thêm sinh viên
    public String save(ProductDTO product){
        Product products =new Product();
        products.setId(products.getId());
        products.setName(product.getName());
        products.setAnh(product.getAnh());
        products.setGia(String.valueOf((long) product.getGia()));
        products.setCreatedDate(LocalDateTime.parse(product.getCreatedDate()));
        products.setQuatity(product.getQuantity());
        productReposition.save(products);
        return "Thêm thành công";
    }


    // sửa sinh viên theo id
    public String update(int id, ProductDTO productDTO) {
        boolean existsById = productReposition.existsById(id);
        if (!existsById) return "Không có sinh viên có id = " +id;
        Product products = new Product();
        products.setId(id);
        products.setAnh(productDTO.getAnh());
        products.setName(productDTO.getName());
        products.setQuatity((productDTO.getQuantity()));

        products.setGia(String.valueOf((long) productDTO.getGia()));
        productReposition.save(products);
        return "Cập nhật thành công";
    }
    // xóa sinh viên

    public String delete (int id){
        boolean existsById = productReposition.existsById(id);
        if (!existsById) return "Không có sinh viên có id = " +id;
        productReposition.deleteById(id);
        return "Xóa thành công";
    }

}
