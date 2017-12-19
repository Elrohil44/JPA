package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int quantity;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Product> products;

    public Transaction() {
    }

    public Transaction(int quantity) {
        this.quantity = quantity;
        this.products = new HashSet<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        product.getTransactions().add(this);
    }


    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return String.format("Transation number: %d, Quantity: %d", id, quantity);
    }

    public int getId() {
        return id;
    }
}