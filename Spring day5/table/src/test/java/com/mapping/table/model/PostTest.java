package com.mapping.table.model;

import com.mapping.table.post.model.User;
import org.junit.jupiter.api.Test;

public class PostTest {

    @Test
    void modelTest() {
        User user = new User();
        user.setUserName("Jobs");
        System.out.println("user = " + user);
    }
}
