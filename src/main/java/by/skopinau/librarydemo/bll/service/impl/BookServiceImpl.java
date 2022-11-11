package by.skopinau.librarydemo.bll.service.impl;

import by.skopinau.librarydemo.bll.service.BookService;
import by.skopinau.librarydemo.dal.entity.Book;
import by.skopinau.librarydemo.dal.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService {
    public BookServiceImpl(BookRepository bookRepository) {
        super(bookRepository);
    }
}
