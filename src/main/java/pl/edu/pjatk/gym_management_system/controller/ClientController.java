package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.Service.ClientService;
import pl.edu.pjatk.gym_management_system.model.Building;
import pl.edu.pjatk.gym_management_system.model.Client;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/Client/")
public class ClientController {
    ClientService clientService;

    Logger log = Logger.getLogger(ClientController.class.getName());

    @Autowired
    public ClientController(ClientService clientService){ this.clientService = clientService;}

    @GetMapping
    public ResponseEntity<List<Client>> getAllClient(){
        log.info("Got all Clients");
        return ResponseEntity.ok(clientService.findAllClients());}

    @PostMapping
    public   ResponseEntity<Client> createClient(@RequestBody Client client){
        log.info("create Client");
        return ResponseEntity.ok(clientService.createClient(client));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){
        log.info("get client by id");
        return ResponseEntity.ok(clientService.getClientById(id));
    }
    @GetMapping("/{name}/{lastname}")
    public ResponseEntity<Client> getClientByFirstNameAndLastName(@PathVariable("name") String name , @PathVariable("lastname") String lastname){
        log.info("get client by name and lastname");
        return  ResponseEntity.ok(clientService.findClientByFistNameAndLastName(name, lastname));
    }
    @DeleteMapping
    public ResponseEntity<String> deleteClientById(@RequestParam("id") Long id){
        log.info("delete client");
        clientService.deleteClientById(id);
        return ResponseEntity.ok("ok");
    }
    @PutMapping("{id}")
    public  ResponseEntity<Client> updateClient (@RequestBody Client client, @PathVariable("id") Long id){
        log.info("update");
        return  ResponseEntity.ok((clientService.updateClient(id,client)));
    }
}
