package command;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddProduct implements Command {

    private Session session;

    public AddProduct(Session session) {
        this.session = session;
    }

    @Override
    public void execute() {
        System.out.print("Name: ");
        String productName = scanner.nextLine();
        System.out.print("Price: ");
        double price = Float.parseFloat(scanner.nextLine());
        System.out.print("UnitsOnStock: ");
        int onStock = Integer.parseInt(scanner.nextLine());

        Transaction tx = session.beginTransaction();
        session.save(new Product(productName, onStock, price));
        tx.commit();
    }
}
