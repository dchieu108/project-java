package com.example.demo.controller;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.TransportDTO;
import com.example.demo.entity.TransportMethod;
import com.example.demo.service.PaymentService;
import com.example.demo.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
public class TransportController {
    @Autowired
    private TransportService transportService ;
    @GetMapping("")
    public List<TransportMethod> TranAll(){
        return transportService.TranAll();
    }
    @PostMapping("")
    String saveTransport(@RequestBody TransportDTO transport) {
        String massage = transportService.saveTransport(transport);
        return massage;
    }
    @PutMapping("")
    String updateTransport(@RequestParam("id")int id, @RequestBody TransportDTO transportDTO ){
        String message = transportService.updateTransport(id, transportDTO);
        return message;
    }

    // xóa sinh viên theo id
    @DeleteMapping("")
    String deleteTransport(@RequestParam("id") int id){
        String message =transportService.deleteTransport(id);
        return message;
    }
}
