package com.codegym.cms.repository;

import java.util.List;

public interface IGeneralRepository<B> {
    List<B> findAll();
    B findById(long id);
//    void view (long id);
    void save(B b);
    void remove(long id);
}
