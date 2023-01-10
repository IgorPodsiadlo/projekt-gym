package pl.edu.pjatk.gym_management_system.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Start_date")
    private LocalDate startDate;

    @Column(name="End_date")
    private LocalDate endDate;

    @Column(name = "needs_repair")
    private boolean needsfixing;



public Equipment(){

}

    public Equipment(Long id, LocalDate startDate, LocalDate endDate, boolean needsfixing, Client client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.needsfixing = needsfixing;

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

    public boolean isNeedsfixing() {
        return needsfixing;
    }

}
