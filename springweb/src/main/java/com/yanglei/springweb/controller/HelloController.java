package com.yanglei.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class HelloController {

    @GetMapping("/test")
    public String hello(Model model){
        model.addAttribute("message", "<h1>hello,yangLei!</h1>");
        model.addAttribute("users", Arrays.asList("yangLei", "happy"));
        return "test";
    }
}
