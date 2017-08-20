package ru.itpark.service;

import ru.itpark.models.User;

import java.util.Set;

public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    User createUser(User user);

    User saveUser (User user);
}
