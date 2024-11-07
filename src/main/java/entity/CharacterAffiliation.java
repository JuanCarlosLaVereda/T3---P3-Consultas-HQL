package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "character_affiliations", schema = "starwars")
public class CharacterAffiliation {
    @EmbeddedId
    private CharacterAffiliationId id;

    @MapsId("idCharacter")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_character", nullable = false)
    private entity.Character idCharacter;

    @MapsId("idAffiliation")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_affiliation", nullable = false)
    private Affiliation idAffiliation;

    public CharacterAffiliationId getId() {
        return id;
    }

    public void setId(CharacterAffiliationId id) {
        this.id = id;
    }

    public entity.Character getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(entity.Character idCharacter) {
        this.idCharacter = idCharacter;
    }

    public Affiliation getIdAffiliation() {
        return idAffiliation;
    }

    public void setIdAffiliation(Affiliation idAffiliation) {
        this.idAffiliation = idAffiliation;
    }

}