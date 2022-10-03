package com.shopee.repository;

import com.shopee.model.Customer;
import com.shopee.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
