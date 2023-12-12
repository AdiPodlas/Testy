package Testw.Test2.Books;

import jakarta.persistence.*;

@Entity
@Table( name = "shopUsers")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String email;

    @OneToOne()
    private Address address;

    @OneToOne
    private Address deliveryAddress;

}
