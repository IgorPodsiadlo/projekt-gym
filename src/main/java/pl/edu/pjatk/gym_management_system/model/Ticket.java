package pl.edu.pjatk.gym_management_system.model;

import com.sun.istack.NotNull;
import pl.edu.pjatk.gym_management_system.model.enums.TicketCategory;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Start_date")
    private LocalDate startDate;
    @Column(name="End_date")
    private LocalDate endDate;
    @Column(name="Ticket_category")
    private TicketCategory ticketCategory;


   public Ticket(){

   }

    public Ticket(Long id, LocalDate startDate, LocalDate endDate, TicketCategory ticketCategory, Client ownerId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketCategory = ticketCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }


    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

}
