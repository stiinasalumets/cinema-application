package com.ca.cinemapplication.Seat;

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
public class SeatConfig implements ApplicationRunner {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatConfig(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }


    public void run(ApplicationArguments args) {

    }
}
