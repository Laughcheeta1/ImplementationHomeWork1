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
        return new ResponseEntity<String>("Client successfully created", HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    @Override
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
        return new ResponseEntity<Client>(clientService.getClientById(id), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    @Override
    public ResponseEntity<Client> getClientByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<Client>(clientService.getClientByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    @Override
    public ResponseEntity<Client> getClientByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return new ResponseEntity<Client>(clientService.getClientByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @PutMapping("")
    @Override
    public ResponseEntity<String> updateClient(@RequestBody Client newClient) throws Exception {
        clientService.updateClient(newClient.getId(), newClient);
        return new ResponseEntity<String>("Client was updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @Override
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<String>("Client deleted successfully", HttpStatus.OK);
    }
}
