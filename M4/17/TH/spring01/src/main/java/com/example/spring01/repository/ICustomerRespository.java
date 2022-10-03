package com.example.spring01.repository;

import com.example.spring01.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRespository extends JpaRepository<Customer, Long> {


}
