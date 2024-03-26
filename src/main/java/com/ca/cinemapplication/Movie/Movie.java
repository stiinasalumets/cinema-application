package com.ca.cinemapplication.Movie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="Movie")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Movie {

    public Movie(Integer durationMilliseconds, String title, String genre, Integer minimumAge) {
        this.durationMilliseconds = durationMilliseconds;
        this.title = title;
        this.genre = genre;
        this.minimumAge = minimumAge;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer durationMilliseconds;
    private String title;
    private String genre;
    private Integer minimumAge;

}
