package Cinema.Entities;

import Cinema.Model.TypeRole;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Joue{

    @EmbeddedId
    JoueKey joueKeyId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_role")
    private TypeRole typeRole;

    @Column(name = "nom_role")
    private String role;

    public Joue(TypeRole typeRole, String role) {
        this.typeRole = typeRole;
        this.role=role;
    }

    public Film getFilm(){
        return joueKeyId.getFilm();
    }
    public void setFilm(Film film){
        getJoueKeyId().setFilm(film);
    }

    public Acteur getActeur(){
        return joueKeyId.getActeur();
    }
    public void setActeur(Acteur acteur){
        getJoueKeyId().setActeur(acteur);
    }
}
