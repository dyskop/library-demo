package by.skopinau.librarydemo.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "newspapers")
@AttributeOverride(name = "id", column = @Column(name = "newspaper_id"))
@JsonIgnoreProperties("genres")
public class Newspaper extends BaseProduct {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "newspapers_genres",
            joinColumns = @JoinColumn(name = "newspaper_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    public Newspaper() {
    }

    public Newspaper(int id, String name, Publisher publisher, LocalDate publicationDate, Set<Genre> genres) {
        super(id, name, publisher, publicationDate);
        this.genres = genres;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Newspaper)) return false;

        Newspaper newspaper = (Newspaper) o;

        return genres.equals(newspaper.genres);
    }

    @Override
    public int hashCode() {
        return genres.hashCode();
    }
}
