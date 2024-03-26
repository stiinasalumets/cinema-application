package com.ca.cinemapplication.Seat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Entity
@Table(name="Seat")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Integer seatNumber;
    private Integer rowNumber;
    private Integer columnNumber;
    private Boolean isOccupied;
}
