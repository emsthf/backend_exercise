package eccomerce.sample.shop.user.controller;

import eccomerce.sample.shop.user.model.User;
import eccomerce.sample.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAllUser();
    }

    @GetMapping("/get/{id}")
    public Optional<User> get(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        userService.delUser(id);
    }
}
