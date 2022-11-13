package by.skopinau.librarydemo.api.controller.impl;

import by.skopinau.librarydemo.bll.service.BaseService;
import by.skopinau.librarydemo.dal.entity.Genre;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/genres")
public class GenreController extends BaseCrudControllerImpl<Genre> {
    public GenreController(BaseService<Genre> service) {
        super(service);
    }
}
