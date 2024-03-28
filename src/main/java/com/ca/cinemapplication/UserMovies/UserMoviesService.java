package com.ca.cinemapplication.UserMovies;

import com.ca.cinemapplication.Movie.Movie;
import com.ca.cinemapplication.Movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMoviesService {
    private final UserMoviesRepository userMoviesRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public UserMoviesService(UserMoviesRepository userMoviesRepository, MovieRepository movieRepository) {
        this.userMoviesRepository = userMoviesRepository;
        this.movieRepository = movieRepository;
    }


    public ResponseEntity<List<String>> getUsersGenres(@PathVariable Long userId) {
        try {
            List<String> genres = new ArrayList<>();
            List<UserMovies> userMovies = userMoviesRepository.findAllByUserIdEquals(userId);
            for (UserMovies userMovie: userMovies) {
                String genre = movieRepository.findMovieById(userMovie.getMovieId()).getGenre();
                genres.add(genre);
            }
            return new ResponseEntity<>(genres, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
