package by.skopinau.librarydemo.api.controller.impl;

import by.skopinau.librarydemo.api.controller.BaseCrudController;
import by.skopinau.librarydemo.bll.service.BaseService;
import by.skopinau.librarydemo.dal.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseCrudControllerImpl<T extends BaseEntity> implements BaseCrudController<T> {

    private final BaseService<T> service;

    @Override
    public ResponseEntity<T> create(@RequestBody T entity) {
        return service.save(entity)
                .map(e -> new ResponseEntity<>(e, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
    public List<T> getAll() {
        return service.findAll();
    }

    @Override
    public ResponseEntity<T> getById(@PathVariable int id) {
        return service.findById(id)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<T> update(@RequestBody T entity, @PathVariable int id) {
        return service.update(entity, id)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<T> deleteById(@PathVariable int id) {
        return service.deleteById(id) ? new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
