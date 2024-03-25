/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demo.controller;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class ValidatorController {

    private String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

    public boolean emailPatternMatches(String emailAddress) {
        return Pattern.compile(this.emailRegex)
                .matcher(emailAddress)
                .matches();
    }

}
