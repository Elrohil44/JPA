package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;

    private String name;

    @OneToMany
    @JoinColumn(name = "CATEGORY_ID")
    private List<Product> products;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
        products = new LinkedList<>();
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s", categoryId, name);
    }

    public void addProduct(Product product){
        products.add(product);
    }
}
