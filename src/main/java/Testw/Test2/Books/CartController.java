package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")

public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart addCart() {
        return cartService.addCart();
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PostMapping("/{id}/books/{bookId}")
    public CartDto addBook(@PathVariable Long id, @PathVariable Long bookId){
        return cartService.addBook(id, bookId);
    }

}

