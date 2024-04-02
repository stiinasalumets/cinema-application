package com.ca.cinemapplication.Movie;

import com.ca.cinemapplication.Seat.Seat;
import com.ca.cinemapplication.Seat.SeatRepository;
import com.ca.cinemapplication.Session.Session;
import com.ca.cinemapplication.Session.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class MovieConfig implements ApplicationRunner {

    private final MovieRepository movieRepository;
    private final SeatRepository seatRepository;
    private final SessionRepository sessionRepository;

    @Autowired
    public MovieConfig(MovieRepository movieRepository, SeatRepository seatRepository, SessionRepository sessionRepository) {
        this.movieRepository = movieRepository;
        this.seatRepository = seatRepository;
        this.sessionRepository = sessionRepository;
    }


    private static List<Integer> returnUnoccupiedSeats(int numberOfOccupiedSeats) {
        List<Integer> unoccupiedSeats = IntStream.rangeClosed(1, 77).boxed().collect(Collectors.toList());
        Random random = new Random();

        while ((unoccupiedSeats.size() + numberOfOccupiedSeats) > 77) {
            int seat = random.nextInt(0, unoccupiedSeats.size() - 1);
            unoccupiedSeats.remove(seat);
        }

        return unoccupiedSeats;
    }

    private void generateSeats(Long sessionId) {
        Random random = new Random();
        int numberOfOccupiedSeats = random.nextInt(77);
        int rowLength = 7;
        int columnLength = 11;
        int seatNumber = 1;
        List<Integer> unoccupiedSeats = returnUnoccupiedSeats(numberOfOccupiedSeats);
        for (int row = 1; row <= rowLength; row++) {
            for (int column = 1; column <= columnLength; column++) {
                int distanceRow = row - (int) Math.ceil((double) rowLength / 2);
                int distanceColumn = columnLength - (int) Math.ceil((double) columnLength / 2);
                int seatWeight = Math.abs(distanceRow) + Math.abs(distanceColumn);
                Boolean isOccupied = !unoccupiedSeats.contains(seatNumber);
                seatRepository.save(new Seat(sessionId, seatWeight, row, column, isOccupied));
                seatNumber++;
            }
        }
    }


    public void run(ApplicationArguments args) {
        Random random = new Random();
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie(9300000, "Dune", "science fiction", 12));
        movieList.add(new Movie(12000000, "Inception", "science fiction", 14));
        movieList.add(new Movie(7200000, "The Shawshank Redemption", "drama", 16));
        movieList.add(new Movie(8400000, "Forrest Gump", "drama", 12));
        movieList.add(new Movie(9000000, "The Dark Knight", "action", 14));
        movieList.add(new Movie(7800000, "The Matrix", "action", 16));
        movieList.add(new Movie(6600000, "Pulp Fiction", "crime", 18));
        movieList.add(new Movie(9600000, "The Lord of the Rings: The Fellowship of the Ring", "fantasy", 12));
        movieList.add(new Movie(11340000, "The Godfather", "crime", 18));
        movieList.add(new Movie(12600000, "Interstellar", "science fiction", 14));

        Long id = 0L;
        for (Movie movie : movieList) {
            List<Session> sessionList = new ArrayList<>();

            for (int i = 0; i < 2; i++) {
                id++;
                // Generate random language
                String language = random.nextBoolean() ? "estonian" : "russian";

                // Generate random timestamp in the future or past
                long secondsToAdd = random.nextInt(7 * 24 * 3600) - 1;
                LocalDateTime startTime = LocalDateTime.now().plusSeconds(secondsToAdd);

                Session session = new Session(Timestamp.valueOf(startTime), language, movie);
                sessionList.add(session);
                generateSeats(id);
            }
            movie.setSessions(sessionList);
            movieRepository.save(movie);
            sessionRepository.saveAll(sessionList);
        }


    }
}
