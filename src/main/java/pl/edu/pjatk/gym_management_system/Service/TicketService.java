package pl.edu.pjatk.gym_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.model.Ticket;
import pl.edu.pjatk.gym_management_system.model.enums.TicketCategory;
import pl.edu.pjatk.gym_management_system.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    TicketRepository ticketRepository;

    @Autowired
    public void TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
public Ticket createTicket(Ticket ticket){
        return  ticketRepository.save(ticket);
}

    public List<Ticket> findAllTickets(){return ticketRepository.findAll();}

    public Ticket getTicketById(Long id) {
        Optional<Ticket> b = ticketRepository.findById(id);
        if (b.isPresent()) {
            return b.get();
        }
        throw new IllegalArgumentException();
    }

    public  void deleteTicketById(Long id){ticketRepository.deleteById(id);}



    public Ticket findTicketByCategory(TicketCategory ticketCategory) {
        Optional<Ticket> b = ticketRepository.findTicketByTicketCategory(ticketCategory);
        if (b.isPresent()) {
            return b.get();
        }
        throw new IllegalArgumentException();
    }
public Ticket updateTicket(Long id, Ticket updatedTicket){
        Ticket ticketToUpdate = getTicketById(id);
        if (updatedTicket.getStartDate() != null){
            ticketToUpdate.setStartDate(updatedTicket.getStartDate());
        }
        if (updatedTicket.getEndDate() != null){
            ticketToUpdate.setEndDate(updatedTicket.getEndDate());
        }
        if (updatedTicket.getTicketCategory() != null){
            ticketToUpdate.setTicketCategory(updatedTicket.getTicketCategory());
        }
        return ticketRepository.save(ticketToUpdate);
}

}
