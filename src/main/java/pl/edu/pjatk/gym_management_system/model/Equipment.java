package pl.edu.pjatk.gym_management_system.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Start_date")
    private LocalDateTime startDate;

    @Column(name="End_date")
    private LocalDateTime endDate;

    @Column(name = "needs_repair")
    private boolean needsfixing;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Client> client;



public Equipment(){

}

    public Equipment(Long id, LocalDateTime startDate, LocalDateTime endDate, boolean needsfixing, List<Client> client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.needsfixing = needsfixing;
        this.client = client;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public boolean isNeedsfixing() {
        return needsfixing;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setNeedsfixing(boolean needsfixing) {
        this.needsfixing = needsfixing;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }
}
