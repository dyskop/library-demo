package by.skopinau.librarydemo.dal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "publishers")
@AttributeOverride(name = "id", column = @Column(name = "publisher_id"))
public class Publisher extends BaseEntity {
}