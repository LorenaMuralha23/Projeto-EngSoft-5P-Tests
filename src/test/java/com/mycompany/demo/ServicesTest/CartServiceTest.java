package com.mycompany.demo.ServicesTest;

import com.mycompany.demo.controller.SessionController;
import com.mycompany.demo.entities.Cart;
import com.mycompany.demo.entities.CartItem;
import com.mycompany.demo.entities.Order;
import com.mycompany.demo.entities.Product;
import com.mycompany.demo.entities.User;
import com.mycompany.demo.repositories.CartItemRepository;
import com.mycompany.demo.repositories.CartRepository;
import com.mycompany.demo.services.CartService;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 *
 * @author USER
 */
public class CartServiceTest {

    @InjectMocks
    private CartService service;

    @Mock
    private CartRepository repository;

    @Mock
    private CartItemRepository itemRepository;

    @Mock
    private SessionController sessionControllerMock;

    private User userTest;
    
    public CartServiceTest() {
    }

    @BeforeEach
    public void setUp() {
        openMocks(this);
        userTest = new User();
        when(sessionControllerMock.getUserLogged()).thenReturn(userTest);
    }

    /**
     * Test of createCart method, of class CartService.
     */
    @Test
    public void testCreateCart() {
        Cart expectedCart = new Cart(userTest);
        
        
        when(repository.save(any(Cart.class))).thenReturn(expectedCart);

        service.createCart(userTest, sessionControllerMock);
        
        verify(sessionControllerMock, times(1)).getUserLogged();
        verify(repository, times(1)).save(expectedCart);
    }

    /**
     * Test of addProductToCart method, of class CartService.
     */
    @Test
    public void testAddProductToCartIfCartIsNull() {
        Product product = new Product(); // Criando um produto simulado
        Integer quantity = 1; // Definindo a quantidade
        User userLogged = new User(); // Criando um usuário simulado
        Cart cart = new Cart(userLogged); // Criando um carrinho simulado
        cart.setItems(new HashSet<>()); // Inicializando a lista de itens do carrinho

        // Definindo comportamento do mock da sessão
        when(session.getUserLogged()).thenReturn(userLogged);

        // Definindo comportamento do mock do repositório de itens
        when(itemRepository.save(any(CartItem.class))).thenAnswer(invocation -> {
            CartItem item = invocation.getArgument(0);
            cart.getItems().add(item);
            return item;
        });

        // Definindo comportamento do mock do serviço de carrinho para evitar a criação de um novo carrinho
        doNothing().when(cartService).createCart(any(User.class), any(SessionController.class));
        
        // Definindo o carrinho do usuário na sessão
        userLogged.setCart(cart);

        // Act
        cartService.addProductToCart(product, quantity, session);

        // Assert
        verify(session, times(1)).getUserLogged(); // Verifica se o método getUserLogged foi chamado uma vez
        verify(itemRepository, times(1)).save(any(CartItem.class)); // Verifica se o método save do repositório de itens foi chamado uma vez
        assertEquals(1, cart.getItems().size()); // Verifica se o item foi adicionado ao carrinho
    }
    }

    /**
     * Test of getCartItemById method, of class CartService.
     */
    @Test
    public void testGetCartItemById() {
    }

    /**
     * Test of cleanCart method, of class CartService.
     */
    @Test
    public void testCleanCart() {
    }

    /**
     * Test of deleteItem method, of class CartService.
     */
    @Test
    public void testDeleteItem() {
    }

    /**
     * Test of removeCartItem method, of class CartService.
     */
    @Test
    public void testRemoveCartItem() {
    }

    /**
     * Test of getSubtotal method, of class CartService.
     */
    @Test
    public void testGetSubtotal() {
    }

    /**
     * Test of covertCartToOrder method, of class CartService.
     */
    @Test
    public void testCovertCartToOrder() {
    }

    /**
     * Test of calculateInstallments method, of class CartService.
     */
    @Test
    public void testCalculateInstallments() {
    }

}
