package com.implementacioneintegracion.Trabajo_Clase_1.Service;

import com.implementacioneintegracion.Trabajo_Clase_1.Exceptions.CustomExceptions.ClientNotFoundException;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Client;

import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImplementation implements ClientService {
    private final ClientDao clientDao;

    @Autowired
    public ClientServiceImplementation(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void saveClient(Client client) {
        clientDao.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientDao.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientDao.findByEmail(email).orElseThrow(() -> new ClientNotFoundException("email: " + email));
    }

    @Override
    public Client getClientByPhoneNumber(String phoneNumber) {
        return clientDao.findByPhoneNumber(phoneNumber).orElseThrow(() -> new ClientNotFoundException("phone number: " + phoneNumber));
    }

    @Override
    public void updateClient(Long id, Client client) throws Exception {
        Client clientInDb = clientDao.findById(id).orElse(null);
        if (clientInDb == null)
            throw new ClientNotFoundException(id);

        if (! clientInDb.getId().equals(client.getId()))
            throw new Exception("Cannot change the id of the client");

        clientInDb.setName(client.getName());
        clientInDb.setEmail(client.getEmail());
        clientInDb.setPhoneNumber(client.getPhoneNumber());

    }

    @Override
    public void deleteClient(Long id) {
        clientDao.deleteById(id);
    }
}
