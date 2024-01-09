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
    public List<CartDto> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PostMapping("/{id}/books/{bookId}")
    public CartDto addBook(@PathVariable Long id, @PathVariable Long bookId) {
        return cartService.addBook(id, bookId);
    }

    @GetMapping("/{id}/total-value")
    public Double getTotalValueOfCart(@PathVariable Long id) {
        return cartService.getTotalValueOfCart2(id);
    }

    @GetMapping("/requested")
    public List<BookDto> getRequestedBooks() {
        return cartService.getRequestedBooks2();
    }


    @PutMapping ("/{id}/owner/{ownerId}")
    public CartDto assignOwner(@PathVariable Long id, @PathVariable Long ownerId){return cartService.assignOwner(id, ownerId);}
}
