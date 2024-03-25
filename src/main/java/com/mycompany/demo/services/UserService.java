package com.mycompany.demo.services;

import com.mycompany.demo.controller.ValidatorController;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ValidatorController validator;

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj;
    }

    public User insert(User newUser) {

        boolean sameUsername = repository.existsByUsername(newUser.getUsername());
        boolean sameEmail = repository.existsByEmail(newUser.getEmail());

        if (!sameUsername && !sameEmail) {
            System.out.println(validator.emailPatternMatches(newUser.getEmail()));
            if (validator.emailPatternMatches(newUser.getEmail())) {
                return repository.save(newUser);
            }else{
                System.out.println("Invalid email format");
            }

        } else {
            if (sameUsername) {
                System.out.println("Username provided is already in use. Try again");
            } else if (sameEmail) {
                System.out.println("Email provided is already in use. Try again");
            }
        }

        return null;

    }

    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setUsername(obj.getUsername());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
