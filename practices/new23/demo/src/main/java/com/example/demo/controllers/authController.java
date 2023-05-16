package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserAppService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class authController {

    @Autowired
    private final UserAppService userAppService;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/reg")
    public String getRegistrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/reg")
    public void signUpUser(@ModelAttribute("user") User user) {
        userAppService.signUpUser(user);
        // return "login";
    }
}

