package com.Quiz_Application.Service.User;

import com.Quiz_Application.Entities.User;
import com.Quiz_Application.Enums.UserRole;
import com.Quiz_Application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void createAdminUser() {
        Optional<User> optionalUser = userRepository.findByRole(UserRole.ADMIN);
        if (optionalUser.isEmpty()) { // Corrected null check
            User user = new User();
            user.setName("Admin");
            user.setEmail("admin@test.com");
            user.setRole(UserRole.ADMIN);
            user.setPassword("admin"); // Consider encrypting the password
            userRepository.save(user);
        }
    }

    public boolean hasUserWithEmail(String email) {
        return userRepository.existsByEmail(email); // Fixed email existence check
    }

    public User createUser(User user) {
        user.setRole(UserRole.USER); // Default role for new users
        return userRepository.save(user);
    }

    @Override
    public User login(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail()); // Fixed method call
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(user.getPassword())) {
            return optionalUser.get();
        }
        return null; // Invalid credentials
    }

}
