package Testw.Test2.Shop;

public class Product {

    private long id;
    private String name;

    public Product(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
