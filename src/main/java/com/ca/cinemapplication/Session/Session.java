package com.ca.cinemapplication.Session;

import com.ca.cinemapplication.Seat.Seat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@ToString
public class Session {

    public Session(Date startTime, String language, Long movieId) {
        this.startTime = startTime;
        this.language = language;
        this.movieId = movieId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date startTime;
    private String language;
    private Long movieId;
}
