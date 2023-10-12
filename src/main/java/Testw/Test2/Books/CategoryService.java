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
}

