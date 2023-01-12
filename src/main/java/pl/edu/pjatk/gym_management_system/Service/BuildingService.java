package pl.edu.pjatk.gym_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Building;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.repository.BuildingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {
    BuildingRepository buildingRepository;

    @Autowired
    public void BuildingService(BuildingRepository buildingRepository){this.buildingRepository = buildingRepository;}

    public Building createBuilding(Building building){
        return buildingRepository.save(building);
    }
    public List<Building> findAllBuilding(){return buildingRepository.findAll();}

    public Building getBuildingId(Long id){
        Optional<Building> b = buildingRepository.findById(id);
        if (b.isPresent()) {
            return b.get();
        }
        throw new IllegalArgumentException();
    }


}
