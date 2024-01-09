package Testw.Test2.Books;

public class AdressDTO {

    private Long id;
    private String city;
    private String street;
    private String number;
    private String apartment;

    // Constructors, getters, and setters

    public AdressDTO() {
    }

    public AdressDTO(Long id, String city, String street, String number, String apartment) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.number = number;
        this.apartment = apartment;
    }

    public static AdressDTO fromAdress(Adress adress) {
        AdressDTO result = new AdressDTO();
        result.id = adress.getId();
        result.city = adress.getCity();
        result.street = adress.getStreet();
        result.number = adress.getNumber();
        result.apartment = adress.getApartment();
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}