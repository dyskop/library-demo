package by.skopinau.librarydemo.dal.repository;

import by.skopinau.librarydemo.dal.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Integer> {
}
