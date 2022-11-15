package by.skopinau.librarydemo.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
@AttributeOverride(name = "id", column = @Column(name = "genre_id"))
public class Genre extends BaseEntity {

    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    private Set<Book> books = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    private Set<Magazine> magazines = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    private Set<Newspaper> newspapers = new HashSet<>();

    public Genre() {
    }

    public Genre(int id, String name) {
        super(id, name);
    }
    
    public Set<Book> getBooks() {
        return books;
    }

    public Set<Magazine> getMagazines() {
        return magazines;
    }

    public Set<Newspaper> getNewspapers() {
        return newspapers;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setMagazines(Set<Magazine> magazines) {
        this.magazines = magazines;
    }

    public void setNewspapers(Set<Newspaper> newspapers) {
        this.newspapers = newspapers;
    }
}
