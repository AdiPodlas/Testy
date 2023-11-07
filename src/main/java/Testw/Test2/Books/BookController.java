package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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



    @PutMapping("/{bookId}/title")
    public ResponseEntity<String> updateTitle(@PathVariable Long bookId, @RequestBody String newTitle) {
        bookService.updateTitle(bookId, newTitle);
        return ResponseEntity.ok("Tytuł książki został zaktualizowany.");
    }


    @PutMapping("/{bookId}/author")
    public ResponseEntity<String> updateAuthor(@PathVariable Long bookId, @RequestBody String newAuthor) {
        bookService.updateAuthor(bookId, newAuthor);
        return ResponseEntity.ok("Autor książki został zaktualizowany.");
    }

    @PutMapping("/{bookId}/price")
    public ResponseEntity<String> setPrice(@PathVariable Long bookId, @RequestBody Double newPrice) {
        bookService.updatePrice(bookId, newPrice);
        return ResponseEntity.ok("Cena książki została zaktualizowana.");
    }

    @PutMapping("/{bookId}/quantity")
    public ResponseEntity<String> updateQuantity(@PathVariable Long bookId, @RequestBody int newQuantity) {
        bookService.updateQuantity(bookId, newQuantity);
        return ResponseEntity.ok("Liczba dostępnych sztuk książki została zaktualizowana.");
    }
}

