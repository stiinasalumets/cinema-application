package com.ca.cinemapplication.Seat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="Seat")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Seat {

    public Seat(Long sessionId, Integer seatWeight, Integer rowNumber, Integer columnNumber, Boolean isOccupied) {
        this.sessionId = sessionId;
        this.seatWeight = seatWeight;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.isOccupied = isOccupied;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long sessionId;
    private Integer seatWeight;
    private Integer rowNumber;
    private Integer columnNumber;
    private Boolean isOccupied;
}
