package ru.icl.dao;

import ru.icl.models.User;

import java.util.List;

public interface UserDao {

    User getUserById(Long id);

    void updateUser(User user);
}
