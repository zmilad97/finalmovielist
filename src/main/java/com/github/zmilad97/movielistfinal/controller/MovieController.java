package com.github.zmilad97.movielistfinal.controller;

import com.github.zmilad97.movielistfinal.module.Movie;
import com.github.zmilad97.movielistfinal.module.User;
import com.github.zmilad97.movielistfinal.security.SecurityUtil;
import com.github.zmilad97.movielistfinal.security.UserPrincipal;
import com.github.zmilad97.movielistfinal.service.MovieService;
import com.github.zmilad97.movielistfinal.service.UserService;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class MovieController {

    private UserService userService;
    private UserPrincipal userPrincipal;
    private UserDetails userDetails;
    private MovieService movieService;

    @Autowired
    public MovieController(UserService userService, MovieService movieService) {
        this.userService = userService;
        this.movieService = movieService;
    }

    @GetMapping("/movies/seenlist")
    public List<Movie> seenlist() {
        List<Movie> findMovieByStatusTrue = movieService.findMovieByStatusTrue();
        return findMovieByStatusTrue;
    }

    @GetMapping("/movies/watchlist")
    public List<Movie> watchlist() {
        List<Movie> findMovieByStatusFalse = movieService.findMovieByStatusFalse();
        return findMovieByStatusFalse;
    }

    @RequestMapping("/movies/{id}")
    public Movie getmovie(@PathVariable("id") int id) {

        return movieService.findById(id).orElse(null);
    }

    @RequestMapping(value = "/user_showMovies" , method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> userShowAll(Principal principal){
        User findUser = this.userService.findByUsername(principal.getName());
        return movieService.findMovieByUser_Id(findUser.getId());
    }



    @PutMapping("/movies")
    public void addMovie(@RequestBody Movie movie) {
        movie.setUser(SecurityUtil.getCurrentUser());
        movieService.save(movie);
    }

    @GetMapping("/movies")
    public List<Movie> showAll() {
        return movieService.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/movies/{id}")
    public void delete(@PathVariable("id") int id) {
        movieService.deleteById(id);
    }


}
