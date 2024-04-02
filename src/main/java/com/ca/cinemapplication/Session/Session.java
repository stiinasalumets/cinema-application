package com.ca.cinemapplication.Session;

import com.ca.cinemapplication.Movie.Movie;
import com.ca.cinemapplication.Seat.Seat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.sql.In;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Entity
@Table(name = "Session")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Session {

    public Session(Date startTime, String language, Movie movie) {
        this.startTime = startTime;
        this.language = language;
        this.movie = movie;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date startTime;
    private String language;
   @ManyToOne
   @JoinColumn(name="movie_id", nullable = false)
    private Movie movie;
}
