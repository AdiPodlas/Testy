package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;

public class UserWithTotalCartValueDto {

    @Autowired
    private UserService userService;

    private UserDTO user;
    private Double cartsTotal;

    public UserWithTotalCartValueDto(UserDTO user, Double cartsTotal) {
        this.user = user;
        this.cartsTotal = cartsTotal;
    }

    public UserDTO getUser() {
        return user;
    }

    public Double getCartsTotal() {
        return cartsTotal;
    }
}

