package com.mycompany.demo.services;

import com.mycompany.demo.entities.Order;
import com.mycompany.demo.entities.Payment;
import com.mycompany.demo.repositories.PaymentRepository;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    
    @Autowired
    PaymentRepository repository;

    public PaymentService() {
    }
    
    public Payment generatePayment(Instant moment, Order order, Integer type){
        Payment newPayment = new Payment(null, moment, order, type);
        repository.save(newPayment);
        return newPayment;
    }
    
}
