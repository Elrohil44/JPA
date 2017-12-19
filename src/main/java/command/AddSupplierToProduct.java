package command;

import domain.Product;
import domain.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddSupplierToProduct implements Command {

    private Session session;

    public AddSupplierToProduct(Session session) {
        this.session = session;
    }

    @Override
    public void execute() {
        System.out.print("Product id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Supplier id: ");
        int c_id = Integer.parseInt(scanner.nextLine());

        Transaction tx = session.beginTransaction();
        Product product = session.get(Product.class, id);
        Supplier supplier = session.get(Supplier.class, c_id);

        if (product != null && supplier != null) product.setSupplier(supplier);
        tx.commit();
    }
}
