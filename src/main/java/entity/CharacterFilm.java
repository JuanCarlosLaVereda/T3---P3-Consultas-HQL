package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "character_films", schema = "starwars")
public class CharacterFilm {
    @EmbeddedId
    private CharacterFilmId id;

    @MapsId("idCharacter")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_character", nullable = false)
    private entity.Character idCharacter;

    @MapsId("idFilm")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_film", nullable = false)
    private entity.Film idFilm;

    public CharacterFilmId getId() {
        return id;
    }

    public void setId(CharacterFilmId id) {
        this.id = id;
    }

    public entity.Character getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(entity.Character idCharacter) {
        this.idCharacter = idCharacter;
    }

    public entity.Film getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(entity.Film idFilm) {
        this.idFilm = idFilm;
    }

}