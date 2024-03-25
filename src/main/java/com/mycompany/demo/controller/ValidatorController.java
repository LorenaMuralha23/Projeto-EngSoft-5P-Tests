/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demo.controller;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class ValidatorController {

    private static final String EMAIL_REGEX = "^(?!.*\\.\\.)[A-Za-z0-9_]+(?:\\.[A-Za-z0-9_]+)*@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)*$";

    public boolean isValidEmail(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

}
