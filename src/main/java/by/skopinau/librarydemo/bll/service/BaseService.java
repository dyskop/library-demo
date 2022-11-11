package by.skopinau.librarydemo.bll.service;

import by.skopinau.librarydemo.dal.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {

    List<T> findAll();

    Optional<T> findById(int id);

    void deleteById(int id);

    T save(T entity);
}
