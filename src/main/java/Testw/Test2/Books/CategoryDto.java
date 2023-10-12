package Testw.Test2.Books;

public class CategoryDto {
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    private Long id;
    private String name;
    private String description;
    private int  numberOfBooks;

    static CategoryDto fromCategory(Category category){
        CategoryDto result = new CategoryDto();
        result.id = category.getId();
        result.name = category.getName();
        result.description = category.getDescription();
        result.numberOfBooks = category.getBooks().size();
        return result;
    }

}
