package Cinema.Service;

import Cinema.Entities.Acteur;
import Cinema.Repository.ActeurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActeurService {

    ActeurRepository acteurRepository;

    public void addActeur(Acteur acteur){
        acteurRepository.save(acteur);
    }

    public List<Acteur> getActeurs(){
        return acteurRepository.findAll();
    }

    public Acteur getActeurById(Long id) {
        return acteurRepository.findById(id).get();
    }

    public void deleteActeur(Long id){
        acteurRepository.deleteById(id);
    }

    public void deleteAll(){
        acteurRepository.deleteAll();
    }

}
