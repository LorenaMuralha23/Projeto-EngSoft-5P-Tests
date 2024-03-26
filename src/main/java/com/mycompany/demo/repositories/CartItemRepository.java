package com.mycompany.demo.repositories;

import com.mycompany.demo.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    
}
