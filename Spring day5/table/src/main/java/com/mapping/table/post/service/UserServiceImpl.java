package com.mapping.table.post.service;

import com.mapping.table.post.model.User;
import com.mapping.table.post.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;   // 레포지토리를 final로 선언하고 생성자로 접근하게 한다

    // 'alt + insert'로 자동 생성된 생성자
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {   // 서비스임플리 클래스에 레포지토리를 담는다
        this.userRepository = userRepository;                 // 위에 선언한 레포지토리가 final이므로 생성자로 접근
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return Optional.ofNullable(userRepository.findById(id).get());
    }
}
