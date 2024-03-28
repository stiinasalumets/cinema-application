package com.ca.cinemapplication.CinemaUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/User")
public class CinemaUserController {

    private final CinemaUserService cinemaUserService;

    @Autowired
    public CinemaUserController(CinemaUserService cinemaUserService) {
        this.cinemaUserService = cinemaUserService;
    }

    @GetMapping("/getLoggedInUser")
    public ResponseEntity<CinemaUser> getLoggedInUser(){
        return cinemaUserService.getLoggedInUser();
    }
}
