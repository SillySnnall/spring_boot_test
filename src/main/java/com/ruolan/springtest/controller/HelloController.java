package com.ruolan.springtest.controller;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ruolan.springtest.bean.User;
import com.ruolan.springtest.property.NeoProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

    @Value("${com}")
    private String title;
    @Value("${neo}")
    private String description;

    @RequestMapping("/hello")
    private String index() {
        return "Hello World多萨达撒啊!";
    }

    @RequestMapping("/helloJson")
    private User indexJson() {
        User user = new User();
        user.setName("杀菌达");
        return user;
    }

    @RequestMapping("/hello1")
    private String indexxxx() {
        return "Hello World多萨达撒啊!";
    }

    @RequestMapping("/hello3")
    private String indexxxx2() {
        return title;
    }
}
