package Testw.Test2.Books;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToMany
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

}
