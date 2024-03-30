/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demo.ServicesTest;

import com.mycompany.demo.entities.Address;
import com.mycompany.demo.entities.CartItem;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.services.UserService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author USER
 */
public class UserServiceTest {
    
    public UserServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class UserService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        UserService instance = new UserService();
        List<User> expResult = null;
        List<User> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class UserService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        UserService instance = new UserService();
        Optional<User> expResult = null;
        Optional<User> result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class UserService.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        User newUser = null;
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.insert(newUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UserService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        User obj = null;
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.update(id, obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logIn method, of class UserService.
     */
    @Test
    public void testLogIn() {
        System.out.println("logIn");
        String email = "";
        String password = "";
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.logIn(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserLogged method, of class UserService.
     */
    @Test
    public void testGetUserLogged() {
        System.out.println("getUserLogged");
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.getUserLogged();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserCart method, of class UserService.
     */
    @Test
    public void testGetUserCart() {
        System.out.println("getUserCart");
        UserService instance = new UserService();
        Set<CartItem> expResult = null;
        Set<CartItem> result = instance.getUserCart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class UserService.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        UserService instance = new UserService();
        Address expResult = null;
        Address result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
