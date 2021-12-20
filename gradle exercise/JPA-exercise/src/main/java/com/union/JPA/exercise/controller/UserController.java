package com.union.JPA.exercise.controller;

import com.union.JPA.exercise.model.User;
import com.union.JPA.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/new")
    public String createUserForm() {
        return "users/createUserForm";
    }

    @PostMapping("/users/new")
    public String addUser(UserForm userForm) {
        User user = new User();

        user.setName(userForm.getName());
        user.setAddress(userForm.getAddress());

        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String userList(Model model) {
        List<User> user = userService.getAllUser();
        model.addAttribute("user", user);
        return "users/userList";
    }

//    @GetMapping("/getUser/{id}")
//    public Optional<User> getUser(@PathVariable("id") int id) {
//        return userService.getUser(id);
//    }
//
//    @DeleteMapping("/delUser/{id}")
//    public void delUser(@PathVariable("id") int id) {
//        userService.delUser(id);
//    }
}
