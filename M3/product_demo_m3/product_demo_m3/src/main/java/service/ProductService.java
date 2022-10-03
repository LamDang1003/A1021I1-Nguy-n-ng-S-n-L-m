package service;

import model.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository = new ProductRepository();

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
