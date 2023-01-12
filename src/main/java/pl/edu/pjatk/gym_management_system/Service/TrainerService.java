package pl.edu.pjatk.gym_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Trainer;
import pl.edu.pjatk.gym_management_system.model.enums.TrainerQualification;
import pl.edu.pjatk.gym_management_system.repository.TrainerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    TrainerRepository trainerRepository;

    @Autowired
    public void TrainerService(TrainerRepository trainerRepository){this.trainerRepository = trainerRepository;}

    public Trainer createTrainer(Trainer trainer){
        return  trainerRepository.save(trainer);
    }

    public List<Trainer> findAllTrainers(){return  trainerRepository.findAll();}

    public Trainer getTrainerById(Long id) {
        Optional<Trainer> b = trainerRepository.findById(id);
        if (b.isPresent()) {
            return b.get();
        }
        throw new IllegalArgumentException();
    }

    public void deleteClientById(Long id){trainerRepository.deleteById(id);}

    public Trainer findTrainerByQualification(TrainerQualification qualification){
        Optional<Trainer> trainer = trainerRepository.findTrainerByQualification(qualification);
        if(trainer.isPresent()){
            return trainer.get();
        }
        throw new IllegalArgumentException();
    }
    public Trainer findTrainerByFirstNameAndLastName(String firstName, String LastName){
        Optional<Trainer> trainer = trainerRepository.findTrainerByFirstNameAndLastName(firstName, LastName);
        if(trainer.isPresent()){
            return trainer.get();
        }
        throw new IllegalArgumentException();
    }
}
