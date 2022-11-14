package by.skopinau.librarydemo.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"books", "magazines", "newspapers"})
public class Publisher extends BaseEntity {
    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();

    @OneToMany(mappedBy = "publisher")
    private Set<Magazine> magazines = new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;

        Publisher publisher = (Publisher) o;

        if (!books.equals(publisher.books)) return false;
        if (!magazines.equals(publisher.magazines)) return false;
        return newspapers.equals(publisher.newspapers);
    }

    @Override
    public int hashCode() {
        int result = books.hashCode();
        result = 31 * result + magazines.hashCode();
        result = 31 * result + newspapers.hashCode();
        return result;
    }
}
