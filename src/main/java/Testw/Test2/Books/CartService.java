package Testw.Test2.Books;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CartService {

    @Autowired private CartRepository cartRepository;

    @Autowired private BookRepository bookRepository;

    public Cart addCart() {
        return cartRepository.save(new Cart());
    }


    public List<Cart> getAllCarts() {                    //Zamienić na List cartDto
        return cartRepository.findAll();
    }

    public CartDto addBook(Long id, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        Cart cart = cartRepository.findById(id).orElseThrow();
        cart.getBooks().add(book);
        cartRepository.save(cart);
        return CartDto.fromCart(cart);
    }
}
