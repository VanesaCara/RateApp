package com.example.RestAPI.controller;

import com.example.RestAPI.entity.User;
import com.example.RestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {
    @Autowired
    private UserService service ;

    @GetMapping("/w")
    public String welcome(){
        return "Mirseerdhet";
    }



}
