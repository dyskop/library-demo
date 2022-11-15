package by.skopinau.librarydemo.dal.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class BaseProduct extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    public BaseProduct() {
    }

    public BaseProduct(int id, String name, Publisher publisher, LocalDate publicationDate) {
        super(id, name);
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseProduct)) return false;
        if (!super.equals(o)) return false;

        BaseProduct that = (BaseProduct) o;

        if (!publisher.equals(that.publisher)) return false;
        return publicationDate.equals(that.publicationDate);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + publicationDate.hashCode();
        return result;
    }
}
