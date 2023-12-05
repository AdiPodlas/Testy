package Testw.Test2.Books;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookRepository bookRepository;

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

    public Double getTotalValueOfCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        List<Book> cartBooks = cart.getBooks();
        double result = 0;
        int totalBooks = cartBooks.size();

        for (Book book : cartBooks) {
            double value = book.getPrice();
            result = result + value;

        }
        return result / totalBooks;
    }

    public List<BookDto> getRequestedBooks() {
        List<Cart> carts = cartRepository.findAll();
        Set<Book> booksInCarts = new HashSet<>();

        for (Cart cart : carts) {
            booksInCarts.addAll(cart.getBooks());
        }

        List<Book> allBooks = bookRepository.findAll();
        Set<Book> availableBooks = new HashSet<>(allBooks);

        Set<Book> requestedBooks = new HashSet<>();

        for (Book bookInCart : booksInCarts) {
            if (!availableBooks.contains(bookInCart)) {
                requestedBooks.add(bookInCart);
            }
        }

        List<BookDto> requestedBookDtos = new ArrayList<>();
        for (Book requestedBook : requestedBooks) {
            requestedBookDtos.add(BookDto.fromBook(requestedBook));
        }

        return requestedBookDtos;
    }
}
