package pl.edu.pjatk.gym_management_system.model;

import pl.edu.pjatk.gym_management_system.model.enums.Gender;
import pl.edu.pjatk.gym_management_system.model.enums.TrainerQualification;

import javax.persistence.*;

@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "qualification")
    private TrainerQualification qualification;


    public Trainer(Long id, String firstName, String lastName, int age, Gender gender, TrainerQualification qualification) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.qualification = qualification;
    }

    public Trainer() {

    }

    public TrainerQualification getQualification() {
        return qualification;
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

    public void setId(Long id) {
        this.id = id;
    }
}
