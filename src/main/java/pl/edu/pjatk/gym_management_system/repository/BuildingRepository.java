package pl.edu.pjatk.gym_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.gym_management_system.model.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
