package com.example.demo.service;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.entity.Product;
import com.example.demo.repository.PaymentReposition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentService {
    @Autowired
    PaymentReposition paymentReposition;

    public List<PaymentMethod> PayAll(){
        List<PaymentMethod> paymentMethods = paymentReposition.findAll();
        return paymentMethods;
    }

    // thêm
    public String savePayment(PaymentDTO payment){
        PaymentMethod paymentMethod =new PaymentMethod();
        paymentMethod.setId(payment.getId());
        paymentMethod.setNotes(payment.getNotes());
        paymentMethod.setName(payment.getName());
        paymentMethod.setImage(payment.getImage());
        paymentMethod.setCreatedDate(LocalDateTime.parse(payment.getCreatedDate()));
        paymentMethod.setIsactive(Byte.valueOf(payment.getIsactive()));
        paymentReposition.save(paymentMethod);
        return "Thêm thành công";
    }

     public PaymentMethod findByIdPayment(int id){
        Optional<PaymentMethod> optionalPaymentMethod = paymentReposition.findById(id);
        if (optionalPaymentMethod.isEmpty()){
            System.out.println("Không có");
            return null;
        }
        return optionalPaymentMethod.get();
     }

    // sửa sinh viên theo id
    public String updatePayment(int id, PaymentDTO paymentDTO) {
        boolean existsById = paymentReposition.existsById(id);
        if (!existsById) return "Không có sản phẩm có id = " +id;
        PaymentMethod paymentMethods =new PaymentMethod();
        paymentMethods.setId(id);
        paymentMethods.setName(paymentDTO.getName());
        paymentMethods.setNotes(paymentDTO.getNotes());
        paymentMethods.setImage((paymentDTO.getImage()));
        paymentMethods.setCreatedDate(LocalDateTime.parse(paymentDTO.getCreatedDate()));
        paymentMethods.setIsactive(Byte.valueOf(paymentDTO.getIsactive()));
        paymentReposition.save(paymentMethods);
        return "Cập nhật thành công";
    }

    // xóa sinh viên

    public String deletePayment (int id){
        boolean existsById = paymentReposition.existsById(id);
        if (!existsById) return "Không có sinh viên có id = " +id;
        paymentReposition.deleteById(id);
        return "Xóa thành công";
    }
}
