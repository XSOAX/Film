package Cinema.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class JoueKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "idFilm")
    private Film film;

    public Film getFilm(){
        return film;
    }
    public void setFilm(Film film){
        this.film = film;
    }


    @ManyToOne
    @JoinColumn(name = "idActeur")
    private Acteur acteur;

    public Acteur getActeur(){
        return acteur;
    }
    public void setActeur(Acteur acteur){
        this.acteur = acteur;
    }

}
