package by.skopinau.librarydemo.api.controller.impl;

import by.skopinau.librarydemo.bll.service.BaseService;
import by.skopinau.librarydemo.dal.entity.Magazine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/magazines")
public class MagazineController extends BaseCrudControllerImpl<Magazine> {
    public MagazineController(BaseService<Magazine> service) {
        super(service);
    }
}
