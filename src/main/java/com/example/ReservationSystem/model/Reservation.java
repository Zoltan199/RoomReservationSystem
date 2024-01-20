package com.example.ReservationSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) //Para la serializacion de los datos JSON
public class Reservation {
    private Long id;
    private Room room;
    private Client client;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkInDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOutDate;
    private double cost;

    //Constructor para JSON
    public Reservation(){

    }

    //Constructor con atributos
    public Reservation(Long id, Room room, Client client, LocalDate checkInDate, LocalDate checkOutDate, double cost){
        this.id =id;
        this.room =room;
        this.client =client;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.cost = cost;
    }

    //Getters
    public Long getId(){
        return id;
    }

    public Room getRoom(){
        return room;
    }

    public Client getClient(){
        return client;
    }

    public LocalDate getCheckInDate(){
        return checkInDate;
    }

    public LocalDate getCheckOutDate(){
        return checkOutDate;
    }

    public double getCost(){
        return cost;
    }


    //Setters
    public void setId(Long id){
        this.id =id;
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public void setClient(Client client){
        this.client =client;
    }

    public void setCheckInDate(LocalDate checkInDate){
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate){
        this.checkOutDate = checkOutDate;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    //Otros metodos
    public static Long generateId(List<Reservation> reservations) {
        return reservations.stream().mapToLong(Reservation::getId).max().orElse(0) + 1;
    }






}
