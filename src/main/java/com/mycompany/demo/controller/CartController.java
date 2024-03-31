/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demo.controller;

import com.mycompany.demo.entities.CartItem;
import com.mycompany.demo.entities.Order;
import com.mycompany.demo.entities.Product;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.services.CartService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartController {

    @Autowired
    private CartService service;
    

    public CartController() {
        service = new CartService();
    }

    public void addProductToCart(Product product, Integer quantity, SessionController session) {
        service.addProductToCart(product, quantity, session);
    }

    public Optional<CartItem> getItem(Integer id) {
        return service.getCartItemById(id);
    }

    public void cleanCart(User userLogged) {
        service.cleanCart(userLogged);
    }

    public CartItem deleteItem(Product product, SessionController session) {
        return service.deleteItem(product, session);
    }

    public Double getSubtotal(SessionController session) {
        return service.getSubtotal(session);
    }

    public Order covertCartToOrder(SessionController session) {
        return service.covertCartToOrder(session);
    }

    public int calculateInstallments(double totalValue) {
        return service.calculateInstallments(totalValue);
    }
    
}
