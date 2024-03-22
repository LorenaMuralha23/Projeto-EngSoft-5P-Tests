package com.mycompany.demo;

import org.junit.jupiter.api.Test;

import com.mycompany.demo.entities.User;
import com.mycompany.demo.repositories.CategoryRepository;
import com.mycompany.demo.repositories.OrderItemRepository;
import com.mycompany.demo.repositories.OrderRepository;
import com.mycompany.demo.repositories.ProductRepository;
import com.mycompany.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assert;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class EcommerceT1LpApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    void contextLoads() {
    }
    
    @Test
    public void testSaveUser() {
        List<User> usersToSave = List.of(
            new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"),
            new User(null, "Ted Mosby", "tm@gmail.com", "988888888", "123456")
        );

        List<User> savedUsers = userRepository.saveAll(usersToSave);

        assertThat(savedUsers).isNotNull();
        assertThat(savedUsers.size()).isEqualTo(2);
        for (User user : savedUsers) {
            assertThat(user.getId()).isNotNull();
        }
    }

}
