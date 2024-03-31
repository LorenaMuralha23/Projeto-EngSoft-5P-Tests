/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demo.services;

import com.mycompany.demo.controller.SessionController;
import com.mycompany.demo.entities.Cart;
import com.mycompany.demo.entities.CartItem;
import com.mycompany.demo.entities.Order;
import com.mycompany.demo.entities.OrderItem;
import com.mycompany.demo.entities.Product;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.entities.enums.OrderStatus;
import com.mycompany.demo.entities.pk.CartItemPK;
import com.mycompany.demo.repositories.CartItemRepository;
import com.mycompany.demo.repositories.CartRepository;
import java.time.Instant;
import java.util.Optional;
import java.util.Set;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepository repository;

    @Autowired
    CartItemRepository itemRepository;

    public CartService() {
    }

    public void createCart(User userLogged, SessionController session) {
        Cart cart = new Cart(userLogged);
        session.getUserLogged().setCart(cart);
        repository.save(cart);
    }

    public void addProductToCart(Product product, Integer quantity, SessionController session) {
        User userLogged = session.getUserLogged();
        Cart userCart = userLogged.getCart();
        if (userCart == null) {
            createCart(userLogged, session);
            userCart = userLogged.getCart();
        }
        CartItem item = new CartItem(userCart, product, quantity, product.getPrice());
        userCart.getItems().add(item);
        itemRepository.save(item);
    }

    public Optional<CartItem> getCartItemById(Integer id) {
        return itemRepository.findById(id);
    }

    public void cleanCart(User userLogged) {
        if (userLogged != null) {
            Cart cart = userLogged.getCart();
            if (cart != null && !cart.getItems().isEmpty()) {
                itemRepository.deleteAll();
                cart.getItems().clear();
            }
        }
    }

    public CartItem deleteItem(Product productToDelete, SessionController session) {
        User userLogged = session.getUserLogged();
        Optional<CartItem> obj = itemRepository.findByProductId(productToDelete.getId());
        CartItem item = obj.orElse(null);
        if (item != null) {
            itemRepository.deleteByProductId(productToDelete.getId());
            removeCartItem(userLogged, item);
            return item;
        }
        return null;
    }

    public boolean removeCartItem(User user, CartItem itemToRemove) {
        // Obtém o carrinho do usuário
        Cart cart = user.getCart();
        boolean deleted = false;
        // Verifica se o carrinho existe e se o item está presente no carrinho
        if (cart != null && cart.getItems().contains(itemToRemove)) {
            // Remove o item do carrinho
            deleted = cart.getItems().remove(itemToRemove);
        }
        return deleted;
    }

    public Double getSubtotal(SessionController session) {
        return session.getUserLogged().getCart().getSubtotal();
    }

    public Order covertCartToOrder(SessionController session) {
        User userLogged = session.getUserLogged();
        Order order = new Order(null, Instant.now(), OrderStatus.SHIPPED, userLogged); //por agora, todos os orders terão o status de Shipped
        for (CartItem item : userLogged.getCart().getItems()) {
            OrderItem orderItem = new OrderItem(order, item.getProduct(), item.getQuantity(), item.getPrice());
            order.getOrderItems().add(orderItem);
        }
        cleanCart(userLogged);

        return order;
    }

    public int calculateInstallments(double totalValue) {
        double minInstallmentValue = 20.0;

        // Se o valor total for menor ou igual ao valor mínimo de uma parcela, retorna 1
        if (totalValue <= minInstallmentValue) {
            return 1;
        }

        int numInstallments = (int) Math.floor(totalValue / minInstallmentValue);
        
        if (totalValue%numInstallments == 0) {
            numInstallments--;
        }

        return numInstallments;
    }

}
