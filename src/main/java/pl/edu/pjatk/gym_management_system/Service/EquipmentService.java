package pl.edu.pjatk.gym_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Equipment;
import pl.edu.pjatk.gym_management_system.repository.EquipmentRepository;


import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    EquipmentRepository equipmentRepository;
    @Autowired
    public void EquipmentService(EquipmentRepository equipmentRepository){this.equipmentRepository = equipmentRepository;}
public List<Equipment> findAllEquipment(){return  equipmentRepository.findAll();}
    public Equipment createEquipment(Equipment equipment){

        return equipmentRepository.save(equipment);
    }

    public  void  deleteEquipmentById(Long id){equipmentRepository.deleteById(id);}
    public  Equipment getEquipmentById(Long id) {
        Optional<Equipment> b = equipmentRepository.findById(id);
        if (b.isPresent()) {
            return b.get();
        }
        throw new IllegalArgumentException();
    }

    public  List<Equipment> findEquipmentByNeedsfixing(Boolean  needs_repair){
       return equipmentRepository.findEquipmentByNeedsfixing(needs_repair);

    }

    public Equipment updateEquipment(Long id , Equipment updatedEquipment){
        Equipment equipmentToUpdate = getEquipmentById(id);

        if (updatedEquipment.getStartDate() != null){
            equipmentToUpdate.setStartDate(updatedEquipment.getStartDate());

        }
        if (updatedEquipment.getEndDate() != null){
            equipmentToUpdate.setEndDate(updatedEquipment.getEndDate());
        }
        if(updatedEquipment.isNeedsfixing() != false){
            equipmentToUpdate.setNeedsfixing(updatedEquipment.isNeedsfixing());
        }

        return equipmentRepository.save(equipmentToUpdate);
    }
}
