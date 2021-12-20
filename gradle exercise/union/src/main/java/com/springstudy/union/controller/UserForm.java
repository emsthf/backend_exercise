package com.springstudy.union.controller;

import com.springstudy.union.model.User;
import org.springframework.web.bind.annotation.PostMapping;

public class UserForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

