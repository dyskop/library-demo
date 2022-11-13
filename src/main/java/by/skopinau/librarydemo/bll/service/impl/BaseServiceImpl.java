package by.skopinau.librarydemo.bll.service.impl;

import by.skopinau.librarydemo.bll.service.BaseService;
import by.skopinau.librarydemo.dal.entity.BaseEntity;
import by.skopinau.librarydemo.dal.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    protected final BaseRepository<T> repository;

    @Override
    public Optional<T> save(T entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<T> update(T entity, int id) {
        if (findById(id).isEmpty()) {
            return Optional.empty();
        }

        entity.setId(id);

        return save(entity);
    }

    @Override
    public boolean deleteById(int id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }
}
