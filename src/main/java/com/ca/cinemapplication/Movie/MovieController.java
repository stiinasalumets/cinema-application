package com.ca.cinemapplication.Movie;

import com.ca.cinemapplication.Seat.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Set;

@Controller
@EnableAutoConfiguration
public class MovieController implements WebMvcConfigurer {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/myMovies")
    public String myMovies(Model model){
        List<Movie> movies = movieService.getMovieByUser(1L);
        model.addAttribute("myMovies", movies);
        return "myMovies";
    }

    @GetMapping("/currentMovies")
    public String currentMovies(Model model) {
        Set<Movie> currentMovies = movieService.getCurrentMovies();
        model.addAttribute("currentMovies", currentMovies);
        return "currentMovies";
    }

    @GetMapping("/logo")
    public String logo(Model model) {
        model.addAttribute("logo", "static/logo.png");
        return "logo";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("index");
        return "index";
    }

    @GetMapping("/suggestions")
    public String suggestions(Model model) {
        List<Movie> result = movieService.suggestions();
        model.addAttribute("suggestions", result);
        return "suggestions";
    }

    @GetMapping("/howManySeats/{sessionId}")
    public String howManySeats(Model model, @PathVariable Long sessionId) {
        model.addAttribute("howManySeats");
        return "howManySeats";
    }


    @GetMapping("/chooseSeat")
    public String chooseSeat(Model model, @RequestParam Long sessionId, @RequestParam Integer numberOfSeats) {
        List<Seat> seats = movieService.chooseSeat(sessionId);
        model.addAttribute("chooseSeat", seats);
        model.addAttribute("numberOfSeats", numberOfSeats);
        return "chooseSeat";
    }
}
