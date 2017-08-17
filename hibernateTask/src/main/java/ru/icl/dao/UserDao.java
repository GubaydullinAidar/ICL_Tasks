package ru.icl.dao;

import org.springframework.stereotype.Component;
import ru.icl.models.User;

import java.util.List;

@Component
public interface UserDao {
    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAll();

    void save(User user);
}
