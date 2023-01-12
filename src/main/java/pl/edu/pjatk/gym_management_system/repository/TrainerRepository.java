package pl.edu.pjatk.gym_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.gym_management_system.model.Trainer;
import pl.edu.pjatk.gym_management_system.model.enums.TrainerQualification;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Optional<Trainer> findTrainerByQualification(TrainerQualification qualification);
    Optional<Trainer> findTrainerByFirstNameAndLastName(String firstName, String LastName);
}
