package com.example.back.Services.impl;

import com.example.back.Entites.Book;
import com.example.back.Entites.Reservation;
import com.example.back.Entites.User;
import com.example.back.Repositories.IReservationsRepository;
import com.example.back.Services.IReservationServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service

@RequiredArgsConstructor
public class reservationServices implements IReservationServices {

    @Autowired
    private IReservationsRepository reservationRepository;

    @Override
    public boolean isBookAvailable(Book book, LocalDate startDate, LocalDate endDate) {
        List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(book.getIdBook(), startDate, endDate);
        int totalCopies = book.getNbCopies();
        int reservedCopies = overlappingReservations.size();
        return reservedCopies < totalCopies;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) throws Exception {
        Book book = reservation.getBook();
        if (!isBookAvailable(book, reservation.getStartDate(), reservation.getEndDate())) {
            throw new Exception("No books for this dates");
        }
        reservation.setBook(book);
        return reservationRepository.save(reservation);
    }

    @Override
    public void cancelReservation(Reservation reservation){
        reservationRepository.delete(reservation);
    }

    @Override
    public List<Reservation> getAllReservationsByUser(User user){
        return reservationRepository.findAllByUser(user);
    }

    @Override
    public Reservation remisReservation(Reservation reservation) {
        reservation.setRemis(true);
        return reservationRepository.save(reservation);
    }


}
