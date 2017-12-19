package command;

import domain.Product;
import domain.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddSupplier implements Command {
    private Session session;

    public AddSupplier(Session session) {
        this.session = session;
    }

    @Override
    public void execute() {
        System.out.print("CompanyName: ");
        String productName = scanner.nextLine();
        System.out.print("Street: ");
        String street = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("ZipCode: ");
        String zipCode = scanner.nextLine();

        Transaction tx = session.beginTransaction();
        session.save(new Supplier(productName, street, city, zipCode));
        tx.commit();
    }
}
