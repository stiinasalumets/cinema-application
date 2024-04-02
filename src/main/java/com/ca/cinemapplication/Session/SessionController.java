package com.ca.cinemapplication.Session;

import com.ca.cinemapplication.Movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Set;

@Controller
@EnableAutoConfiguration
public class SessionController implements WebMvcConfigurer {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/getAllSessions")
    public ResponseEntity<List<Session>> getAllSessions(){
        return sessionService.getAllSessions();
    }


}
