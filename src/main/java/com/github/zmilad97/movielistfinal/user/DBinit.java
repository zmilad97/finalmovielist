/*
package com.github.zmilad97.movielistfinal.user;

import com.github.zmilad97.movielistfinal.module.User;
import com.github.zmilad97.movielistfinal.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBinit implements CommandLineRunner {
    private UserService userRepository;
    private PasswordEncoder passwordEncoder;

    public DBinit(UserService userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();

        User milad =new User("milad",passwordEncoder.encode("1234"),"USER","");
        User dan = new User("dan",passwordEncoder.encode("1234"),"USER","");
        User admin=new User("admin",passwordEncoder.encode("1234"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager=new User("manager",passwordEncoder.encode("1234"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(milad,dan,admin,manager);

        this.userRepository.saveAll(users);
    }

}
*/
