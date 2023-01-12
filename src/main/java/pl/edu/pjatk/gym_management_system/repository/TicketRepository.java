package pl.edu.pjatk.gym_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.gym_management_system.model.Ticket;
import pl.edu.pjatk.gym_management_system.model.enums.TicketCategory;

import java.util.Optional;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findTicketByTicketCategory(TicketCategory ticketCategory);
}
