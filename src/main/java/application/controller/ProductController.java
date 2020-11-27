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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @GetMapping(value = "/all")
    public @ResponseBody
    List<Product> getAllProducts() { return service.findAll(); }

    @GetMapping(value = "/name")
    public @ResponseBody
    Product getProductByName(@RequestParam("name") String name) {
        return service.findByName(name);
    }

    @PostMapping(value = "/new")
    public @ResponseBody
    Product addProduct(@RequestBody String name) {
        service.addProduct(name);
        return service.findByName(name);
    }
}
