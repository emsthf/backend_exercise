package com.gradleSample.springday3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoroller {

    @GetMapping("/")
    public String home() {
        return "home";  // html의 이름이 된다(static 폴더의 home.html로 연결시킴)
    }
}
