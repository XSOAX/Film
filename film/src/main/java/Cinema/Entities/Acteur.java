package Cinema.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "Acteur")
public class Acteur {
    @Id
    @SequenceGenerator(
            name = "acteur_sequence",
            sequenceName = "acteur_sequence",
            allocationSize = 1
    )
    @Column(name = "idActeur",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acteur_sequence")
    private Long idActeur;
    private String nom;
    private String prenom;


    public Acteur() {
    }

    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "distribution")
    private Set<Film> filmList = new HashSet<>();

    @OneToMany(mappedBy = "joueKeyId.acteur")
    private Set<Joue> joues = new HashSet<Joue>();
    public Set<Joue> getJoues() {
        return this.joues;
    }

}
