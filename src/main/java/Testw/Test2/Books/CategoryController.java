package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping ("/{id}/total-value")
    public Double getTotalValue(@PathVariable Long id){ return categoryService.getTotalValue(id); }

    @GetMapping ("/{id}/total-valueAll")
    public Double getTotalValueOfCategory(@PathVariable Long id){ return categoryService.getTotalValueOfCategory(id); }

    @GetMapping("/{id}/books")
    public List<BookDto> getAllBooksFromCategory(@PathVariable Long id){return categoryService.getAllBooksFromCategory(id);}
}
