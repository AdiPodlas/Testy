package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static Testw.Test2.Books.BookDto.convertToDtoList;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> resultList = new ArrayList<>();
        for (Category category : categories) {
            CategoryDto categoryDto = CategoryDto.fromCategory(category);
            resultList.add(categoryDto);
        }
        return resultList;
    }

    public Double getTotalValue(Long id) {            //Przepisać na JPQL
        Category category = categoryRepository.findById(id).orElseThrow();
        List<Book> categoryBooks = category.getBooks();
        double result = 0;
        for (Book book : categoryBooks) {
            double value = book.getPrice() * book.getAvailableCopies();
            result = result + value;
        }
        return result;
    }

    public Double getAvglValueOfCategory(Long id) {   //Przepisać na JPQL
        Category category = categoryRepository.findById(id).orElseThrow();
        List<Book> categoryBooks = category.getBooks();
        double result = 0;
        int totalBooks = categoryBooks.size();

            for (Book book : categoryBooks) {
                double value = book.getPrice();
                result = result + value;

            }
            return result / totalBooks;
        }

    public List<BookDto> getAllBooksFromCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        List<Book> categoryBooks = category.getBooks();
        return convertToDtoList(categoryBooks);
    }

    }



