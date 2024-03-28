package com.mycompany.demo.controller;

import com.mycompany.demo.entities.Order;
import com.mycompany.demo.entities.Payment;
import com.mycompany.demo.services.PaymentService;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {
    
    @Autowired
    private PaymentService service;

    public PaymentController() {
    }
    
    public Payment generatePayment(Instant moment, Order order, Integer type){
        return service.generatePayment(moment, order, type);
    }
    
}
