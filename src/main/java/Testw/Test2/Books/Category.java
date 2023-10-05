package Testw.Test2.Books;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public List<Book> getBooks() {
        return books;
    }
    @OneToMany(mappedBy="category")
    private List<Book> books;
}
