/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demo.controller;

import com.mycompany.demo.entities.Product;
import com.mycompany.demo.services.ProductService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductController {

    @Autowired
    private ProductService service;
    
    public ProductController() {
    }
    
    public void insert(Product newProduct){
        service.insert(newProduct);
    }
    
    public Product findById(Long id){
        Product findedProduct = service.findById(id);
        
        return findedProduct;
    }
    
    public Product createInstance(String name, String description, Double price, String imgUrl){
        return service.createInstance(name, description, price, imgUrl);
    }
    
    public Product getProductByName(String productName){
        return service.getProductByName(productName);
    }
}
