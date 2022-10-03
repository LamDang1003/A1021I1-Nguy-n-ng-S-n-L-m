package com.example.spring01.service;

import com.example.spring01.model.Customer;
import com.example.spring01.repository.ICustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRespository customerRespository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRespository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRespository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRespository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRespository.deleteById(id);
    }
}
