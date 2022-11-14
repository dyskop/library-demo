package by.skopinau.librarydemo.dal.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class BaseProduct extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;

    public BaseProduct() {
    }

    public BaseProduct(int id, String name, Publisher publisher, LocalDate publicationDate) {
        super(id, name);
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }
}