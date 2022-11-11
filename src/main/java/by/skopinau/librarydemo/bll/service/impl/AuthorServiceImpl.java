package by.skopinau.librarydemo.bll.service.impl;

import by.skopinau.librarydemo.bll.service.AuthorService;
import by.skopinau.librarydemo.dal.entity.Author;
import by.skopinau.librarydemo.dal.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author> implements AuthorService {
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        super(authorRepository);
    }
}
