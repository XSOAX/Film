package Cinema.Service;

import Cinema.Entities.Film;
import Cinema.Repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmService {

    FilmRepository filmRepository;

    public List<Film> getFilms(){
        return filmRepository.findAll();
    }

    public void addFilm(Film film){
        filmRepository.save(film);
    }

    public Film getFilmById(Long id){
        return filmRepository.findById(id).get();
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }
}
