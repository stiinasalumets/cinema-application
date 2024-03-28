package com.ca.cinemapplication.UserMovies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UserMoviesConfig implements ApplicationRunner {

    private final UserMoviesRepository userMoviesRepository;

    @Autowired
    public UserMoviesConfig(UserMoviesRepository userMoviesRepository) {
        this.userMoviesRepository = userMoviesRepository;
    }

    public void run(ApplicationArguments args) {
        userMoviesRepository.save(new UserMovies(1L, 1L));
        userMoviesRepository.save(new UserMovies(2L, 1L));
        userMoviesRepository.save(new UserMovies(3L, 1L));
        userMoviesRepository.save(new UserMovies(4L, 1L));
    }
}
