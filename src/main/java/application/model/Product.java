package application.model;

import javax.persistence.*;

@Entity
@Table(name = "products", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Product(String name){
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
