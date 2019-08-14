package com.github.zmilad97.movielistfinal.controller;

import com.github.zmilad97.movielistfinal.module.User;
import com.github.zmilad97.movielistfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    @RequestMapping(value = "/username", method = RequestMethod.GET)
    //    @ResponseBody
    @RequestMapping(value = "/profile/index", method = RequestMethod.GET, produces = "application/json")
    public User currentUserName(Principal principal) {

        User finduser = this.userService.findByUsername(principal.getName());
        return finduser;
    }

    @PutMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public void delete(@PathVariable("id") int id) {
        userService.deleteById(id);
    }


}
