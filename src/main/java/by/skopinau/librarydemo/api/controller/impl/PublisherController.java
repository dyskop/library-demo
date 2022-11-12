package by.skopinau.librarydemo.api.controller.impl;

import by.skopinau.librarydemo.bll.service.impl.BaseServiceImpl;
import by.skopinau.librarydemo.dal.entity.Publisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/publishers")
public class PublisherController extends BaseCrudControllerImpl<Publisher> {
    public PublisherController(BaseServiceImpl<Publisher> service) {
        super(service);
    }
}
