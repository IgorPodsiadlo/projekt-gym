package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.Service.TicketService;
import pl.edu.pjatk.gym_management_system.model.Ticket;
import pl.edu.pjatk.gym_management_system.model.enums.TicketCategory;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/Ticket/")
public class TicketController {

    TicketService ticketService;
    Logger log = Logger.getLogger(TicketController.class.getName());

    @Autowired
    public  TicketController(TicketService ticketService){
        this.ticketService = ticketService;}

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTicket(){
        log.info("get all tickets");
        return ResponseEntity.ok(ticketService.findAllTickets());}

    @PostMapping
    public  ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        log.info("create ticked");
        return  ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id){
        log.info("get ticket by id");
        return  ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @DeleteMapping
    public  ResponseEntity<String> deleteTicketById(@RequestParam("id")Long id){
        log.info("delete ticked by id");
        ticketService.deleteTicketById(id);
        return ResponseEntity.ok("Ticket was removed");
    }

    @GetMapping("/category")
    public  ResponseEntity<List<Ticket>> findTicketByCategory(@RequestParam(name = "category")TicketCategory category){
        log.info("find ticked by category");
        return  ResponseEntity.ok(ticketService.findTicketByCategory(category));
    }
}
