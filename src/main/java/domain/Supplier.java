package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier extends Company{
    @OneToMany(mappedBy = "supplier")
    private Set<Product> supplies;

    public Supplier() {
    }

    public Supplier(String companyName, String street, String city, String zipCode) {
        super(companyName, street, city, zipCode);
        this.supplies = new HashSet<>();
    }

    public void addSupplied(Product product){
        product.setSupplier(this);
        this.supplies.add(product);
    }

    public Set<Product> getSupplies() {
        return supplies;
    }
}
