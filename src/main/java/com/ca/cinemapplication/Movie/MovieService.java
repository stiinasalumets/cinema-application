package com.ca.cinemapplication.Movie;

import com.ca.cinemapplication.UserMovies.UserMovies;
import com.ca.cinemapplication.UserMovies.UserMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final UserMoviesRepository userMoviesRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, UserMoviesRepository userMoviesRepository) {
        this.movieRepository = movieRepository;
        this.userMoviesRepository = userMoviesRepository;
    }

    public ResponseEntity<List<Movie>> getAllMovies() {
        try {
            List<Movie> movies = movieRepository.findAll();
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Movie>> getMovieByUser(Long id){
        try {
            List<UserMovies> userMovies = userMoviesRepository.findAllByUserIdEquals(id);
            List<Movie> result = new ArrayList<>();
            for (UserMovies userMovie:userMovies) {
                result.add(movieRepository.findMovieById(userMovie.getMovieId()));
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
