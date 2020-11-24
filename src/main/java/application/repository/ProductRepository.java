package application.repository;

import application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
