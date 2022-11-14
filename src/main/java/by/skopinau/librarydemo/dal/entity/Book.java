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
@Table(name = "books")
@AttributeOverride(name = "id", column = @Column(name = "book_id"))
// todo: think about ignoring this properties during serialization
@JsonIgnoreProperties({"genres", "authors"})
public class Book extends BaseProduct {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(int id, String name, Publisher publisher, LocalDate publicationDate, Set<Genre> genres, Set<Author> authors) {
        super(id, name, publisher, publicationDate);
        this.genres = genres;
        this.authors = authors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!genres.equals(book.genres)) return false;
        return authors.equals(book.authors);
    }

    @Override
    public int hashCode() {
        int result = genres.hashCode();
        result = 31 * result + authors.hashCode();
        return result;
    }
}
