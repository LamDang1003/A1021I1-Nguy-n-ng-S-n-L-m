package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    public List<Product> findAll(String sortField, String sortDir) throws SQLException;
    public void create(Product product) throws SQLException;
    public Product findById(int id);
    public boolean delete(int id) throws SQLException;
    public boolean update(Product product) throws SQLException;
    List<Product> search(String name) throws SQLException;
}
