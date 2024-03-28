package com.mycompany.demo.view.Panels;

import com.mycompany.demo.EcommerceT1LpApplication;
import com.mycompany.demo.entities.CartItem;
import com.mycompany.demo.entities.Product;
import com.mycompany.demo.entities.User;
import java.util.Optional;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.springframework.stereotype.Component;

@Component
public class CartPanel extends javax.swing.JPanel {

    DefaultTableModel model;

    public CartPanel() {
        initComponents();

        model = (DefaultTableModel) cartTable.getModel();

    }

    public void startTable() {
        Double subtotal = EcommerceT1LpApplication.mainFrame.cartController.getSubtotal();
        subTotalLabel.setText(String.valueOf(subtotal));
        User userLogged = EcommerceT1LpApplication.mainFrame.userController.getUserLogged();

        // Limpar a tabela antes de adicionar novos dados
        model.setRowCount(0);

        for (CartItem item : userLogged.getCart().getItems()) {
            // Criar um novo array de objetos para cada item do carrinho
            Object[] rowData = new Object[2]; // Supondo que você tenha duas colunas: nome do produto e quantidade

            // Adicionar os dados do item do carrinho ao array
            rowData[0] = item.getProduct().getName();
            rowData[1] = item.getQuantity();

            // Adicionar a nova linha à tabela
            model.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        deleteItemBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        subTotalLabel = new javax.swing.JLabel();
        fecharPedidoBtn = new javax.swing.JButton();

        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Products in the cart"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cartTable);

        jButton2.setText("Clean cart");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        deleteItemBtn.setText("Delete");
        deleteItemBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteItemBtnMouseClicked(evt);
            }
        });

        jLabel1.setText("Subtotal: R$");

        subTotalLabel.setText("0,00");

        fecharPedidoBtn.setText("Fechar Pedido");
        fecharPedidoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecharPedidoBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(170, 170, 170)
                .addComponent(jButton2)
                .addGap(73, 73, 73)
                .addComponent(deleteItemBtn)
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTotalLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(fecharPedidoBtn)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fecharPedidoBtn)
                        .addGap(32, 32, 32)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(deleteItemBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(subTotalLabel)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
        EcommerceT1LpApplication.mainFrame.changeWindow(window, this, EcommerceT1LpApplication.mainFrame.homePanel);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int choosedOptn = JOptionPane.showConfirmDialog(null, "Are you sure about that?\n" + "All the products in your cart will be removed");
        
        if (choosedOptn == 0) {
            EcommerceT1LpApplication.mainFrame.cartController.cleanCart();
            startTable();
        }
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void deleteItemBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteItemBtnMouseClicked
        int rowSelected = cartTable.getSelectedRow();
        System.out.println("Row index: " + rowSelected);
        if (rowSelected != -1) {
            Object valueObj = cartTable.getValueAt(rowSelected, 0);
            String productName = String.valueOf(valueObj);
            Optional<Product> obj = EcommerceT1LpApplication.mainFrame.productController.getProductByName(productName);
            Product productFinded = obj.orElse(null);
            EcommerceT1LpApplication.mainFrame.cartController.deleteItem(productFinded);
        }else{
            JOptionPane.showMessageDialog(null, "Select a product!");
        }
        
         startTable();
    }//GEN-LAST:event_deleteItemBtnMouseClicked

    private void fecharPedidoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharPedidoBtnMouseClicked
        if (!EcommerceT1LpApplication.mainFrame.userController.getUserCartItems().isEmpty()) {
            
        }
    }//GEN-LAST:event_fecharPedidoBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cartTable;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JButton fecharPedidoBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel subTotalLabel;
    // End of variables declaration//GEN-END:variables
}
