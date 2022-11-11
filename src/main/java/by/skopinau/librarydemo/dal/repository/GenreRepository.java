package by.skopinau.librarydemo.dal.repository;

import by.skopinau.librarydemo.dal.entity.BaseProduct;
import by.skopinau.librarydemo.dal.entity.Genre;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends BaseRepository<Genre> {
}
