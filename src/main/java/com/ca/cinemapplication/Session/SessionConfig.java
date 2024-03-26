package com.ca.cinemapplication.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class SessionConfig implements ApplicationRunner {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionConfig(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void run(ApplicationArguments args) {
        sessionRepository.save(new Session("12,11,1,2", Timestamp.valueOf(LocalDateTime.of(2024, 4, 4, 20, 30)), "estonian", 1L));
    }
}
