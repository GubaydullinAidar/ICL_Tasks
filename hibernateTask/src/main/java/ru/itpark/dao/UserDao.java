package ru.itpark.dao;

import ru.itpark.models.User;

public interface UserDao {
    User findByUsername(String username);

    User findByEmail(String email);

    User save(User user);
}
