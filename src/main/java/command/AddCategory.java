package command;

import domain.Category;
import domain.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddCategory implements Command {

    private Session session;

    public AddCategory(Session session) {
        this.session = session;
    }

    @Override
    public void execute() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        Transaction tx = session.beginTransaction();
        session.save(new Category(name));
        tx.commit();
    }
}
