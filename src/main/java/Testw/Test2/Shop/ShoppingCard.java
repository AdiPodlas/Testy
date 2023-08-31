package Testw.Test2.Shop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCard {
    private List<Product> productList;

    public ShoppingCard(){
        this.productList = new ArrayList<>();
    }
    public void addProductToShoppingCard (Product product){
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void removeAll(){
        productList.clear();
    }

    public void removeProduct(int index){
        if (index < productList.size()){
            productList.remove(index);
        }

    }
}
