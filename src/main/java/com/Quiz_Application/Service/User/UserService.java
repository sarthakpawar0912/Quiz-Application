package com.Quiz_Application.Service.User;
import com.Quiz_Application.Entities.User;
public interface UserService
{
    User createUser(User user);

    boolean hasUserWithEmail(String email);

    User login(User user);
}
