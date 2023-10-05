package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

        void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getBooksByPriceRange(double minPrice, double maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Book> getOutOfStockBooks() {
        return bookRepository.findByAvailableCopies(0);
    }

}
