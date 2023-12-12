package Testw.Test2.Books;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Testw.Test2.Books.CartDto.convertToDtoList;

@Service

public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookRepository bookRepository;

    public Cart addCart() {
        return cartRepository.save(new Cart());
    }


    public List<CartDto> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        return convertToDtoList(carts);
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
        return result;
    }

    public List<BookDto> getRequestedBooks() {
        List<Cart> carts = cartRepository.findAll();
        Set<Book> booksInCarts = new HashSet<>();

        for (Cart cart : carts) {
            if (cart.getBooks() != null) {
                booksInCarts.addAll(cart.getBooks());
            }
        }

        List<BookDto> requestedBookDtos = new ArrayList<>();
        for (Book requestedBook : booksInCarts) {
            if (requestedBook.getAvailableCopies() == 0) {
                requestedBookDtos.add(BookDto.fromBook(requestedBook));
            }
        }
        return requestedBookDtos;
    }

    public List<BookDto> getRequestedBooks2(){
        return  BookDto.convertToDtoList(bookRepository.findRequseted());
    }

    public Double getTotalValueOfCart2(Long id){
        return cartRepository.getTotal(id);
    }
}
