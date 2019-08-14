package com.github.zmilad97.movielistfinal.module;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    private String direcor;
    private String genre;
    private int status;
    private String releaseDate;
    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private User user;

    public Movie(String name, String direcor, String genre, String releaseDate, User user) {
        this.name = name;
        this.direcor = direcor;
        this.genre = genre;
        this.user = user;
        this.status = 0;
        this.releaseDate = releaseDate;
    }

    public Movie(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirecor() {
        return direcor;
    }

    public void setDirecor(String direcor) {
        this.direcor = direcor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
