package com.springstudy.union.controller;

import com.springstudy.union.model.User;
import com.springstudy.union.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/new")
    public String createForm(){
        return "users/createUserForm";
    }

    @PostMapping(value = "/users/new")
    public String create(UserForm userForm) {

        User user1 = new User();
        user1.setName(userForm.getName());

        userService.addUser(user1);

        return "redirect:/";
    }

    @GetMapping(value = "/users")
    public String list(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/userList";
    }

}
