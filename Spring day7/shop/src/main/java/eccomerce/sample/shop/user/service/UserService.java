package eccomerce.sample.shop.user.service;

import eccomerce.sample.shop.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    List<User> getAllUser();
    Optional<User> getUser(Long id);
    void delUser(Long id);
}
