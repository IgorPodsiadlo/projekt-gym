package pl.edu.pjatk.gym_management_system.model;

import org.springframework.expression.spel.CodeFlow;
import pl.edu.pjatk.gym_management_system.model.enums.Gender;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "First_name")
    private String firstName;
    @Column(name = "Last_name")
    private String lastName;
    @Column(name="Age")
    private int age;
    @Column(name="Gender")
    private Gender gender;

    @OneToOne(fetch = FetchType.EAGER)
    private Ticket ticket;

    public Client(){

    }

    public Client(Long id, String firstName, String lastName, int age, Gender gender, Ticket ticket) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.ticket = ticket;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
