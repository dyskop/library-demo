package by.skopinau.librarydemo.dal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "genres")
@AttributeOverride(name = "id", column = @Column(name = "genre_id"))
public class Genre extends BaseEntity {
    @ManyToMany(mappedBy = "genres")
    private Set<Book> books = new HashSet<>();

    @ManyToMany(mappedBy = "genres")
    private Set<Magazine> magazines = new HashSet<>();

    @ManyToMany(mappedBy = "genres")
    private Set<Newspaper> newspapers = new HashSet<>();

    public Genre() {
    }

    public Genre(int id, String name) {
        super(id, name);
    }
}
