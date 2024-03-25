package com.mycompany.demo.services;

import com.mycompany.demo.controller.ValidatorController;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
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
        boolean validEmailFormat = validator.isValidEmail(newUser.getEmail());

        if (!sameUsername && !sameEmail) {
            if (validEmailFormat) {
                return repository.save(newUser);
            } else {
                throw new IllegalArgumentException("Invalid email format");
            }

        } else {
            if (sameUsername) {
                throw new IllegalArgumentException("Username provided is already in use. Try again");
            } else if (sameEmail) {
                throw new IllegalArgumentException("Email provided is already in use. Try again");
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

    public void logIn(String email, String password) {
        Optional<User> userOptional = repository.findByEmail(email);

        if (userOptional.isPresent()) {
            User findedUser = userOptional.get();
            
            if (findedUser.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Deu certo!");
            }else{
                throw new IllegalArgumentException("Incorrect password");
            }

        }else{
            throw new IllegalArgumentException("User not found");
        }
    }

}
