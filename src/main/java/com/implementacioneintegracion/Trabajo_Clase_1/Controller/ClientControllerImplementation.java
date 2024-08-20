package com.implementacioneintegracion.Trabajo_Clase_1.Controller;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Client;
import com.implementacioneintegracion.Trabajo_Clase_1.Service.ClientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientControllerImplementation implements ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientControllerImplementation (ClientService clientService)
    {
        this.clientService = clientService;
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<String> addClient(Client client) {
        clientService.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body("Client successfully created");
    }

    @GetMapping("/id/{id}")
    @Override
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientById(id));
    }

    @GetMapping("/email/{email}")
    @Override
    public ResponseEntity<Client> getClientByEmail(@PathVariable("email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientByEmail(email));
    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    @Override
    public ResponseEntity<Client> getClientByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientByPhoneNumber(phoneNumber));
    }

    @PutMapping("")
    @Override
    public ResponseEntity<String> updateClient(@RequestBody Client newClient) throws Exception {
        clientService.updateClient(newClient.getId(), newClient);
        return ResponseEntity.status(HttpStatus.OK).body("Client was updated successfully");
    }

    @DeleteMapping("{id}")
    @Override
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully");
    }
}
