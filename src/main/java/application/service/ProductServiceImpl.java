package application.service;

import application.model.Product;
import application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void addProduct(Product product) { repository.save(product); }

    @Override
    public Product findByName(String name) { return repository.findByName(name); }
}
