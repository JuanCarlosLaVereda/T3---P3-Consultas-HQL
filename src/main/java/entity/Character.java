package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@NamedQuery(name = "Character.byAffiliation", query = "SELECT c FROM Character c JOIN CharacterAffiliation ca ON c.id = ca.idCharacter.id JOIN Affiliation a ON ca.idCharacter.id = a.id WHERE a.affiliation = ?1")
@Table(name = "characters", schema = "starwars")
public class Character {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private Integer height;

    @Column(name = "mass")
    private Float mass;

    @Lob
    @Column(name = "hair_color")
    private String hairColor;

    @Lob
    @Column(name = "skin_color")
    private String skinColor;

    @Lob
    @Column(name = "eye_color")
    private String eyeColor;

    @Lob
    @Column(name = "birth_year")
    private String birthYear;

    @Lob
    @Column(name = "gender")
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "planet_id", nullable = false)
    private entity.Planet planet;

    @ColumnDefault("current_timestamp()")
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @ColumnDefault("current_timestamp()")
    @Column(name = "updated_date", nullable = false)
    private Instant updatedDate;

    @Lob
    @Column(name = "url")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getMass() {
        return mass;
    }

    public void setMass(Float mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public entity.Planet getPlanet() {
        return planet;
    }

    public void setPlanet(entity.Planet planet) {
        this.planet = planet;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", hairColor='" + hairColor + '\'' +
                ", skinColor='" + skinColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", gender='" + gender + '\'' +
                ", planet=" + planet +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", url='" + url + '\'' +
                '}';
    }
}