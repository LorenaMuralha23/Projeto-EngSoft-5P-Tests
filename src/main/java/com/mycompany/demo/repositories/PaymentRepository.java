package com.mycompany.demo.repositories;

import com.mycompany.demo.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    
}
