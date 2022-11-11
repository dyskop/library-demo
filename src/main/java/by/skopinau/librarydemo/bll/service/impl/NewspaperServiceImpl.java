package by.skopinau.librarydemo.bll.service.impl;

import by.skopinau.librarydemo.bll.service.NewspaperService;
import by.skopinau.librarydemo.dal.entity.Newspaper;
import by.skopinau.librarydemo.dal.repository.NewspaperRepository;
import org.springframework.stereotype.Service;

@Service
public class NewspaperServiceImpl extends BaseServiceImpl<Newspaper> implements NewspaperService {
    public NewspaperServiceImpl(NewspaperRepository newspaperRepository) {
        super(newspaperRepository);
    }
}
