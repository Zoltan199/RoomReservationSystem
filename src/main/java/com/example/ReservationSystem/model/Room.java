package com.example.ReservationSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) //Para la serializacion de los datos JSON
public class Room {
    private Long id;
    private String roomNumber;
    private int capacity;
    private boolean available;

    //Constructor para JSON
    public Room(){

    }

    //Constructor y sus parametros
    public void Room(Long id, String roomNumber, int capacity, boolean available) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.available = available;
    }

    //Getters
    public Long getId(){
        return id;
    }

    public String getRoomNumber(){
        return roomNumber;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean isAvailable(){
        return available;
    }


    //Setters
    public void setId(Long id){
        this.id = id;
    }

    public void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void  setAvailable(boolean available){
        this.available = available;
    }

    //Otros metodos
    public static Long generateId(List<Room> rooms) {
        return rooms.stream().mapToLong(Room::getId).max().orElse(0) + 1;
    }


}
