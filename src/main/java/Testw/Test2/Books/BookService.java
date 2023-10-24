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

    public List<BookDto> findByAuthor(@PathVariable String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        List<BookDto> bookDtos = new ArrayList<>();

        for (Book book : books) {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book, bookDto);
            bookDtos.add(bookDto);
        }

        return bookDtos;
    }

    public List<BookDto> getBooksByPriceRange(double minPrice, double maxPrice) {
        List<Book> books = bookRepository.findByPriceBetween(minPrice, maxPrice);
        List<BookDto> bookDtos = books.stream()
                .map(book -> {
                    BookDto bookDto = new BookDto();
                    BeanUtils.copyProperties(book, bookDto);
                    return bookDto;
                })
                .collect(Collectors.toList());

        return bookDtos;
    }


    public List<BookDto> getOutOfStockBooks() {
        List<Book> books = bookRepository.findByAvailableCopies(0);

        List<BookDto> bookDtos = books.stream()
                .map(book -> {
                    BookDto bookDto = new BookDto();
                    BeanUtils.copyProperties(book, bookDto); // Kopiowanie właściwości z Book do BookDto
                    return bookDto;
                })
                .collect(Collectors.toList());

        return bookDtos;
    }

}
