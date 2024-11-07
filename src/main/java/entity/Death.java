package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "deaths", schema = "starwars")
@NamedQuery(name = "Deaths.byEpisode", query = "SELECT c.name AS dead_character_name, k.name AS killer_name FROM Character c INNER JOIN Death d ON c.id = d.id LEFT JOIN Character k ON d.id = k.id WHERE d.idFilm = :episode")
public class Death {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_character")
    private Character idCharacter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_killer")
    private Character idKiller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_film")
    private entity.Film idFilm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(Character idCharacter) {
        this.idCharacter = idCharacter;
    }

    public Character getIdKiller() {
        return idKiller;
    }

    public void setIdKiller(Character idKiller) {
        this.idKiller = idKiller;
    }

    public entity.Film getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(entity.Film idFilm) {
        this.idFilm = idFilm;
    }

}