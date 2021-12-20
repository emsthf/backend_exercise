package com.springstudy.union.repository;

import com.springstudy.union.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;


public class UserRepositoryImpl implements UserRepository{

    private static Map<Integer, User> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public User save(User user) {
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream().filter(user -> user.getName().equals(name)).findAny();
    }


}
