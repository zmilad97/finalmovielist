package com.github.zmilad97.movielistfinal.module;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    private String roles;
    private String premissions;

    private int active;

    public User(String username, String password, String roles, String premissions) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.premissions = premissions;
        this.active = 1;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPremissionList(){
        if(this.premissions.length() > 0){
            return Arrays.asList(this.premissions.split(","));
        }
        return new ArrayList<>();
    }

}
