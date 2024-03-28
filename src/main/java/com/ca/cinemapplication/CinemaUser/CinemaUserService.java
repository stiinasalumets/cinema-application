package com.ca.cinemapplication.CinemaUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CinemaUserService {
    private final CinemaUserRepository cinemaUserRepository;

    @Autowired
    public CinemaUserService(CinemaUserRepository cinemaUserRepository) {
        this.cinemaUserRepository = cinemaUserRepository;
    }


    public ResponseEntity<CinemaUser> getLoggedInUser() {
        try {
            CinemaUser cinemaUser = cinemaUserRepository.findTop1ByLoggedInIsTrue();
            return new ResponseEntity<>(cinemaUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
