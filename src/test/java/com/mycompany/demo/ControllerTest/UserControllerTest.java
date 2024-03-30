/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demo.ControllerTest;

import com.mycompany.demo.controller.UserController;
import com.mycompany.demo.entities.Address;
import com.mycompany.demo.entities.CartItem;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.services.UserService;
import java.util.HashSet;
import java.util.Set;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    public UserController userController;
    public UserService userService;

    public UserControllerTest() {
    }

    @BeforeEach
    public void setUpClass() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    /**
     * Test of createNewUser method, of class UserController.
     */
    @Test
    public void testCreateNewUserShouldCallInsertInUserService() {
        User newUser = new User();
        userController.createNewUser(newUser);
        verify(userService, times(1)).insert(newUser);
    }

    /**
     * Test of login method, of class UserController.
     */
    @Test
    public void testLogInShouldReturnTrueIfCredetialsAreValid() {
        String email = "userTest@gmail.com";
        String password = "password";
        when(userService.logIn(email, password)).thenReturn(true);

        boolean result = userController.login(email, password);

        assertEquals(true, result);
        verify(userService, times(1)).logIn(email, password);
    }

    @Test
    public void testLogInShouldReturnFalseIfCredetialsAreInvalid() {
        String email = "invalidEmail@gmail.com";
        String password = "Invalidpassword";
        when(userService.logIn(email, password)).thenReturn(false);

        boolean result = userController.login(email, password);

        assertEquals(false, result);
        verify(userService, times(1)).logIn(email, password);
    }
    
    @Test
    public void testGetUserLoggedMethodShouldReturnAnUserEntityIfUserIsLogged(){
        User user = new User();
        when(userService.getUserLogged()).thenReturn(user);
        assertEquals(user, userController.getUserLogged());
    }
    
    @Test
    public void testGetUserLoggedMethodShouldReturnNullIfUserIsntLogged(){
        when(userService.getUserLogged()).thenReturn(null);
        assertEquals(null, userController.getUserLogged());
    }
    
    @Test
    public void testGetUserCartItemsShouldReturnCartItemsIfExistsItems(){
        Set<CartItem> items = new HashSet<CartItem>();
        when(userService.getUserCart()).thenReturn(items);
        assertEquals(items, userController.getUserCartItems());
    }
    
    @Test
    public void testGetUserCartItemsShouldReturnNullIfThereIsNoItems(){
        when(userService.getUserCart()).thenReturn(null);
        assertEquals(null, userController.getUserCartItems());
    }
    
    @Test
    public void testGetAddressMethodShouldReturnAnAddressIfUserHasAnAddress(){
        Address address = new Address();
        when(userService.getAddress()).thenReturn(address);
        assertEquals(address, userController.getAddress());
    }
    
    @Test
    public void testGetAddressMethodShouldReturnNullIfUserHasNoAnAddress(){
        when(userService.getAddress()).thenReturn(null);
        assertEquals(null, userController.getAddress());
    }
}
