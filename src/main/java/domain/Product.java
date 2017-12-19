package domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String productName;
    private int unitsOnStock;
    private double price;

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.PERSIST)
    private Set<Transaction> transactions;

    public Product() {
    }

    public Product(String productName, int unitsOnStock, double price) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
        this.price = price;
        this.transactions = new HashSet<>();
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Units: %d, Price: %.2f",
                id, productName, unitsOnStock, price);
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        supplier.getSupplies().add(this);
    }

    public int getId() {
        return id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
        transaction.getProducts().add(this);
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public int getUnitsOnStock() {
        return unitsOnStock;
    }
}
