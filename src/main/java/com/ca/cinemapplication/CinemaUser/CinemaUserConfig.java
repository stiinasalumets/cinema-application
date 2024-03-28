package com.ca.cinemapplication.CinemaUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CinemaUserConfig implements ApplicationRunner {

    private final CinemaUserRepository cinemaUserRepository;

    @Autowired
    public CinemaUserConfig(CinemaUserRepository cinemaUserRepository) {
        this.cinemaUserRepository = cinemaUserRepository;
    }

    public void run(ApplicationArguments args) {
        cinemaUserRepository.save(new CinemaUser(true));
    }
}
