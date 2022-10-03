package Service;

import Model.Product;
import Repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository = new ProductRepository();

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById() throws SQLException, ClassNotFoundException {
        return productRepository.findById();
    }

    public void create(){

    }


}
