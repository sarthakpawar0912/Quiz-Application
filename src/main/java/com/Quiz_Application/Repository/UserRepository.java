package com.Quiz_Application.Repository;

import com.Quiz_Application.Entities.User;
import com.Quiz_Application.Enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByRole(UserRole role); // Ensure it returns Optional<User>
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
