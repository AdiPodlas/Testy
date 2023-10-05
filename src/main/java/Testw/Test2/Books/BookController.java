package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @GetMapping("/search/byAuthor")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return bookRepository.findByAuthor(author);
    }

    @GetMapping("/search/byPriceRange")
    public List<Book> getBooksByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/search/notInStock")
    public List<Book> getBooksNotInStock() {
        return bookRepository.findByAvailableCopies(0);
    }
}
