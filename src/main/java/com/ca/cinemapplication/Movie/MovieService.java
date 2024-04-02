package com.ca.cinemapplication.Movie;

import com.ca.cinemapplication.Seat.Seat;
import com.ca.cinemapplication.Seat.SeatRepository;
import com.ca.cinemapplication.Session.Session;
import com.ca.cinemapplication.Session.SessionRepository;
import com.ca.cinemapplication.UserMovies.UserMovies;
import com.ca.cinemapplication.UserMovies.UserMoviesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;
    private final UserMoviesRepository userMoviesRepository;
    private final SessionRepository sessionRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, UserMoviesRepository userMoviesRepository, SessionRepository sessionRepository, SeatRepository seatRepository) {
        this.movieRepository = movieRepository;
        this.userMoviesRepository = userMoviesRepository;
        this.sessionRepository = sessionRepository;
        this.seatRepository = seatRepository;
    }

    public ResponseEntity<List<Movie>> getAllMovies() {
        try {
            List<Movie> movies = movieRepository.findAll();
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Movie> getMovieByUser(Long id) {

        List<UserMovies> userMovies = userMoviesRepository.findAllByUserIdEquals(id);
        List<Movie> result = new ArrayList<>();
        for (UserMovies userMovie : userMovies) {
            result.add(movieRepository.findMovieById(userMovie.getMovieId()));
        }
        return result;

    }

    public Set<Movie> getCurrentMovies() {
        List<Session> sessions = sessionRepository.findByStartTimeAfter(new Date());
        Set<Movie> result = new HashSet<>();
        for (Session session : sessions) {
            result.add(session.getMovie());
        }
        return result;
    }

    public List<Movie> suggestions() {
        List<Movie> movies = getMovieByUser(1L);
        Map<String, Integer> genrePopularity = new HashMap<>();
        for (Movie movie : movies) {
            String genre = movie.getGenre();
            if (genrePopularity.containsKey(genre)) {
                genrePopularity.put(genre, genrePopularity.get(genre) + 1);
            } else {
                genrePopularity.put(genre, 1);
            }
        }
        return movieRepository.findAll().stream()
                .sorted((movie1, movie2) -> {
                    int popularity1 = genrePopularity.getOrDefault(movie1.getGenre(), 0);
                    int popularity2 = genrePopularity.getOrDefault(movie2.getGenre(), 0);
                    return Integer.compare(popularity2, popularity1);
                })
                .collect(Collectors.toList());
    }

    public List<Seat> chooseSeat(Long sessionId) {
        return seatRepository.findAllByIdEquals(sessionId);
    }
}
