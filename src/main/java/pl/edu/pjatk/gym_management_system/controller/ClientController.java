package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjatk.gym_management_system.Service.ClientService;
import pl.edu.pjatk.gym_management_system.model.Client;

import java.util.List;

@RestController
@RequestMapping("/Client/")
public class ClientController {
    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){ this.clientService = clientService;}

    @GetMapping
    public ResponseEntity<List<Client>> getAllClient(){return ResponseEntity.ok(clientService.findAllClients());}
}
