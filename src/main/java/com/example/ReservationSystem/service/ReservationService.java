package com.example.ReservationSystem.service;

import com.example.ReservationSystem.model.Reservation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ReservationService {
    private final String filePath = "data/data.json"; //Ruta a la capa de datos
    private final ObjectMapper objectMapper = new ObjectMapper(); //Objeto de Jackson para convertir Java-JSON

    public List<Reservation> getAllReservations() throws IOException { //Lee las reservaciones en el archivo data.json y las devuelve en una lista de objetos Reservation
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Reservation>>() {});
    }

    public Reservation getReservationById(Long reservationId) throws IOException {
        return getAllReservations().stream()
                .filter(reservation -> reservation.getId().equals(reservationId))
                .findFirst()
                .orElse(null);
    }

    public void addReservation(Reservation reservation) throws IOException {
        List<Reservation> reservations = getAllReservations();
        reservation.setId(generateId(reservations));
        reservations.add(reservation);
        saveReservations(reservations);
    }

    public void updateReservation(Reservation updatedReservation) throws IOException {
        List<Reservation> reservations = getAllReservations();
        reservations.replaceAll(reservation ->
                reservation.getId().equals(updatedReservation.getId()) ? updatedReservation : reservation);
        saveReservations(reservations);
    }

    public void deleteReservation(Long reservationId) throws IOException {
        List<Reservation> reservations = getAllReservations();
        reservations.removeIf(reservation -> reservation.getId().equals(reservationId));
        saveReservations(reservations);
    }

    private void saveReservations(List<Reservation> reservations) throws IOException {
        objectMapper.writeValue(new File(filePath), reservations);
    }

    private Long generateId(List<Reservation> reservations) {
        return reservations.stream().mapToLong(Reservation::getId).max().orElse(0) + 1;
    }


    }
