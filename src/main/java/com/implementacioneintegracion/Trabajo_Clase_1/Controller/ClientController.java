package com.implementacioneintegracion.Trabajo_Clase_1.Controller;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Client;
import org.apache.tomcat.util.buf.StringCache;
import org.springframework.http.ResponseEntity;

public interface ClientController {
    public ResponseEntity<String> addClient(Client client);

    public ResponseEntity<Client> getClientById(Long id);

    public ResponseEntity<Client> getClientByEmail(String email);

    public ResponseEntity<Client> getClientByPhoneNumber(String phoneNumber);

    public ResponseEntity<String> updateClient(Client newClient) throws Exception;

    public ResponseEntity<String> deleteClient(Long id);
}
