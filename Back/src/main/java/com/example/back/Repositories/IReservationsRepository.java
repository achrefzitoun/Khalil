package com.example.back.Repositories;

import com.example.back.Entites.Book;
import com.example.back.Entites.Reservation;
import com.example.back.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.net.UnknownServiceException;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReservationsRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT r FROM Reservation r WHERE r.book.idBook = :bookId AND "
            + "((:startDate BETWEEN r.startDate AND r.endDate) "
            + "OR (:endDate BETWEEN r.startDate AND r.endDate) "
            + "OR (r.startDate BETWEEN :startDate AND :endDate) "
            + "OR (r.endDate BETWEEN :startDate AND :endDate))")
    List<Reservation> findOverlappingReservations(@Param("bookId") Integer bookId,
                                                  @Param("startDate") LocalDate startDate,
                                                  @Param("endDate") LocalDate endDate);

    List<Reservation> findAllByBook(Book book);

    List<Reservation> findAllByUser(User user);
}