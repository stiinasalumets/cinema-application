package com.ca.cinemapplication.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieConfig implements ApplicationRunner {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieConfig(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void run(ApplicationArguments args) {
        movieRepository.save(new Movie(9300000, "Düün: teine osa", "science fiction", 12));
    }
}
