package com.example.ReservationSystem.controller;

import com.example.ReservationSystem.model.Reservation;
import com.example.ReservationSystem.service.ReservationService;
import com.example.ReservationSystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController //Definir la clase como controlador REST
@RequestMapping("/api/reservations") //Ruta para las solicitudes
public class ReservationController {
    @Autowired//Inyectar la instancia ReservationService
    private ReservationService reservationService;
    @GetMapping //Para manejar las solicitudes HTTP GET
    public ResponseEntity<List<Reservation>> getAllReservations() throws IOException {
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/{reservationId}") //Obtiene una reservacion por su Id especifico
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long reservationId) throws IOException { //Indica que el valor de la variable {reservationId} debe asignarse al parámetro roomId del método
        Reservation reservation = reservationService.getReservationById(reservationId);
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping //Maneja las solicitudes HTTP POST para agregar una nueva reservacion
    public ResponseEntity<Void> addReservation(@RequestBody Reservation reservation) throws IOException { //Indica que el cuerpo de la solicitud HTTP debe ser un objeto Reservation
        reservationService.addReservation(reservation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<Void> updateReservation(@PathVariable Long reservationId, @RequestBody Reservation updatedReservation) throws IOException {
        updatedReservation.setId(reservationId);
        reservationService.updateReservation(updatedReservation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long reservationId) throws IOException {
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
