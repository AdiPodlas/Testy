package Testw.Test2.Books;

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
        result.id = cart.getId();                //trzeba dodać result books
        return result;
    }
}
