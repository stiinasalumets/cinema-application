package com.ca.cinemapplication.Movie;

import com.ca.cinemapplication.Session.Session;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Entity
@Table(name="Movie")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "movie")
    @JsonIgnoreProperties("movie")
    private List<Session> sessions;

    public String formatMillisecondsToHHMM() {
        long hours = (this.durationMilliseconds / (1000 * 60 * 60)) % 24;
        long minutes = (this.durationMilliseconds / (1000 * 60)) % 60;
        return String.format("%02d:%02d", hours, minutes);
    }

}
