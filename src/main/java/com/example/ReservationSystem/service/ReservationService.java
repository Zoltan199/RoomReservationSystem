package com.example.ReservationSystem.service;

import com.example.ReservationSystem.model.Reservation;
import com.example.ReservationSystem.repository.ReservationRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    //private final String filePath = "/resources/data/data.json"; //Ruta a la capa de datos
    //private final ObjectMapper objectMapper = new ObjectMapper(); //Objeto de Jackson para convertir Java-JSON

    public List<Reservation> getAllReservations() throws IOException { //Lee las reservaciones en el archivo data.json y las devuelve en una lista de objetos Reservation
        return reservationRepository.getReservations();
    }

    public Reservation getReservationById(Long reservationId) throws IOException {
        return reservationRepository.getReservationById(reservationId);
    }

    public void addReservation(Reservation reservation) throws IOException {
        reservationRepository.addReservation(reservation);
    }

    public void updateReservation(Reservation updatedReservation) throws IOException {
        reservationRepository.updateReservation(updatedReservation);
    }

    public void deleteReservation(Long reservationId) throws IOException {
        reservationRepository.deleteReservation(reservationId);
    }

//    private void saveReservations(List<Reservation> reservations) throws IOException {
//        objectMapper.writeValue(new File(filePath), reservations);
//    }
//
//    private Long generateId(List<Reservation> reservations) {
//        return reservations.stream().mapToLong(Reservation::getId).max().orElse(0) + 1;
//    }


    }
