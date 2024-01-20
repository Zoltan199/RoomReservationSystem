package com.example.ReservationSystem.repository;

import com.example.ReservationSystem.model.Client;
import com.example.ReservationSystem.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.io.File;

@Repository
public class ReservationRepository {
    public List<Reservation> getReservations() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();

        Resource resource = new ClassPathResource("/data/reservation.json");
        File file = resource.getFile();

        JavaTimeModule module = new JavaTimeModule();
        objectMapper.registerModule(module);

        List<Reservation> ReservationList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Reservation.class));

        return ReservationList;
    }

    public Reservation getReservationById(Long reservationId) throws IOException{
        return getReservations().stream().filter(client -> client.getId().equals(reservationId)).findFirst().orElse(null);
    }

    public void  addReservation(Reservation reservation)throws IOException{
        List<Reservation> reservations=getReservations();
        reservation.setId(Reservation.generateId(reservations));
        reservations.add(reservation);
        saveReservations(reservations);
    }

    private void saveReservations(List<Reservation> reservations) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule(); // Este módulo proporciona soporte para los tipos de fecha y hora definidos en el paquete java.time.
        objectMapper.registerModule(module);
        Resource resource = new ClassPathResource("/data/reservation.json");
        objectMapper.writeValue(resource.getFile(), reservations);
    }

    public void updateReservation(Reservation updateReservation)throws IOException{
        List<Reservation> reservations = getReservations();
        reservations.replaceAll(reservation -> reservation.getId().equals(updateReservation.getId()) ? updateReservation : reservation);
        saveReservations(reservations);
    }

    public void deleteReservation(Long reservationId) throws IOException { //Elimina una reservacion por su id
        List<Reservation> reservations = getReservations();
        reservations.removeIf(reservation -> reservation.getId().equals(reservationId));
        saveReservations(reservations);
    }



}
