package com.mycompany.demo;

import com.mycompany.demo.entities.Address;
import com.mycompany.demo.entities.Product;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.repositories.AddressRepository;
import com.mycompany.demo.repositories.ProductRepository;
import com.mycompany.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SeedingClass implements ApplicationRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedDatabase();
    }

    private void seedDatabase() {
        // Criar um usuário
        User user = new User(null, "User Middlename Lastname", "user@gmail.com", "99 9999999", "12345");

        // Salvar o usuário
        userRepository.save(user);

        // Criar um endereço
        Address address = new Address(user, "First Avenue", "Camelot", "53A");

        // Associar o endereço ao usuário
        user.setAddress(address);

        // Salvar o endereço
        addressRepository.save(address);

        // Atualizar o usuário para refletir a associação com o endereço
        userRepository.save(user);

        // Agora você pode salvar outros dados como produtos, se necessário
        Product wheyProtein = new Product(null, "Whey Protein", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tempor tristique est, vel egestas libero.", 100.0, "whey.jpg");
        Product creatine = new Product(null, "Creatine", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tempor tristique est, vel egestas libero.", 98.97, "creatine.jpg");
        Product peanutButter = new Product(null, "Peanut Butter", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tempor tristique est, vel egestas libero.", 24.99, "peanut_butter.jpg");

        productRepository.save(wheyProtein);
        productRepository.save(creatine);
        productRepository.save(peanutButter);
    }

}
