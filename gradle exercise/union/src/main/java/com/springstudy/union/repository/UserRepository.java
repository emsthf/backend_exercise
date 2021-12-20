package com.springstudy.union.repository;


import com.springstudy.union.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(int id);
    Optional<User> findByName(String name);
}
