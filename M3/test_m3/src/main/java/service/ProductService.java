package service;

import model.Product;
import repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService  implements IProductService{
    private ProductRepository productRepository = new ProductRepository();


    @Override
    public List<Product> findAll(String sortField, String sortDir) throws SQLException {
        return productRepository.findAll(sortField, sortDir);
    }

    @Override
    public void create(Product product) throws SQLException {
        productRepository.create(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return productRepository.delete(id);
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return productRepository.update(product);
    }

    @Override
    public List<Product> search(String name) throws SQLException {
        return productRepository.search(name);
    }
}
