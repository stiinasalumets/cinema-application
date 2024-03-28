package com.ca.cinemapplication.UserMovies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="UserMovies")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserMovies {

    public UserMovies(Long movieId, Long userId) {
        this.movieId = movieId;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long movieId;
    private Long userId;

}
