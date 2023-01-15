package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.Service.EquipmentService;
import pl.edu.pjatk.gym_management_system.model.Building;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.model.Equipment;

import java.util.List;

@RestController
@RequestMapping("/api/Equipment/")
public class EquipmentController {
    EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService){this.equipmentService = equipmentService;}

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment(){return ResponseEntity.ok(equipmentService.findAllEquipment());}
    @PostMapping
    public   ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment){
        return ResponseEntity.ok(equipmentService.createEquipment(equipment));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(equipmentService.getEquipmentById(id));
    }

    @DeleteMapping
    public  ResponseEntity<String> deleteEquipmentById(@RequestParam("id") Long id){
        equipmentService.deleteEquipmentById(id);
        return  ResponseEntity.ok("Equipment was deleted");
    }
    @GetMapping("/fixing")
    public ResponseEntity<Equipment> findEquipmentByNeedsfixing(@RequestParam(name = "needs_repair") boolean needs_repair){
        return  ResponseEntity.ok(equipmentService.findEquipmentByNeedsfixing(needs_repair));
    }

    @PutMapping("{id}")
    public  ResponseEntity<Equipment> updateEquipment (@RequestBody Equipment equipment, @PathVariable("id") Long id){
        return  ResponseEntity.ok((equipmentService.updateEquipment(id,equipment)));
    }
}
