package pl.edu.pjatk.gym_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.gym_management_system.model.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findClientByFistNameAndLastName(String firstName, String lastName);
    Client findClientByFirstName(String firstName);
}
