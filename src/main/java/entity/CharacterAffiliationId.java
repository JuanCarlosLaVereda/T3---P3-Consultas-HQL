package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class CharacterAffiliationId implements java.io.Serializable {
    private static final long serialVersionUID = -1320001861932869710L;
    @Column(name = "id_character", nullable = false)
    private Integer idCharacter;

    @Column(name = "id_affiliation", nullable = false)
    private Integer idAffiliation;

    public Integer getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(Integer idCharacter) {
        this.idCharacter = idCharacter;
    }

    public Integer getIdAffiliation() {
        return idAffiliation;
    }

    public void setIdAffiliation(Integer idAffiliation) {
        this.idAffiliation = idAffiliation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CharacterAffiliationId entity = (CharacterAffiliationId) o;
        return Objects.equals(this.idAffiliation, entity.idAffiliation) &&
                Objects.equals(this.idCharacter, entity.idCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAffiliation, idCharacter);
    }

}