package Cinema.Controller;

import Cinema.Entities.Acteur;
import Cinema.Entities.Joue;
import Cinema.Model.TypeRole;
import Cinema.Repository.JoueRepository;
import Cinema.Service.ActeurService;
import Cinema.Entities.Film;
import Cinema.Service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/film")
@AllArgsConstructor

public class FilmController {


    private final FilmService filmService;

    private final ActeurService acteurService;

    private final JoueRepository joueRepository;

    @GetMapping
    public List<Film> getFilms(){
            return filmService.getFilms();
    }

    @PostMapping
    public void addFilm(@RequestBody Film film){
        filmService.save(film);
    }

    @PutMapping("/{idFilm}/acteur/{idActeur}")
    public Film addActeur(
            @PathVariable Long idFilm,
            @PathVariable Long idActeur,
            TypeRole typeRole,
            String role
            ){
        System.out.println(idFilm+idActeur);
        Film film = filmService.getFilmById(idFilm);
        Acteur acteur = acteurService.getActeurById(idActeur);
        film.addActeurToFilm(acteur);
        Joue joue = new Joue(typeRole,role);
        joueRepository.save(joue);
        return filmService.save(film);
    }
}
