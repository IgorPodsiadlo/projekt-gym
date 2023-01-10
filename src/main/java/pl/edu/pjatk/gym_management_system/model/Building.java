package pl.edu.pjatk.gym_management_system.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Opening_Time")
    private LocalDate openTime;

    @Column(name = "Closing_Time")
    private LocalDate closicTime;

    @OneToOne(fetch = FetchType.EAGER)
    private Trainer closingPerson;

    public Building(){

    }

    public Building(Long id, LocalDate openTime, LocalDate closicTime, Trainer closingPerson) {
        this.id = id;
        this.openTime = openTime;
        this.closicTime = closicTime;
        this.closingPerson = closingPerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOpenTime() {
        return openTime;
    }

    public LocalDate getClosicTime() {
        return closicTime;
    }

    public Trainer getClosingPerson() {
        return closingPerson;
    }
}
