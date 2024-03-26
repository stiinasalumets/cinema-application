package com.ca.cinemapplication.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SessionConfig implements ApplicationRunner {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionConfig(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    private static String generateAvailableSeats(int numberOfSeats) {
        List<Integer> occupiedSeats = IntStream.rangeClosed(1, 231).boxed().collect(Collectors.toList());
        Random random = new Random();

        while ((occupiedSeats.size() + numberOfSeats) > 231) {
            int seat = random.nextInt(occupiedSeats.size()) + 1;
            occupiedSeats.remove(seat);
        }

        StringBuilder result = new StringBuilder();
        for (Integer seat : occupiedSeats) {
            result.append(seat).append(",");
        }

        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    public void run(ApplicationArguments args) {
        Random random = new Random();
        sessionRepository.save(new Session(generateAvailableSeats(random.nextInt(11, 100)), Timestamp.valueOf(LocalDateTime.of(2024, 4, 4, 20, 30)), "estonian", 1L));
    }
}
