package com.implementacioneintegracion.Trabajo_Clase_1.Service;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Client;


public interface ClientService {
    public void saveClient(Client client);

    public Client getClientById(Long id);

    public Client getClientByEmail(String email);

    public Client getClientByPhoneNumber(String phoneNumber);

    public void updateClient(Long id, Client client) throws Exception;

    public void deleteClient(Long id);
}
