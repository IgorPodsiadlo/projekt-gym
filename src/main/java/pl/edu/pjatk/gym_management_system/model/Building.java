package pl.edu.pjatk.gym_management_system.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Opening_Time")
    private LocalDateTime openTime;

    @Column(name = "Closing_Time")
    private LocalDateTime closicTime;


    public Building(){

    }

    public Building(Long id, LocalDateTime openTime, LocalDateTime closicTime) {
        this.id = id;
        this.openTime = openTime;
        this.closicTime = closicTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public LocalDateTime getClosicTime() {
        return closicTime;
    }

    public void setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
    }

    public void setClosicTime(LocalDateTime closicTime) {
        this.closicTime = closicTime;
    }
}
