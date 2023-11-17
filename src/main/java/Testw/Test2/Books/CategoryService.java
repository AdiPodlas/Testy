package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Double getTotalValue(Long id){
       Category category = categoryRepository.findById(id).orElseThrow();   //średnia cena do zrobić jako homework
        List<Book> categoryBooks = category.getBooks();                     //podzielić przez ilość książek
        double result = 0;                                                  //categoryBoks.size - ilość książek w kategorii
        for (Book book : categoryBooks) {
            double value = book.getPrice() * book.getAvailableCopies();
            result = result + value;
        }
        return result;
    }

}


