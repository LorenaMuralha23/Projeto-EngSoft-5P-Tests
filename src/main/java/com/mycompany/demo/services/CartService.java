/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demo.services;

import com.mycompany.demo.controller.SessionController;
import com.mycompany.demo.entities.Cart;
import com.mycompany.demo.entities.CartItem;
import com.mycompany.demo.entities.OrderItem;
import com.mycompany.demo.entities.Product;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.entities.pk.CartItemPK;
import com.mycompany.demo.repositories.CartItemRepository;
import com.mycompany.demo.repositories.CartRepository;
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

    public void createCart() {
        Cart cart = new Cart(SessionController.getInstance().getUserLogged());
        SessionController.getInstance().getUserLogged().setCart(cart);
        repository.save(cart);
    }

    public void addProductToCart(Product product, Integer quantity) {
        User userLogged = SessionController.getInstance().getUserLogged();
        Cart cart = userLogged.getCart();
        if (cart == null) {
            createCart();
            cart = userLogged.getCart();
        }
        CartItem item = new CartItem(cart, product, quantity, product.getPrice());
        cart.getItems().add(item);
        itemRepository.save(item);
    }

    public Optional<CartItem> getCartItemById(Integer id) {
        return itemRepository.findById(id);
    }

    public void cleanCart() {
        itemRepository.deleteAll();
        SessionController.getInstance().getUserLogged().getCart().getItems().clear();
    }

    public void deleteItem(Product productToDelete) {
        Optional<CartItem> obj = itemRepository.findByProductId(productToDelete.getId());
        CartItem item = obj.orElse(null);
        if (item != null) {
            itemRepository.deleteByProductId(productToDelete.getId());
            removeCartItem(SessionController.getInstance().getUserLogged(), item);
        }
        System.out.println("Número de items: "+ SessionController.getInstance().getUserLogged().getCart().getItems().size());
        
    }  
    
    public void removeCartItem(User user, CartItem itemToRemove) {
        // Obtém o carrinho do usuário
        Cart cart = user.getCart();

        // Verifica se o carrinho existe e se o item está presente no carrinho
        if (cart != null && cart.getItems().contains(itemToRemove)) {
            // Remove o item do carrinho
            System.out.println("O objeto esta presente!");
            boolean deleted = cart.getItems().remove(itemToRemove);
            if (deleted){
                System.out.println("Objeto deletado");
            }else{
                System.out.println("Sapoha nem chega :)");
            }
        }
    }


}
