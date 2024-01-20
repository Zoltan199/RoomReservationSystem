package com.example.ReservationSystem.repository;

import com.example.ReservationSystem.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class RoomRepository {
    public List<Room> getRooms() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Load the JSON file from the resources directory
        Resource resource = new ClassPathResource("/data/room.json");
        File file = resource.getFile();

        // Use readValue method to convert JSON to List of YourObject
        List<Room> RoomList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Room.class));

        return RoomList;
    }
    public Room getRoomById(Long roomId) throws IOException{
        return getRooms().stream().filter(room -> room.getId().equals(roomId)).findFirst().orElse(null);
    }

    public void  addRoom(Room room)throws IOException{
        List<Room> rooms=getRooms();
        room.setId(Room.generateId(rooms));
        rooms.add(room);
        saveRooms(rooms);
    }

    private void saveRooms(List<Room> rooms) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("/data/room.json");
        objectMapper.writeValue(resource.getFile(), rooms);
    }

    public void updateRoom(Room updateRoom)throws IOException{
        List<Room> rooms = getRooms();
        rooms.replaceAll(room -> room.getId().equals(updateRoom.getId()) ? updateRoom : room);
        saveRooms(rooms);
    }

    public void deleteRoom(Long roomId) throws IOException { //Elimina una habitacion por su id
        List<Room> rooms = getRooms();
        rooms.removeIf(room -> room.getId().equals(roomId));
        saveRooms(rooms);
    }
}
