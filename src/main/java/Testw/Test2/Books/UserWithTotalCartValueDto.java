package Testw.Test2.Books;


public class UserWithTotalCartValueDto {

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

