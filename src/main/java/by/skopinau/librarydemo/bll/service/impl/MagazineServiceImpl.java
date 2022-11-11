package by.skopinau.librarydemo.bll.service.impl;

import by.skopinau.librarydemo.bll.service.MagazineService;
import by.skopinau.librarydemo.dal.entity.Magazine;
import by.skopinau.librarydemo.dal.repository.MagazineRepository;
import org.springframework.stereotype.Service;

@Service
public class MagazineServiceImpl extends BaseServiceImpl<Magazine> implements MagazineService {
    public MagazineServiceImpl(MagazineRepository magazineRepository) {
        super(magazineRepository);
    }
}
