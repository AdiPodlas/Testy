package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> resultList = new ArrayList<>();
        for (Book book : books) {
            BookDto bookDto = BookDto.fromBook(book);
            resultList.add(bookDto);
        }
        return resultList;
    }


    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return null;
        } else {
            return BookDto.fromBook(book);
        }


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
