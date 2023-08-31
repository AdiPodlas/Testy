package Testw.Test2.Shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Shop {
    @Autowired
    private ShoppingCard shoppingCard;

    @GetMapping("/shop")
    public ShoppingCard getShoppingCard() {
        return shoppingCard;
    }
    @PostMapping("/shop")
    public ShoppingCard purchase(@RequestBody Product product){
        shoppingCard.addProductToShoppingCard(product);
        return shoppingCard;
    }
    @DeleteMapping("/shop")
    public void clearCart(){
        shoppingCard.removeAll();
    }
    @DeleteMapping("/shop/{index}")
    public void removeProduct(@PathVariable int index){
        shoppingCard.removeProduct(index);
    }


    @GetMapping("/numbers")

    public List<Integer> numberList(){
        return List.of(1,2,3);
    }


}
