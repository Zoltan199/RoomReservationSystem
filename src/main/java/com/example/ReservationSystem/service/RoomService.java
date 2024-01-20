package com.example.ReservationSystem.service;

import com.example.ReservationSystem.model.Room;
import com.example.ReservationSystem.repository.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private  RoomRepository roomRepository;
    private final String filePath = "/resources/data/data.json"; //Ruta a la capa de datos
    //private final ObjectMapper objectMapper = new ObjectMapper(); //Objeto de Jackson para convertir Java-JSON


    public List<Room> getAllRooms() throws IOException{ //Lee las habitaciones en el archivo data.json y las devuelve en una lista de objeros Room
        return roomRepository.getRooms();
    }

    public Room getRoomById(Long roomId) throws IOException{
        return roomRepository.getRoomById(roomId);
        //Busca las habitaciones con el metodo anterior, y filtra solo aquellas que tengan el roomId que se pasa como parametro a la funcion
    }

    public void addRoom(Room room)throws IOException{ //Agrega una nueva habitacion, usa la funcion generateId para que no se repita y el id sea unico
        roomRepository.addRoom(room);
    }

    public void updateRoom(Room updateRoom) throws IOException{
        roomRepository.updateRoom(updateRoom);
    }

    public void deleteRoom(Long roomId) throws IOException{ //Elimina una habitacion por su id
        roomRepository.deleteRoom(roomId);
    }



}
