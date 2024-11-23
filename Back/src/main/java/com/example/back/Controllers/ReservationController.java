package com.example.back.Controllers;

import com.example.back.Entites.Reservation;
import com.example.back.Services.IReservationServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    IReservationServices reservationServices;

    @PostMapping("/addReservation")
    Reservation addReservation(@RequestBody Reservation reservation) throws Exception {
        return reservationServices.saveReservation(reservation);
    }
}
