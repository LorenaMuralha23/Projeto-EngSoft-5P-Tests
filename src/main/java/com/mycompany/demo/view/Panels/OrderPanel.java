package com.mycompany.demo.view.Panels;

import com.mycompany.demo.EcommerceT1LpApplication;
import com.mycompany.demo.controller.SessionController;
import com.mycompany.demo.entities.Order;
import com.mycompany.demo.entities.Payment;
import java.text.DecimalFormat;
import java.time.Instant;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.springframework.stereotype.Component;

@Component
public class OrderPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderPanel
     */
    public OrderPanel() {
        initComponents();
    }

    public void startScreenInfo() {
        nameLabel.setText(EcommerceT1LpApplication.mainFrame.userController.getUserLogged(SessionController.getInstance()).getName());
        DecimalFormat df = new DecimalFormat("#.##");
        subtotalLabel.setText(df.format(EcommerceT1LpApplication.mainFrame.cartController.getSubtotal(SessionController.getInstance())));

        streetField.setText(EcommerceT1LpApplication.mainFrame.userController.getAddress(SessionController.getInstance()).getStreet());
        stateField.setText(EcommerceT1LpApplication.mainFrame.userController.getAddress(SessionController.getInstance()).getState());
        numberField.setText(EcommerceT1LpApplication.mainFrame.userController.getAddress(SessionController.getInstance()).getNumber());

        startInstallmentNum();
    }

    public void startInstallmentNum() {
        double subtotal = EcommerceT1LpApplication.mainFrame.cartController.getSubtotal(SessionController.getInstance());
        int numInstallments = EcommerceT1LpApplication.mainFrame.cartController.calculateInstallments(subtotal);

        installmentsCB.removeAllItems();

        for (int i = 1; i <= numInstallments; i++) {
            double installmentValue = subtotal / i;
            String installmentText = i + "x de R$" + String.format("%.2f", installmentValue);
            installmentsCB.addItem(installmentText);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        streetField = new javax.swing.JTextField();
        numberField = new javax.swing.JTextField();
        stateField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        installmentsCB = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        subtotalLabel = new javax.swing.JLabel();
        checkOutBtn = new javax.swing.JButton();
        creditCardOpt = new javax.swing.JRadioButton();
        pixOpt = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Finishing your Order");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Shipping Address");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Your Name:");

        nameLabel.setText("Nome do Usuário Aqui");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Personal Information:");

        streetField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel6.setText("Street:");

        jLabel7.setText("State:");

        jLabel8.setText("Number:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Paymento Option:");

        jLabel11.setText("Card Number:");

        jLabel12.setText("Name on card:");

        jLabel13.setText("CVV:");

        installmentsCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1x", "2x", "3x", "3x" }));

        jLabel14.setText("Number of Installments:");

        jButton1.setText("Generate QR Code");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setText("SUBTOTAL: R$");

        jLabel17.setText("Codigo aqui");

        subtotalLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        subtotalLabel.setText("0.00");

        checkOutBtn.setText("Check Out");
        checkOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkOutBtnMouseClicked(evt);
            }
        });

        buttonGroup1.add(creditCardOpt);
        creditCardOpt.setText("Credit Card");
        creditCardOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditCardOptActionPerformed(evt);
            }
        });

        buttonGroup1.add(pixOpt);
        pixOpt.setText("PIX");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(nameLabel)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(streetField, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(stateField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel11))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(checkOutBtn)
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(subtotalLabel))))
                            .addComponent(installmentsCB, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addGap(637, 637, 637))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pixOpt)
                            .addComponent(creditCardOpt))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(creditCardOpt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(3, 3, 3)
                .addComponent(installmentsCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(pixOpt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(subtotalLabel))
                        .addGap(27, 27, 27)
                        .addComponent(checkOutBtn)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkOutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkOutBtnMouseClicked

        if (creditCardOpt.isSelected() || pixOpt.isSelected()) {
            Order order = EcommerceT1LpApplication.mainFrame.cartController.covertCartToOrder(SessionController.getInstance());
            Payment payment;

            if (creditCardOpt.isSelected()) {
                payment = EcommerceT1LpApplication.mainFrame.paymentController.generatePayment(Instant.now(), order, 1);
            } else {
                payment = EcommerceT1LpApplication.mainFrame.paymentController.generatePayment(Instant.now(), order, 2);
            }
            order.setPayment(payment);
            JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
            EcommerceT1LpApplication.mainFrame.changeWindow(window, this, EcommerceT1LpApplication.mainFrame.fshOrderPanel);
            EcommerceT1LpApplication.mainFrame.fshOrderPanel.startInfo(order);

        } else {
            System.out.println("Please select a payment method to proceed!");
        }

    }//GEN-LAST:event_checkOutBtnMouseClicked

    private void creditCardOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditCardOptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditCardOptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton checkOutBtn;
    private javax.swing.JRadioButton creditCardOpt;
    private javax.swing.JComboBox<String> installmentsCB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField numberField;
    private javax.swing.JRadioButton pixOpt;
    private javax.swing.JTextField stateField;
    private javax.swing.JTextField streetField;
    private javax.swing.JLabel subtotalLabel;
    // End of variables declaration//GEN-END:variables
}
