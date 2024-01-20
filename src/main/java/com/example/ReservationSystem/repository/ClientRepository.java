package com.example.ReservationSystem.repository;

import com.example.ReservationSystem.model.Client;
import com.example.ReservationSystem.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class ClientRepository {
    public List<Client> getClients() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();

        Resource resource = new ClassPathResource("/data/client.json");
        File file = resource.getFile();


        List<Client> ClientList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Client.class));

        return ClientList;
    }

    public Client getClientById(Long clientId) throws IOException{
        return getClients().stream().filter(client -> client.getId().equals(clientId)).findFirst().orElse(null);
    }

    public void  addClient(Client client)throws IOException{
        List<Client> clients=getClients();
        client.setId(Client.generateId(clients));
        clients.add(client);
        saveClients(clients);
    }

    private void saveClients(List<Client> clients) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("/data/client.json");
        objectMapper.writeValue(resource.getFile(), clients);
    }

    public void updateClient(Client updateClient)throws IOException{
        List<Client> clients = getClients();
        clients.replaceAll(client -> client.getId().equals(updateClient.getId()) ? updateClient : client);
        saveClients(clients);
    }

    public void deleteClient(Long clientId) throws IOException { //Elimina un cliente por su id
        List<Client> clients = getClients();
        clients.removeIf(client -> client.getId().equals(clientId));
        saveClients(clients);
    }

}
