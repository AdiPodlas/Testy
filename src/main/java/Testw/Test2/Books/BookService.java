package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.BeanUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
        return convertToDtoList(books);
    }


    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return null;
        } else {
            return BookDto.fromBook(book);
        }
    }

    public List<BookDto> findByAuthor(@PathVariable String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        return convertToDtoList(books);
    }



    public List<BookDto> getBooksByPriceRange(double minPrice, double maxPrice) {
        List<Book> books = bookRepository.findByPriceBetween(minPrice, maxPrice);
        return convertToDtoList(books);
    }

    public List<BookDto> getOutOfStockBooks() {
        List<Book> books = bookRepository.findByAvailableCopies(0);

        return convertToDtoList(books);
    }

    private List<BookDto> convertToDtoList(List<Book> books) {
        List<BookDto> results = new ArrayList<>();

        for (Book book : books) {
            BookDto bookDto = BookDto.fromBook(book);
            results.add(bookDto);
        }
        return results;
    }

}
