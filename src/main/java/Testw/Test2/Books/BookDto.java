package Testw.Test2.Books;

public class BookDto {

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public String getCategoryName() {
        return categoryName;
    }

    private Long id;
    private String title;
    private String author;
    private double price;
    private int availableCopies;

    private String categoryName;


    static BookDto fromBook(Book book) {
        BookDto result = new BookDto();
        result.id = book.getId();
        result.title = book.getTitle();
        result.author = book.getAuthor();
        result.price = book.getPrice();
        result.availableCopies = book.getAvailableCopies();
        if (book.getCategory() != null) {
            result.categoryName = book.getCategory().getName();
        } else {
            result.categoryName = "Brak kategorii";
        }
        return result;
    }


}
