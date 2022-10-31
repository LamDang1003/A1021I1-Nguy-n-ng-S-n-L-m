package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();
    void save(T t);
    void delete(Long id);
    Optional<T> getById(Long id);
    List<T> search(String name);
}
