package by.skopinau.librarydemo.bll.service;

import by.skopinau.librarydemo.dal.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {

    Optional<T> save(T entity);

    List<T> findAll();

    Optional<T> findById(int id);

    Optional<T> update(T entity, int id);

    boolean deleteById(int id);
}
