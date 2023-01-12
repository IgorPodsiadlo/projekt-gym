package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.Service.BuildingService;
import pl.edu.pjatk.gym_management_system.Service.EquipmentService;
import pl.edu.pjatk.gym_management_system.model.Building;
import pl.edu.pjatk.gym_management_system.model.Client;

import java.util.List;

@RestController
@RequestMapping("/Building/")
public class BuildingController {

    BuildingService buildingService;

    @Autowired
    public  BuildingController(BuildingService buildingService){
        this.buildingService = buildingService;

    }

    @GetMapping
    public ResponseEntity<List<Building>> getAllBuilding(){
        return ResponseEntity.ok(buildingService.findAllBuilding());
    }

    @PostMapping
    public ResponseEntity<Building> createBuilding(@RequestBody Building building){
        return ResponseEntity.ok(buildingService.createBuilding(building));
    }

    @DeleteMapping
    public  ResponseEntity<String> deleteBuildingById(@RequestParam("id") Long id){
        buildingService.deleteBuildingById(id);
        return ResponseEntity.ok("Building was deleted");
    }

    @PutMapping("{id}")
    public  ResponseEntity<Building> updateBuilding (@RequestBody Building building, @PathVariable("id") Long id){
        return  ResponseEntity.ok((buildingService.updateBuilding(id,building)));
    }


}
