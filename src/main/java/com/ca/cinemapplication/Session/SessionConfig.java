package com.ca.cinemapplication.Session;

import com.ca.cinemapplication.Seat.Seat;
import com.ca.cinemapplication.Seat.SeatRepository;
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
public class SessionConfig implements ApplicationRunner {

    private final SessionRepository sessionRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public SessionConfig(SessionRepository sessionRepository, SeatRepository seatRepository) {
        this.sessionRepository = sessionRepository;
        this.seatRepository = seatRepository;
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
        for (int column = 1; column <= columnLength; column++) {
            for (int row = 1; row <= rowLength; row++) {
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
        Session session = new Session(Timestamp.valueOf(LocalDateTime.of(2024, 4, 4, 20, 30)), "estonian", 1L);
        sessionRepository.save(session);
        generateSeats(session.getId());
    }
}
