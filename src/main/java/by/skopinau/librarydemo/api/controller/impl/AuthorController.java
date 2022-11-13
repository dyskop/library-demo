package by.skopinau.librarydemo.api.controller.impl;

import by.skopinau.librarydemo.bll.service.impl.BaseServiceImpl;
import by.skopinau.librarydemo.dal.entity.Author;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/authors")
public class AuthorController extends BaseCrudControllerImpl<Author> {
    public AuthorController(BaseServiceImpl<Author> service) {
        super(service);
    }
}
