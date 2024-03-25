package com.mycompany.demo.repositories;

import com.mycompany.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    
    boolean existsByUsername(String username);
    
    boolean existsByEmail(String email);
    
}
