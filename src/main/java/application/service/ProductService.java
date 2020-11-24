package application.service;

import application.model.Product;

public interface ProductService {
    public void addProduct(Product product);
    public Product findByName(String name);
}
