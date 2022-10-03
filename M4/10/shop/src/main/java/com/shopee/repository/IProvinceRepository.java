package com.shopee.repository;

import com.shopee.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
