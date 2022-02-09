package Cinema.Controller;

import Cinema.Entities.Acteur;
import Cinema.Service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/acteur")
public class ActeurController {

    @Autowired
    ActeurService acteurService;

    @GetMapping
    public List<Acteur> getActeurs(){
        return acteurService.getActeurs();
    }

    @PostMapping
    public void addActeur(@RequestBody Acteur acteur){
         acteurService.addActeur(acteur);
    }

//    @DeleteMapping
//    public void deleteActeur(@RequestBody Long id ){
//        acteurService.deleteActeur(id);
//    }

    @DeleteMapping
    public void deleteAll(){
        acteurService.deleteAll();
    }
}
