package com.codegym.cms.service;

import java.util.List;

public interface IGeneralService<I> {
    List<I> findAll();

    I findById(Long id);

    void save(I i);

    void remove(Long id);
}
