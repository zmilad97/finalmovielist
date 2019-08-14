package com.github.zmilad97.movielistfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("user_addMovies")
    public String user_addMovies(){
        return "/profile/user_addMovies.html";
    }


}
