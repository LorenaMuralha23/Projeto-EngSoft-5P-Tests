package com.mycompany.demo.repositories;

import com.mycompany.demo.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Integer> {

    
}
