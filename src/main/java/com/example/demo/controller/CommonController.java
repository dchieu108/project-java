package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    @GetMapping("/login")
    public String showLogin(){
        return "layout/login";
    }
    @GetMapping("/register")
    public String showRegister(){
        return "layout/register";
    }
    @GetMapping("/loginadmin")
    public String showLoginadmin(){
        return "layout/loginadmin";
    }
}
