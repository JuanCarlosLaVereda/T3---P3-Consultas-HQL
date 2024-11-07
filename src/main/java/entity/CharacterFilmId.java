package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class CharacterFilmId implements java.io.Serializable {
    private static final long serialVersionUID = -3683380612640447171L;
    @Column(name = "id_character", nullable = false)
    private Integer idCharacter;

    @Column(name = "id_film", nullable = false)
    private Integer idFilm;

    public Integer getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(Integer idCharacter) {
        this.idCharacter = idCharacter;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CharacterFilmId entity = (CharacterFilmId) o;
        return Objects.equals(this.idFilm, entity.idFilm) &&
                Objects.equals(this.idCharacter, entity.idCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, idCharacter);
    }

}