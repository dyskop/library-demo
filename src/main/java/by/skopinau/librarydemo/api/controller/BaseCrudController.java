package by.skopinau.librarydemo.api.controller;

import by.skopinau.librarydemo.dal.entity.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BaseCrudController<T extends BaseEntity> {

    @PostMapping
    ResponseEntity<T> create(@RequestBody T entity);

    @GetMapping
    List<T> getAll();

    @GetMapping("/{id}")
    ResponseEntity<T> getById(@PathVariable int id);

    @PutMapping("/{id}")
    ResponseEntity<T> update(@RequestBody T entity, @PathVariable int id);

    @DeleteMapping("/{id}")
    ResponseEntity<T> deleteById(@PathVariable int id);
}
