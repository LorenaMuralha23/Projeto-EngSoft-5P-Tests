package com.mycompany.demo.services;

import com.mycompany.demo.controller.SessionController;
import com.mycompany.demo.controller.ValidatorController;
import com.mycompany.demo.entities.Address;
import com.mycompany.demo.entities.Cart;
import com.mycompany.demo.entities.CartItem;
import com.mycompany.demo.entities.Product;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
        boolean sameUsername = repository.existsByName(newUser.getName());
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
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

    public boolean logIn(String email, String password) {
        Optional<User> userOptional = repository.findByEmail(email);

        if (userOptional.isPresent()) {
            User findedUser = userOptional.get();
            
            if (findedUser.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Deu certo!");
                SessionController.getInstance().logIn(findedUser);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Invalid password!");
            }

        }else{
            JOptionPane.showMessageDialog(null, "User not found");
        }
        
        return false;
    }
    
    public User getUserLogged(){
        return SessionController.getInstance().getUserLogged();
    }

    public Set<CartItem> getUserCart(){
        System.out.println(SessionController.getInstance().getUserLogged().getCart().getItems());
        return SessionController.getInstance().getUserLogged().getCart().getItems();
    }
    
    public Address getAddress(){
        return SessionController.getInstance().getUserLogged().getAddress();
    }
}
