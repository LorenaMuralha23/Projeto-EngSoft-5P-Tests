package com.mycompany.demo.controller;

import com.mycompany.demo.entities.User;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Component;

@Component
public class SessionController {

    private static SessionController instance;
    private User userLoggedIn;

    private SessionController() {
    }

    public static SessionController getInstance() {
        if (instance == null) {
            instance = new SessionController();
        }

        return instance;
    }

    public void logIn(User userToLogIn) {
        this.userLoggedIn = userToLogIn;
        JOptionPane.showMessageDialog(null, "Log in complete\n"+
                "User loged: " + this.userLoggedIn.getName());
    }

    public void logOut() {
        this.userLoggedIn = null;
    }

    public User getUserLogged() {
        return this.userLoggedIn;
    }

    public boolean isLoggedIn() {
        return this.userLoggedIn != null;
    }
}
