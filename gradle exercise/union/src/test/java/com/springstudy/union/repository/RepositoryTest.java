package com.springstudy.union.repository;

import com.springstudy.union.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class RepositoryTest {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Test
    void saveTest() throws SQLException {

        User user1 = new User();
        user1.setName("Union");
        user1.setUserId("beat1103");
        user1.setEmail("beat1103@gmail.com");
        userRepository.save(user1);

        User result = userRepository.findById(user1.getId()).get();
        Assertions.assertThat(result).isEqualTo(user1);
    }
}
