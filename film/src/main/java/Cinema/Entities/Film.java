package Cinema.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "Film")
public class Film {
    @Id
    @SequenceGenerator(
            name = "film_sequence",
            sequenceName = "film_sequence",
            allocationSize = 1
    )
    @Column(name = "idFilm",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_sequence")
    private Long idFilm;
    private String nom;
    private int duree;
    @ManyToMany
    @JoinTable(
            name = "Joue",
            joinColumns = @JoinColumn(name = "idFilm"),
            inverseJoinColumns = @JoinColumn(name= "idActeur")
    )
    private Set<Acteur> distribution = new HashSet<>();

    @OneToMany(mappedBy = "joueKeyId.film")
    private Set<Joue> joues = new HashSet<Joue>();
    public Set<Joue> getJoues() {
        return this.joues;
    }
    public void setRoles(Set<Joue> j) {
        this.joues = j;
    }

    public Film(String nom, int duree) {
        this.nom = nom;
        this.duree = duree;
    }

    public void addActeurToFilm(Acteur acteur){
        distribution.add(acteur);
    }
}
