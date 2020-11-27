package application.service;

import application.model.Product;
import application.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void addProduct(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readTree(name);
            Product product = new Product(objectMapper.convertValue(node.get("productName"), String.class));
            repository.save(product);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findByName(String name) { return repository.findByName(name); }

    @Override
    public List<Product> findAll() { return repository.findAll(); }
}
