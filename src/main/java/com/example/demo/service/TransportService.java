package com.example.demo.service;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.TransportDTO;
import com.example.demo.entity.PaymentMethod;
import com.example.demo.entity.TransportMethod;
import com.example.demo.repository.PaymentReposition;
import com.example.demo.repository.TransportReposition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.server.RSocketServer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TransportService {
    @Autowired
    TransportReposition transportReposition;

    public List<TransportMethod> TranAll(){
        List<TransportMethod> transportMethods = transportReposition.findAll();
        return  transportMethods;
    }
    // thêm
    public String saveTransport(TransportDTO transport){
        TransportMethod transportMethod =new TransportMethod();
        transportMethod.setId(transport.getId());
        transportMethod.setImages(transport.getImages());
        transportMethod.setName(transport.getName());
        transportMethod.setPrice(transport.getPrice());
        transportMethod.setCreatedDate(LocalDateTime.parse(transport.getCreatedDate()));
        transportMethod.setIsactive(Byte.valueOf(transport.getIsactive()));
        transportReposition.save(transportMethod);
        return "Thêm thành công";
    }

    public TransportMethod findByIdTransport(int id){
        Optional<TransportMethod> optionalTransportMethod = transportReposition.findById(id);
        if (optionalTransportMethod.isEmpty()){
            System.out.println("Không có");
            return null;
        }
        return optionalTransportMethod.get();
    }

    // sửa sinh viên theo id
    public String updateTransport(int id, TransportDTO transportDTO) {
        boolean existsById = transportReposition.existsById(id);
        if (!existsById) return "Không có sản phẩm có id = " +id;
        TransportMethod transportMethod =new TransportMethod();
        transportMethod.setId(id);
        transportMethod.setName(transportDTO.getName());
        transportMethod.setImages((transportDTO.getImages()));
        transportMethod.setPrice(transportDTO.getPrice());
        transportMethod.setCreatedDate(LocalDateTime.parse(transportDTO.getCreatedDate()));
        transportMethod.setIsactive(Byte.valueOf(transportDTO.getIsactive()));
        transportReposition.save(transportMethod);
        return "Cập nhật thành công";
    }

    // xóa sinh viên

    public String deleteTransport (int id){
        boolean existsById = transportReposition.existsById(id);
        if (!existsById) return "Không có sinh viên có id = " +id;
        transportReposition.deleteById(id);
        return "Xóa thành công";
    }
}
