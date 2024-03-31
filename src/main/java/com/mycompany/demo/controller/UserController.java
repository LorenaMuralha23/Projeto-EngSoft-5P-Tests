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
    
    public boolean login(String email, String password, SessionController session){
        return service.logIn(email, password, session);
    }
    
    public User getUserLogged(SessionController session){
        return service.getUserLogged(session);
    }
    
    public Set<CartItem> getUserCartItems(SessionController session){
        return service.getUserCart(session);
    }
    
    public Address getAddress(SessionController session){
        return service.getAddress(session);
    }
}
