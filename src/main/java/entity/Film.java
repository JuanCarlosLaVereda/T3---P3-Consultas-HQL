package entity;

import jakarta.persistence.*;

@Entity
@NamedQuery(name =  "Film.byEpisode", query = "SELECT f FROM Film f WHERE f.episode = ?1")
@Table(name = "films", schema = "starwars")
public class Film {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "episode", length = 12)
    private String episode;

    @Column(name = "title", length = 30)
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", episode='" + episode + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}