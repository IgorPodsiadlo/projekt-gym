package pl.edu.pjatk.gym_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.model.Equipment;
import pl.edu.pjatk.gym_management_system.repository.EquipmentRepository;
import pl.edu.pjatk.gym_management_system.repository.TrainerRepository;

import java.util.Optional;

@Service
public class EquipmentService {

    EquipmentRepository equipmentRepository;

    @Autowired
    public void EquipmentService(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment createEquipment(Equipment equipment){
        return equipmentRepository.save(equipment);
    }

    public  Equipment getEquipmentById(Long id) {
        Optional<Equipment> b = equipmentRepository.findById(id);
        if (b.isPresent()) {
            return b.get();
        }
        throw new IllegalArgumentException();
    }
}
