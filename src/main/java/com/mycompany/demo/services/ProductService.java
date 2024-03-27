package com.mycompany.demo.services;

import com.mycompany.demo.entities.Product;
import com.mycompany.demo.repositories.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductService() {
    }

    public void insert(Product product) {
        repository.save(product);
    }

    public Optional<Product> findById(Long id) {
        Optional<Product> product = repository.findById(id);

        return product;
    }

    public Product createInstance(String name, String description, Double price, String imgUrl) {
        Product product = new Product(null, name, description, price, imgUrl);
        insert(product);
        return product;
    }
    
    public Optional<Product> getProductByName(String name){
        return repository.findByName(name);
    }
}
