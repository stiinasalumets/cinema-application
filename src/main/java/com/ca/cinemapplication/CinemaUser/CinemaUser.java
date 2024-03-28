package com.ca.cinemapplication.CinemaUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="CinemaUser")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CinemaUser {

    public CinemaUser(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean loggedIn;

}
