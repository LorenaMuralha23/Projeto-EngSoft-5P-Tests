package com.mycompany.demo.controller;

import com.mycompany.demo.entities.Address;
import com.mycompany.demo.entities.Cart;
import com.mycompany.demo.entities.CartItem;
import com.mycompany.demo.entities.Product;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.services.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {
        
    
    private final UserService service;
    
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    
    public void createNewUser(User newUser){
        service.insert(newUser);
    }
    
    public boolean login(String email, String password){
        return service.logIn(email, password);
    }
    
    public User getUserLogged(){
        return service.getUserLogged();
    }
    
    public Set<CartItem> getUserCartItems(){
        return service.getUserCart();
    }
    
    public Address getAddress(){
        return service.getAddress();
    }
}
