package com.mycompany.demo.controller;

import com.mycompany.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderController {
    
    @Autowired
    private OrderService service;

    public OrderController() {
    }
    
    
}

