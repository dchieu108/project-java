package com.example.demo.service;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.entity.Product;

import com.example.demo.repository.PaymentReposition;
import com.example.demo.repository.ProductReposition;
import com.example.demo.repository.TransportReposition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Product> findAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo-1,5);
        return this.productReposition.findAll(pageable);
    }
    public List<Product> searchProduct( String keyword){
        return this.productReposition.searchProduct(keyword);
    }
    public Page<Product> searchProduct( String keyword, Integer pageNo){
        List product =this.searchProduct(keyword);
        Pageable pageable = PageRequest.of(pageNo-1,5);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) (pageable.getOffset() + pageable.getPageSize()) >product.size() ? product.size() : (int) (pageable.getOffset() + pageable.getPageSize());
        product= product.subList(start,end);
        return new PageImpl<Product>(product,pageable,this.searchProduct(keyword).size());

    }
    public List<Product> findall(){
        List<Product> products = productReposition.findAll();
        return products;
    }
    //thêm sản phẩm
    public String save(ProductDTO product){
        Product products =new Product();
        products.setId(product.getId());
        products.setName(product.getName());
        products.setImage(product.getImage());
        products.setSales(product.getSales());
        products.setPrice(String.valueOf((long) product.getPrice()));
        products.setCreatedDate(LocalDateTime.parse(product.getCreatedDate()));
        products.setQuantity(product.getQuantity());
        products.setNotes(product.getNotes());
        products.setIsactive(Byte.valueOf(product.getIsactive()));
        productReposition.save(products);
        return "Thêm thành công";
    }


    // sửa sinh viên theo id
    public String update(int id, ProductDTO productDTO) {
        boolean existsById = productReposition.existsById(id);
        if (!existsById) return "Không có sinh viên có id = " +id;
        Product products = new Product();
        products.setId(id);
        products.setImage(productDTO.getImage());
        products.setName(productDTO.getName());
        products.setSales(productDTO.getSales());
        products.setNotes(productDTO.getNotes());
        products.setQuantity((productDTO.getQuantity()));
        products.setPrice(String.valueOf((long) productDTO.getPrice()));
        products.setCreatedDate(LocalDateTime.parse(productDTO.getCreatedDate()));
        products.setIsactive(Byte.valueOf(productDTO.getIsactive()));
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
