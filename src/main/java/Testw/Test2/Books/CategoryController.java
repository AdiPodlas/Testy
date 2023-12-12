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

  // @GetMapping ("/{id}/total-value")
  // public Double getTotalValue(@PathVariable Long id){ return categoryService.getTotalValue(id); }

    @GetMapping ("/{id}/total-valueAll")
    public Double getTotalValueOfCategory(@PathVariable Long id){ return categoryService.getAvglValueOfCategory(id); }

    @GetMapping("/{id}/books")
    public List<BookDto> getAllBooksFromCategory(@PathVariable Long id){return categoryService.getAllBooksFromCategory(id);}

    @GetMapping("/{categoryId}/average-price")
    public Double getAveragePrice(@PathVariable Long categoryId) {
        return categoryService.getAvglValueOfCategory2(categoryId);
    }

    @GetMapping("/{id}/total-value")
    public Double getTotalValue2(@PathVariable Long id) {
        return categoryService.getTotalValue(id);
    }

}
