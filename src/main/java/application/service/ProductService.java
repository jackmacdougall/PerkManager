package application.service;

import application.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(String name);
    Product findByName(String name);
    List<Product> findAll();
}
