package ru.icl.service;

import ru.icl.models.User;

public interface UserService {

    User findByUsername(String username);

    void saveUser(User user);
}
