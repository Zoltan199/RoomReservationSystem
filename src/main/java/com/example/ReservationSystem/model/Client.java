package com.example.ReservationSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) //Para la serializacion de los datos JSON
public class Client {
    private Long id;
    private String name;
    private String lastName;
    private String email;

    //Constructor para JSON
    public Client(){

    }


    //Constructor y sus atributos
    public Client(Long id, String name, String lastName, String email){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }


    //Getters
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    //Setters
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name =name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    //Otros metodos
    public static Long generateId(List<Client> clients) {
        return clients.stream().mapToLong(Client::getId).max().orElse(0) + 1;
    }

}
