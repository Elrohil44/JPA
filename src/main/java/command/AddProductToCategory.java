package command;

import domain.Category;
import domain.Product;
import domain.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddProductToCategory implements Command {

    private Session session;

    public AddProductToCategory(Session session) {
        this.session = session;
    }

    @Override
    public void execute() {
        System.out.print("Product id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Category id: ");
        int c_id = Integer.parseInt(scanner.nextLine());

        Transaction tx = session.beginTransaction();
        Product product = session.get(Product.class, id);
        Category category = session.get(Category.class, c_id);

        if (product != null && category != null) category.addProduct(product);
        tx.commit();
    }
}
