package by.skopinau.librarydemo.bll.service.impl;

import by.skopinau.librarydemo.bll.service.BaseService;
import by.skopinau.librarydemo.dal.entity.BaseEntity;
import by.skopinau.librarydemo.dal.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@CacheConfig(cacheNames="products")
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    protected final BaseRepository<T> repository;

    @Override
    @CacheEvict(allEntries = true)
    public Optional<T> save(T entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    @Cacheable
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(int id) {
        return repository.findById(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public Optional<T> update(T entity, int id) {
        if (repository.existsById(id)) {
            entity.setId(id);
            return save(entity);
        }

        return Optional.empty();
    }

    @Override
    @CacheEvict(allEntries = true)
    public boolean deleteById(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}
