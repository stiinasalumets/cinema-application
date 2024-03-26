package com.ca.cinemapplication.Session;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Entity
@Table(name="Session")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Session {

    public Session(String availableSeats, Date startTime, String language, Long movieId) {
        this.availableSeats = availableSeats;
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
    private String availableSeats;
}
