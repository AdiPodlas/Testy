package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
    //    for (Category category : categories) {
    //        System.out.println(category.getBooks());
    //    }
        return categories;
    }
}

