package by.skopinau.librarydemo.dal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "magazines")
@AttributeOverride(name = "id", column = @Column(name = "magazine_id"))
public class Magazine extends BaseProduct {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "magazines_genres",
            joinColumns = @JoinColumn(name = "magazine_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    public Magazine() {
    }

    public Magazine(int id, String name, Publisher publisher, LocalDate publicationDate, Set<Genre> genres) {
        super(id, name, publisher, publicationDate);
        this.genres = genres;
    }
}
