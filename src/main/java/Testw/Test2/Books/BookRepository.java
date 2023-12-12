package Testw.Test2.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByPriceBetween(double minPrice, double maxPrice);
    List<Book> findByAvailableCopies(int availableCopies);
    @Query("SELECT b FROM Cart c join c.books b where b.availableCopies = 0")
    List<Book> findRequseted();

}


