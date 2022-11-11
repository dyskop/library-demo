package by.skopinau.librarydemo.bll.service.impl;

import by.skopinau.librarydemo.bll.service.GenreService;
import by.skopinau.librarydemo.dal.entity.Genre;
import by.skopinau.librarydemo.dal.repository.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl extends BaseServiceImpl<Genre> implements GenreService {
    public GenreServiceImpl(GenreRepository genreRepository) {
        super(genreRepository);
    }
}
