package application.controller;

import application.model.Product;
import application.service.ProductService;
import application.service.ProductServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @PostMapping(value = "/new")
    public @ResponseBody
    Product addProduct(@RequestBody String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readTree(name);
            service.addProduct(new Product(objectMapper.convertValue(node.get("productName"), String.class)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return service.findByName(name);
    }
}
