package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.Service.TrainerService;
import pl.edu.pjatk.gym_management_system.model.Building;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.model.Trainer;
import pl.edu.pjatk.gym_management_system.model.enums.TrainerQualification;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/Trainer/")
public class TrainerController {
    TrainerService trainerService;
    Logger log = Logger.getLogger(TrainerController.class.getName());

    @Autowired
    public  TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;}

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainer(){
        log.info("get all trainers");
        return  ResponseEntity.ok(trainerService.findAllTrainers());}

    @PostMapping()
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer){
        log.info("create trainer");
        return ResponseEntity.ok(trainerService.createTrainer(trainer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable("id") Long id){
        log.info("get  trainer by id");
        return  ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @DeleteMapping
    public  ResponseEntity<String> deleteTrainerById(@RequestParam("id") Long id){
        log.info("delete trainer");
        trainerService.deleteClientById(id);
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/qualification")
    public ResponseEntity<List<Trainer>> findTrainerByQualification(@RequestParam(name = "qualification") TrainerQualification qualification){
        log.info("get trainer by qualification");
        return  ResponseEntity.ok(trainerService.findTrainerByQualification(qualification));

    }
    @GetMapping("/{name}/{lastname}")
    public ResponseEntity<Trainer> getTrainerByFirstNameAndLastName(@PathVariable("name") String name , @PathVariable("lastname") String lastname){
        log.info("get trainer by name and lastname");
        return  ResponseEntity.ok(trainerService.findTrainerByFirstNameAndLastName(name, lastname));
    }
    @PutMapping("{id}")
    public  ResponseEntity<Trainer> updateTrainer (@RequestBody Trainer trainer, @PathVariable("id") Long id){
        log.info("update trainer");
        return  ResponseEntity.ok(trainerService.updateTrainer(id,trainer));
    }
}
