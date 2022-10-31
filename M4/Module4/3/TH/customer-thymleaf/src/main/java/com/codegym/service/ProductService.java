package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    void delete(int id);
    Optional<Product> getById(int id);
    List<Product> search(String name);
}
