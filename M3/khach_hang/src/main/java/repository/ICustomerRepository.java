package repository;

import model.Category;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    public List<Customer> findAll(String sortField, String sortDir) throws SQLException;
    public void create(Customer customer) throws SQLException;
    public Customer findById(int id);
    public boolean delete(int id) throws SQLException;
    public boolean update(Customer customer) throws SQLException;
    List<Customer> search(String address) throws SQLException;
    List<Category> table2() throws SQLException;
}
