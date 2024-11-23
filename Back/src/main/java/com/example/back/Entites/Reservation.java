package com.example.back.Entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idReservation;

    LocalDate startDate;

    LocalDate endDate;

    Boolean remis = false;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
}
