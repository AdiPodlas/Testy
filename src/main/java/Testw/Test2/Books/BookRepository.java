package Testw.Test2.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByPriceBetween(double minPrice, double maxPrice);
    List<Book> findByAvailableCopies(int availableCopies);
}
