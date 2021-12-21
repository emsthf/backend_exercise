package com.mapping.table.service;

import com.mapping.table.post.model.User;
import com.mapping.table.post.repository.UserRepository;
import com.mapping.table.post.service.UserService;
import com.mapping.table.post.service.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    UserService userService;
    UserRepository userRepository;

    @BeforeEach
    public void beforeEach() {
        userService = new UserServiceImpl(userRepository);
    }

    @AfterEach
    @Test
    public void addUser() {
        User user1 = new User("union", "sol", "asdfqwer", "aa@gmail.com", "korea", "20010101", "01012345678", "1234");
        user1.setId(1L);
        System.out.println("user1 = " + user1);

        userService.addUser(user1);
    }
}
