package com.example.ReservationSystem.controller;

import com.example.ReservationSystem.model.Room;
import com.example.ReservationSystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController //Definir la clase como controlador REST
@RequestMapping("/api/rooms") //Ruta para las solicitudes
public class RoomController {
    @Autowired //Inyectar la instancia RoomService
    private RoomService roomService;

    @GetMapping //Para manejar las solicitudes HTTP GET
    public ResponseEntity<List<Room>> getAllRooms() throws IOException{
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{roomId}") //Obtiene una habitacion por su Id especifico
    public ResponseEntity<Room> getRoomById(@PathVariable Long roomId) throws IOException { //Indica que el valor de la variable {roomId} debe asignarse al parámetro roomId del método
        Room room = roomService.getRoomById(roomId);
        if (room != null) {
            return new ResponseEntity<>(room, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping //Maneja las solicitudes HTTP POST para agregar una nueva habitacion
    public ResponseEntity<Void> addRoom(@RequestBody Room room) throws IOException { //Indica que el cuerpo de la solicitud HTTP debe ser un objeto Room
        roomService.addRoom(room);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<Void> updateRoom(@PathVariable Long roomId, @RequestBody Room updatedRoom) throws IOException {
        updatedRoom.setId(roomId);
        roomService.updateRoom(updatedRoom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomId) throws IOException {
        roomService.deleteRoom(roomId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
