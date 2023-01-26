package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.Service.EquipmentService;
import pl.edu.pjatk.gym_management_system.model.Building;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.model.Equipment;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/Equipment/")
public class EquipmentController {
    EquipmentService equipmentService;
    Logger log = Logger.getLogger(EquipmentController.class.getName());

    @Autowired
    public EquipmentController(EquipmentService equipmentService){

        this.equipmentService = equipmentService;}

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment(){
        log.info("get all equipment");
        return ResponseEntity.ok(equipmentService.findAllEquipment());}
    @PostMapping
    public   ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment){
        log.info("create equipment");
        return ResponseEntity.ok(equipmentService.createEquipment(equipment));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable("id") Long id){
        log.info("get equipment by id");
        return ResponseEntity.ok(equipmentService.getEquipmentById(id));
    }

    @DeleteMapping
    public  ResponseEntity<String> deleteEquipmentById(@RequestParam("id") Long id){
        log.info("delete equipment");
        equipmentService.deleteEquipmentById(id);
        return  ResponseEntity.ok("Equipment was deleted");
    }
    @GetMapping("/fixing")
    public ResponseEntity<List<Equipment>> findEquipmentByNeedsfixing(@RequestParam(name = "needs_repair") boolean needs_repair){
        log.info("do equipment need fixing");
        return  ResponseEntity.ok(equipmentService.findEquipmentByNeedsfixing(needs_repair));
    }

    @PutMapping("{id}")
    public  ResponseEntity<Equipment> updateEquipment (@RequestBody Equipment equipment, @PathVariable("id") Long id){
        log.info("updated equipment");
        return  ResponseEntity.ok((equipmentService.updateEquipment(id,equipment)));
    }
}
