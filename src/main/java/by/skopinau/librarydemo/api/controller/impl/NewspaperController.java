package by.skopinau.librarydemo.api.controller.impl;

import by.skopinau.librarydemo.bll.service.BaseService;
import by.skopinau.librarydemo.dal.entity.Newspaper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/newspapers")
public class NewspaperController extends BaseCrudControllerImpl<Newspaper> {
    public NewspaperController(BaseService<Newspaper> service) {
        super(service);
    }
}
