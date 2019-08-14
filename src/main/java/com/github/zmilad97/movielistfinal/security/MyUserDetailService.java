package com.github.zmilad97.movielistfinal.security;

import com.github.zmilad97.movielistfinal.module.User;
import com.github.zmilad97.movielistfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public MyUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user= userService.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Error 404");
        UserPrincipal userPrincipal =new UserPrincipal(user);
        return userPrincipal ;
    }


}
