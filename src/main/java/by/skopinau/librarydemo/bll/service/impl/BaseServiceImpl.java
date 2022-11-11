package by.skopinau.librarydemo.bll.service.impl;

import by.skopinau.librarydemo.bll.service.BaseService;
import by.skopinau.librarydemo.dal.entity.BaseEntity;
import by.skopinau.librarydemo.dal.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    private final BaseRepository<T> baseRepository;

    @Override
    public T save(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public void deleteById(int id) {
        baseRepository.deleteById(id);
    }

    @Override
    public Optional<T> findById(int id) {
        return baseRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }
}
