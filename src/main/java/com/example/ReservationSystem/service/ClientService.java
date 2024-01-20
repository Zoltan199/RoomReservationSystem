package com.example.ReservationSystem.service;

import com.example.ReservationSystem.model.Client;
import com.example.ReservationSystem.repository.ClientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    //private final String filePath = "/resources/data/data.json"; //Ruta a la capa de datos

    //private final ObjectMapper objectMapper = new ObjectMapper(); //Objeto de Jackson para convertir Java-JSON

    public List<Client> getAllClients() throws IOException { //Lee los clientes en el archivo data.json y las devuelve en una lista de objetos Client
        return clientRepository.getClients();
    }

    public Client getClientById(Long clientId) throws IOException{
        return clientRepository.getClientById(clientId);
        //Busca los clientes con el metodo anterior, y filtra solo aquellos que tengan el clientId que se pasa como parametro a la funcion
    }

    public void addClient(Client client)throws IOException{ //Agrega un nuevo cliente, usa la funcion generateId para que no se repita y el id sea unico
        clientRepository.addClient(client);
    }

    public void updateClient(Client updateClient) throws IOException{
        clientRepository.updateClient(updateClient);
    }

    public void deleteClient(Long clientId) throws IOException{ //Elimina un cliente por su id
        clientRepository.deleteClient(clientId);
    }


}
