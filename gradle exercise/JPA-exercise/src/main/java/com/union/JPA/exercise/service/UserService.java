package com.union.JPA.exercise.service;

import com.union.JPA.exercise.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    Optional<User> getUser(int id);
    void delUser(int id);
    List<User>getAllUser();
}
