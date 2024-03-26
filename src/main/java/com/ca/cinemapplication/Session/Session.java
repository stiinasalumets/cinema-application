package com.ca.cinemapplication.Session;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Movie")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Session {

    public Session(String occupiedSeats, Date startTime, String language, Long movieId) {
        this.occupiedSeats = occupiedSeats;
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
    private String occupiedSeats;
}
