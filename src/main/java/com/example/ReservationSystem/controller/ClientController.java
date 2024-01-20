package com.example.ReservationSystem.controller;

import com.example.ReservationSystem.model.Client;
import com.example.ReservationSystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController //Definir la clase como controlador REST
@RequestMapping("/api/clients") //Ruta para las solicitudes
public class ClientController {
    @Autowired //Inyectar la instancia RoomService
    private ClientService clientService;

    @GetMapping //Para manejar las solicitudes HTTP GET
    public ResponseEntity<List<Client>> getAllClients() throws IOException {
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{clientId}") //Obtiene un cliente por su Id especifico
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) throws IOException { //Indica que el valor de la variable {roomId} debe asignarse al parámetro roomId del método
        Client client = clientService.getClientById(clientId);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping //Maneja las solicitudes HTTP POST para agregar un nuevo cliente
    public ResponseEntity<Void> addClient(@RequestBody Client client) throws IOException { //Indica que el cuerpo de la solicitud HTTP debe ser un objeto Client
        clientService.addClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Void> updateClient(@PathVariable Long clientId, @RequestBody Client updatedClient) throws IOException {
        updatedClient.setId(clientId);
        clientService.updateClient(updatedClient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) throws IOException {
        clientService.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
