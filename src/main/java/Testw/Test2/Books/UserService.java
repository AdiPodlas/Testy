package Testw.Test2.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AdressRepository adressRepository;
    private final CartRepository cartRepository;

    @Autowired
    public UserService(UserRepository userRepository, AdressRepository adressRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.adressRepository = adressRepository;
        this.cartRepository = cartRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
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

    public List<CartDto> getUserCarts(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Cart> userCarts = cartRepository.findByOwner(user);
            return CartDto.convertToDtoList(userCarts);
        }

        return Collections.emptyList();
    }
    public Double getTotalCartValueForUser(Long userId) {
        return userRepository.getTotalCartValueForUser(userId);
    }

    public List<UserWithTotalCartValueDto> getUsersWithTotalCartValue() {
        List<UserWithTotalCartValueDto> result = new ArrayList<>();

        List<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            Double totalCartValue = userRepository.getTotalCartValueForUser(user.getId());
            UserDTO userDto = UserDTO.fromUser(user);
            result.add(new UserWithTotalCartValueDto(userDto, totalCartValue));
        }

        return result;
    }
        }
