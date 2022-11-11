package by.skopinau.librarydemo.bll.service.impl;

import by.skopinau.librarydemo.bll.service.PublisherService;
import by.skopinau.librarydemo.dal.entity.Publisher;
import by.skopinau.librarydemo.dal.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl extends BaseServiceImpl<Publisher> implements PublisherService {
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        super(publisherRepository);
    }
}
