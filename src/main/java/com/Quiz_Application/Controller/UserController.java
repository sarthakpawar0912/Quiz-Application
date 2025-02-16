package com.Quiz_Application.Controller;

import com.Quiz_Application.Entities.User;
import com.Quiz_Application.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody User user) {
        if (userService.hasUserWithEmail(user.getEmail())) {
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }

        User createdUser = userService.createUser(user);
        if (createdUser == null) {
            return new ResponseEntity<>("User not created, please try again later", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED); // Status 201 Created
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User dbUser = userService.login(user);
        if (dbUser == null) {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED); // 401
        }
        return new ResponseEntity<>(dbUser, HttpStatus.OK);
    }
}
