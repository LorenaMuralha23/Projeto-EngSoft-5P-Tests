package com.mycompany.demo.repositories;

import com.mycompany.demo.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
    boolean existsByName(String username);
    
    boolean existsByEmail(String email);
    
    boolean existsByPassword(String password);
    
}
