package by.skopinau.librarydemo.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"books", "magazines", "newspapers"})
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;

        Genre genre = (Genre) o;

        if (!books.equals(genre.books)) return false;
        if (!magazines.equals(genre.magazines)) return false;
        return newspapers.equals(genre.newspapers);
    }

    @Override
    public int hashCode() {
        int result = books.hashCode();
        result = 31 * result + magazines.hashCode();
        result = 31 * result + newspapers.hashCode();
        return result;
    }
}
