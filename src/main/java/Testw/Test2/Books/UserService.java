package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AdressRepository adressRepository;

    @Autowired
    public UserService(UserRepository userRepository, AdressRepository adressRepository) {
        this.userRepository = userRepository;
        this.adressRepository = adressRepository;
    }


    public User addUser(User user) {
        if (user.getAdress() != null) {
            adressRepository.save(user.getAdress());
        }
        if (user.getDeliveryAdress() != null) {
            adressRepository.save(user.getDeliveryAdress());
        }

        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
}