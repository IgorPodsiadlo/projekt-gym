package pl.edu.pjatk.gym_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.gym_management_system.model.Ticket;
import pl.edu.pjatk.gym_management_system.model.enums.TicketCategory;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findTicketByTicketCategory(TicketCategory ticketCategory);
}
