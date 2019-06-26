package com.example.demo.controller;

import com.example.demo.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class loginCotroller {
    @Autowired
    private Test test;
    public void login(){

    }



}
