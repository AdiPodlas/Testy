package Testw.Test2.Books;

import java.util.ArrayList;
import java.util.List;

public class CartDto {

    private Long id;
    private List<BookDto> books;

    public Long getId() {
        return id;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    static CartDto fromCart(Cart cart) {
        CartDto result = new CartDto();
        result.id = cart.getId();
        result.books = new ArrayList<>();

        for (Book book : cart.getBooks()) {
            result.books.add(BookDto.fromBook(book));
        }
        return result;
    }

    static List<CartDto> convertToDtoList(List<Cart> carts) {
        List<CartDto> results = new ArrayList<>();

        for (Cart cart : carts) {
            CartDto cartDto = CartDto.fromCart(cart);
            results.add(cartDto);
        }
        return results;
    }
}




