package com.mycompany.demo.repositories;

import com.mycompany.demo.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Integer> {

    
}
