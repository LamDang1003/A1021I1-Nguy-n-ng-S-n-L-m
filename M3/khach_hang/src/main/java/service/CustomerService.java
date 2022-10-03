package service;

import model.Category;
import model.Customer;
import repository.CustomerRepository;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService{
    private CustomerRepository customerRepository = new CustomerRepository();


    @Override
    public List<Customer> findAll(String sortField, String sortDir) {
        return customerRepository.findAll(sortField, sortDir);
    }

    @Override
    public void create(Customer customer) throws SQLException {
        customerRepository.create(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return customerRepository.delete(id);
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return customerRepository.update(customer);
    }

    @Override
    public List<Customer> search(String address) {
        return customerRepository.search(address);
    }

    @Override
    public List<Category> table2() {
        return customerRepository.table2();
    }
}
