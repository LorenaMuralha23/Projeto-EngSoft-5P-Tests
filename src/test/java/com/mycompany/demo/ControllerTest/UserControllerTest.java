/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demo.ControllerTest;

import com.mycompany.demo.controller.SessionController;
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
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class UserControllerTest {

    public UserController userController;
    public UserService userService;
    
    @Mock
    private SessionController sessionControllerMock;

    public UserControllerTest() {
    }

    @BeforeEach
    public void setUpClass() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
        openMocks(this);
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
        when(userService.logIn(email, password, sessionControllerMock)).thenReturn(true);

        boolean result = userController.login(email, password, sessionControllerMock);

        assertEquals(true, result);
        verify(userService, times(1)).logIn(email, password, sessionControllerMock);
    }

    @Test
    public void testLogInShouldReturnFalseIfCredetialsAreInvalid() {
        String email = "invalidEmail@gmail.com";
        String password = "Invalidpassword";
        when(userService.logIn(email, password, sessionControllerMock)).thenReturn(false);

        boolean result = userController.login(email, password, sessionControllerMock);

        assertEquals(false, result);
        verify(userService, times(1)).logIn(email, password, sessionControllerMock);
    }
    
    @Test
    public void testGetUserLoggedMethodShouldReturnAnUserEntityIfUserIsLogged(){
        User user = new User();
        when(userService.getUserLogged(sessionControllerMock)).thenReturn(user);
        assertEquals(user, userController.getUserLogged(sessionControllerMock));
    }
    
    @Test
    public void testGetUserLoggedMethodShouldReturnNullIfUserIsntLogged(){
        when(userService.getUserLogged(sessionControllerMock)).thenReturn(null);
        assertEquals(null, userController.getUserLogged(sessionControllerMock));
    }
    
    @Test
    public void testGetUserCartItemsShouldReturnCartItemsIfExistsItems(){
        Set<CartItem> items = new HashSet<CartItem>();
        when(userService.getUserCart(sessionControllerMock)).thenReturn(items);
        assertEquals(items, userController.getUserCartItems(sessionControllerMock));
    }
    
    @Test
    public void testGetUserCartItemsShouldReturnNullIfThereIsNoItems(){
        when(userService.getUserCart(sessionControllerMock)).thenReturn(null);
        assertEquals(null, userController.getUserCartItems(sessionControllerMock));
    }
    
    @Test
    public void testGetAddressMethodShouldReturnAnAddressIfUserHasAnAddress(){
        Address address = new Address();
        when(userService.getAddress(sessionControllerMock)).thenReturn(address);
        assertEquals(address, userController.getAddress(sessionControllerMock));
    }
    
    @Test
    public void testGetAddressMethodShouldReturnNullIfUserHasNoAnAddress(){
        when(userService.getAddress(sessionControllerMock)).thenReturn(null);
        assertEquals(null, userController.getAddress(sessionControllerMock));
    }
    
   

}
