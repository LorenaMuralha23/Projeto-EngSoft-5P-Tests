/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.demo.view;

import com.mycompany.demo.controller.CartController;
import com.mycompany.demo.controller.PaymentController;
import com.mycompany.demo.controller.ProductController;
import com.mycompany.demo.controller.UserController;
import com.mycompany.demo.view.Panels.CartPanel;
import com.mycompany.demo.view.Panels.CreateAccountPanel;
import com.mycompany.demo.view.Panels.FinishedOrderPanel;
import com.mycompany.demo.view.Panels.HomePanel;
import com.mycompany.demo.view.Panels.LoginPanel;
import com.mycompany.demo.view.Panels.OrderPanel;
import jakarta.annotation.PostConstruct;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author USER
 */
@Component
public class MainFrame extends javax.swing.JFrame {

    @Autowired
    public UserController userController;

    @Autowired
    public CartController cartController;

    @Autowired
    public ProductController productController;

    @Autowired
    public PaymentController paymentController;

    public LoginPanel loginPanel = new LoginPanel();

    public CreateAccountPanel crtAccPanel = new CreateAccountPanel();

    public HomePanel homePanel = new HomePanel();

    public CartPanel cartPanel = new CartPanel();

    public OrderPanel orderPanel = new OrderPanel();

    public FinishedOrderPanel fshOrderPanel = new FinishedOrderPanel();

    public MainFrame() {
        initComponents();
    }

    @PostConstruct
    public void starting() {
        this.setLayout(new BorderLayout());

        this.add(this.loginPanel);
        this.pack();

        setLocationRelativeTo(null); // Centraliza o JFrame na tela
        setVisible(true); // Torna o JFrame visível
    }

    public void changeWindow(JFrame window, JPanel panelToRemove, JPanel panelToAdd) {
        window.getContentPane().remove(panelToRemove);
        window.add(panelToAdd, BorderLayout.CENTER);
        window.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
