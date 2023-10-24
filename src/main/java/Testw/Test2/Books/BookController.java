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
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/search/byAuthor")
    public List<BookDto> getBooksByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/search/byPriceRange")
    public List<BookDto> getBooksByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return bookService.getBooksByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/search/notInStock")
    public List<BookDto> getBooksNotInStock() {
        return bookService.getOutOfStockBooks();
    }

    @PutMapping("/{bookId}/category")
    public BookDto setCategory(@PathVariable Long bookId, @RequestBody Long categoryId){
        System.out.println("SOUT " + bookId + " " + categoryId);
        return bookService.setCategory(bookId, categoryId);
    }
}
