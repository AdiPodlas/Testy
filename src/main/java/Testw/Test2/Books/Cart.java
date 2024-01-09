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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToOne
    private User owner;

    public Long getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

}
