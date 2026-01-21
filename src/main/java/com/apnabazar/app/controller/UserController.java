package com.apnabazar.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apnabazar.app.request.UserRequest;
import com.apnabazar.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public String create(@RequestBody UserRequest r) {
        return "Generated Password: " + service.createUser(r);
    }

    
    @GetMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        return service.login(username, password)
                ? "Login Successful"
                : "Login Failed";
    }

}
