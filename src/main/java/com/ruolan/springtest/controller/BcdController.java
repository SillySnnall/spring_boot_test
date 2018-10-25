package com.ruolan.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BcdController {
    @GetMapping("/bcd")
    public String bcd(){
        return "bcd";
    }
}
