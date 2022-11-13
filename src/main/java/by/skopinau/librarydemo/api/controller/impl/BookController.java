package by.skopinau.librarydemo.api.controller.impl;

import by.skopinau.librarydemo.bll.service.BaseService;
import by.skopinau.librarydemo.dal.entity.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/books")
public class BookController extends BaseCrudControllerImpl<Book> {
    public BookController(BaseService<Book> service) {
        super(service);
    }
}
