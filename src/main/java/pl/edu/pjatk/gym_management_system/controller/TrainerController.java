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

@RestController
@RequestMapping("/Trainer/")
public class TrainerController {
    TrainerService trainerService;

    @Autowired
    public  TrainerController(TrainerService trainerService){this.trainerService = trainerService;}

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainer(){return  ResponseEntity.ok(trainerService.findAllTrainers());}

    @PostMapping()
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer){
        return ResponseEntity.ok(trainerService.createTrainer(trainer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable("id") Long id){
        return  ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @DeleteMapping
    public  ResponseEntity<String> deleteAuthorById(@RequestParam("id") Long id){
        trainerService.deleteClientById(id);
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/qualification")
    public ResponseEntity<Trainer> findTrainerByQualification(@RequestParam(name = "qualification") TrainerQualification qualification){
        return  ResponseEntity.ok(trainerService.findTrainerByQualification(qualification));

    }
    @GetMapping("/{name}/{lastname}")
    public ResponseEntity<Trainer> findTrainerByFirstNameAndLastName(@PathVariable("name") String name , @PathVariable("lastname") String lastname){
        return  ResponseEntity.ok(trainerService.findTrainerByFirstNameAndLastName(name, lastname));
    }
    @PutMapping("{id}")
    public  ResponseEntity<Trainer> updateTrainer (@RequestBody Trainer trainer, @PathVariable("id") Long id){
        return  ResponseEntity.ok(trainerService.updateTrainer(id,trainer));
    }
}
