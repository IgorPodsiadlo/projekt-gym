package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public  ResponseEntity<Client> createClient(@RequestBody Client client){
        return ResponseEntity.ok(clientService.createClient(client));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }
    @GetMapping("/get")
    public ResponseEntity<Client> getClientByIdRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAuthorById(@PathVariable("id") Long id){
        clientService.deleteClientById(id);
        return ResponseEntity.ok("ok");
    }
}
