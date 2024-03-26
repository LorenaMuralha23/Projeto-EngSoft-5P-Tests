/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demo.controller;

import com.mycompany.demo.entities.Product;
import com.mycompany.demo.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartController {

    @Autowired
    private CartService service;

    public CartController() {
    }

    public void addProductToCart(Product product, Integer quantity){
        service.addProductToCart(product, quantity);
    }

}
