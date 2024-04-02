package com.ca.cinemapplication.Session;

import com.ca.cinemapplication.Movie.Movie;
import com.ca.cinemapplication.Seat.Seat;
import com.ca.cinemapplication.Seat.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SessionConfig implements ApplicationRunner {

    private final SessionRepository sessionRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public SessionConfig(SessionRepository sessionRepository, SeatRepository seatRepository) {
        this.sessionRepository = sessionRepository;
        this.seatRepository = seatRepository;
    }

    public void run(ApplicationArguments args) {

    }

}
