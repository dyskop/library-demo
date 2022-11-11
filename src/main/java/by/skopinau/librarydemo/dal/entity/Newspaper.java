package by.skopinau.librarydemo.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "newspapers")
@AttributeOverride(name = "id", column = @Column(name = "newspaper_id"))
public class Newspaper extends BaseProduct {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "newspapers_genres",
            joinColumns = @JoinColumn(name = "newspaper_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();
}
