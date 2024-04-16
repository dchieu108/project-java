package com.example.demo.service;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.repository.PaymentReposition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PaymentService {
    @Autowired
    PaymentReposition paymentReposition;
    public String savePayment(PaymentDTO payment){
        PaymentMethod paymentMethod =new PaymentMethod();
        paymentMethod.setId(payment.getId());
        paymentMethod.setNotes(payment.getNotes());
        paymentMethod.setName(payment.getName());
        paymentMethod.setImage(payment.getImage());
        paymentMethod.setCreatedDate(LocalDateTime.parse(payment.getCreatedDate()));
        paymentReposition.save(paymentMethod);
        return "Thêm thành công";
    }
}
