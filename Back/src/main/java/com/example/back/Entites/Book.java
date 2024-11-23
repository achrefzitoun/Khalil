package com.example.back.Entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idBook;

    Long isbn;

    String title;

    String image;

    Integer year;

    String language;

    String author;

    String localisation;

    String description;

    Integer numberOfPages;

    Integer nbCopies;

    String demension;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private Set<Reservation> reservations;

    @ManyToMany
    private Set<TypeBook> typeBook;
}
