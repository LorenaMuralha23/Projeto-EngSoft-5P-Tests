/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demo.controller;

import com.mycompany.demo.entities.CartItem;
import com.mycompany.demo.entities.Product;
import com.mycompany.demo.services.CartService;
import java.util.Optional;
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
    
    public Optional<CartItem> getItem(Integer id){
        return service.getCartItemById(id);
    }
    
    public void cleanCart(){
        service.cleanCart();
    }
    
    public void deleteItem(Product product){
        service.deleteItem(product);
    }
    
    public Double getSubtotal(){
        return service.getSubtotal();
    }
}
