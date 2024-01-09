package Testw.Test2.Books;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private AdressDTO adress;
    private AdressDTO deliveryAdress;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, AdressDTO address, AdressDTO deliveryAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.deliveryAdress = deliveryAdress;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdressDTO getAdress() {
        return adress;
    }

    public void setAddress(AdressDTO adress) {
        this.adress = adress;
    }

    public AdressDTO getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAddress(AdressDTO deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }
}