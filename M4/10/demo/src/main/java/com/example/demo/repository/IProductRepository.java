package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
