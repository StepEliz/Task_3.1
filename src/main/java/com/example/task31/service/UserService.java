package com.example.task31.service;

import com.example.task31.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User getUserById(int id);
    void deleteUser(int id);
    void update(User user);
    List<User> getUsers();
}
