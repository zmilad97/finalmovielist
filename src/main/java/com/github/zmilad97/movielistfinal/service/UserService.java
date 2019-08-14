package com.github.zmilad97.movielistfinal.service;

import com.github.zmilad97.movielistfinal.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserService extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    List<User> findUserByActiveFalse();

    List<User> findUserByActiveTrue();
}
