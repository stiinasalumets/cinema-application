package com.ca.cinemapplication.UserMovies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/UserMovies")
public class UserMoviesController {

    private final UserMoviesService userMoviesService;

    @Autowired
    public UserMoviesController(UserMoviesService userMoviesService) {
        this.userMoviesService = userMoviesService;
    }

    @GetMapping("/getUsersGenres/{id}")
    public ResponseEntity<List<String>> getUsersGenres(@PathVariable Long id){
        return userMoviesService.getUsersGenres(id);
    }
}
