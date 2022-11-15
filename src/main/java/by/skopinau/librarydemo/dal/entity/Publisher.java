package by.skopinau.librarydemo.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishers")
@AttributeOverride(name = "id", column = @Column(name = "publisher_id"))
public class Publisher extends BaseEntity {

    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    private Set<Magazine> magazines = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    private Set<Newspaper> newspapers = new HashSet<>();

    public Publisher() {
    }

    public Publisher(int id, String name) {
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
