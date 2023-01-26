package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.Service.BuildingService;
import pl.edu.pjatk.gym_management_system.Service.EquipmentService;
import pl.edu.pjatk.gym_management_system.model.Building;
import pl.edu.pjatk.gym_management_system.model.Client;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/Building/")
public class BuildingController {

    BuildingService buildingService;
    Logger log = Logger.getLogger(BuildingController.class.getName());

    @Autowired
    public  BuildingController(BuildingService buildingService){
        this.buildingService = buildingService;

    }

    @GetMapping
    public ResponseEntity<List<Building>> getAllBuilding(){
        log.info("Got all Building");
        return ResponseEntity.ok(buildingService.findAllBuilding());
    }

    @PostMapping
    public ResponseEntity<Building> createBuilding(@RequestBody Building building){
        log.info("Create Building");
        return ResponseEntity.ok(buildingService.createBuilding(building));
    }

    @DeleteMapping
    public  ResponseEntity<String> deleteBuildingById(@RequestParam("id") Long id){
        log.info("delete Building");
        buildingService.deleteBuildingById(id);
        return ResponseEntity.ok("Building was deleted");
    }

    @PutMapping("{id}")
    public  ResponseEntity<Building> updateBuilding (@RequestBody Building building, @PathVariable("id") Long id){
        log.info("Update Building");
        return  ResponseEntity.ok((buildingService.updateBuilding(id,building)));
    }


}
