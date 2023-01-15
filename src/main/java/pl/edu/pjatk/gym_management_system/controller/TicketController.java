package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.Service.TicketService;
import pl.edu.pjatk.gym_management_system.model.Ticket;
import pl.edu.pjatk.gym_management_system.model.enums.TicketCategory;

import java.util.List;

@RestController
@RequestMapping("/api/Ticket/")
public class TicketController {

    TicketService ticketService;

    @Autowired
    public  TicketController(TicketService ticketService){this.ticketService = ticketService;}

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTicket(){return ResponseEntity.ok(ticketService.findAllTickets());}

    @PostMapping
    public  ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        return  ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id){
        return  ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @DeleteMapping
    public  ResponseEntity<String> deleteAuthorById(@RequestParam("id")Long id){
        ticketService.deleteTicketById(id);
        return ResponseEntity.ok("Ticket was removed");
    }

    @GetMapping("/category")
    public  ResponseEntity<Ticket> findTicketByCategory(@RequestParam(name = "category")TicketCategory category){
        return  ResponseEntity.ok(ticketService.findTicketByCategory(category));
    }
}
