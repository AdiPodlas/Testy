package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
class BookController {
   
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/search/byAuthor")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/search/byPriceRange")
    public List<Book> getBooksByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return bookService.getBooksByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/search/notInStock")
    public List<Book> getBooksNotInStock() {
        return bookService.getOutOfStockBooks();
    }
}
