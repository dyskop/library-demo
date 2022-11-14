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
@Table(name = "authors")
@AttributeOverride(name = "id", column = @Column(name = "author_id"))
@JsonIgnoreProperties("books")
public class Author extends BaseEntity {

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(int id, String name) {
        super(id, name);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        return books.equals(author.books);
    }

    @Override
    public int hashCode() {
        return books.hashCode();
    }
}
