package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{
    private List<Product> products = new ArrayList<>();

    public ProductServiceImpl(){
        products.add(new Product(1, "Iphone 14", 1800.0, "new phone in 2022", "Apple"));
        products.add(new Product(2, "Samsung A10", 1000.0, "new phone in 2022", "Samsumg"));
        products.add(new Product(3, "Oppo A123", 988.0, "new phone in 2022", "Oppo"));
        products.add(new Product(4, "Google Pixel", 2300.0, "new phone in 2022", "Google"));
        products.add(new Product(5, "LG 1234", 555.0, "new phone in 2022", "LG"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        if(product.getId() > 0){
            int index = products.indexOf(product);
            products.set(index, product);
        }
        else{
            int lastId = 0;
            if(products.size() > 0){
                lastId = products.get(products.size() - 1).getId();
            }
            product.setId(lastId + 1);
            products.add(product);
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(e -> e.getId() == id);
    }

    @Override
    public Optional<Product> getById(int id) {
        return products.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public List<Product> search(String name) {
        return products.stream().filter(e -> e.getName().contains(name)).collect(Collectors.toList());
    }
}
