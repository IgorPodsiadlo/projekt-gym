package pl.edu.pjatk.gym_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.gym_management_system.model.Equipment;

import java.util.Optional;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    Optional<Equipment> findEquipmentByNeedsfixing(Boolean  needs_repair);
}
