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

        if (optionalUser.isEmpty()) { // Ensure the admin user is only created if it doesn't exist
            User user = new User();
            user.setName("Admin");
            user.setEmail("admin@test.com");
            user.setRole(UserRole.ADMIN);
            user.setPassword("admin"); // Simple password, no encryption
            userRepository.save(user);
        }
    }

    @Override
    public Boolean hasUserWithEmail(String email) {
        return userRepository.existsByEmail(email); // Use existsByEmail for checking email existence
    }

    @Override
    public User createUser(User user) {
        user.setRole(UserRole.USER); // Set the role for the new user
        return userRepository.save(user); // Save the user with the plain password
    }

    @Override
    public User login(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(user.getPassword())) {
            return optionalUser.get(); // Password match
        }
        return null; // Invalid credentials
    }
}
