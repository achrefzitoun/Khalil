package com.example.back.Services;

import com.example.back.Entites.Book;
import com.example.back.Entites.Reservation;
import com.example.back.Entites.User;

import java.time.LocalDate;
import java.util.List;

public interface IReservationServices {

    public boolean isBookAvailable(Book book, LocalDate startDate, LocalDate endDate);
    public void cancelReservation(Reservation reservation);
    public Reservation saveReservation(Reservation reservation) throws Exception;
    public List<Reservation> getAllReservationsByUser(User user);

    public Reservation remisReservation(Reservation reservation);
}
