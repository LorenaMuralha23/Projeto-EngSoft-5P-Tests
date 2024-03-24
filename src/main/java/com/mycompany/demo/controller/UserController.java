package com.mycompany.demo.controller;

import com.mycompany.demo.entities.User;
import com.mycompany.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {
        
    @Autowired
    private UserService service;

    public UserController() {
    }
    
    public void createNewUser(User newUser){
        User user = service.insert(newUser);
        if (user.getClass() != null){
            System.out.println("Conta cadastrada!");
        }
    }
    
}
