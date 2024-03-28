package com.mycompany.demo.services;

import com.mycompany.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public OrderService() {
    }

   

}
