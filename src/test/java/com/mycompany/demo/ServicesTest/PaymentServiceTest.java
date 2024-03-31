/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demo.ServicesTest;

import com.mycompany.demo.entities.Order;
import com.mycompany.demo.entities.Payment;
import com.mycompany.demo.services.PaymentService;
import java.time.Instant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentServiceTest {
    
    PaymentService service;
    
    public PaymentServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        service = mock(PaymentService.class);
    }
    
    /**
     * Test of generatePayment method, of class PaymentService.
     */
    @Test
    public void testGeneratePayment() {
        Instant moment = Instant.parse("2024-03-14T12:00:00Z"); 
        Order order = new Order();
        int type = 1;
        Payment payment = new Payment();
        
        when(service.generatePayment(moment, order, type)).thenReturn(payment);
        
        Payment paymentReturned = service.generatePayment(moment, order, type);
        
        assertEquals(payment, paymentReturned);
        
    }
    
}
