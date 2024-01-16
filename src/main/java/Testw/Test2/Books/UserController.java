package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserService userService;


    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.getUserById(id);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}/carts")
    public List<CartDto> getUserCarts(@PathVariable Long userId) {
        return userService.getUserCarts(userId);
    }

    @GetMapping("/{userId}/carts/total-value")
    public ResponseEntity<Double> getTotalCartValueForUser(@PathVariable Long userId) {
        Double totalValue = userService.getTotalCartValueForUser(userId);

        if (totalValue != null) {
            return ResponseEntity.ok(totalValue);
        }
        return ResponseEntity.notFound().build();
    }

}