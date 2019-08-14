package com.github.zmilad97.movielistfinal.service;

import com.github.zmilad97.movielistfinal.module.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MovieService extends JpaRepository<Movie, Integer> {

    //List<Movie> findMovieById();

    List<Movie> findMovieByStatusTrue();

    List<Movie> findMovieByStatusFalse();

    List<Movie> findMovieByUser_Id(int id);

}
