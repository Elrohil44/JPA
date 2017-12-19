import Configuration.Config;
import domain.Customer;
import domain.Supplier;
import org.hibernate.*;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = Config.getSession();
        Transaction tx = session.beginTransaction();
        Supplier s = session.get(Supplier.class, 6);
        System.out.println(s);
        Supplier supplier = new Supplier("B&D", "Pionowa", "Rozentown", "12-123");
        Customer c = new Customer("U Krysi", "Pozioma", "Blacktown", "32-123", 23.5);

        session.save(supplier);
        session.save(c);
        tx.commit();
        session.close();
    }
}


//        domain.Transaction t = new domain.Transaction(3);
//        domain.Transaction t1 = new domain.Transaction(1);
//        Product p = new Product("Scisors", 12, 2.5);
//        Product p1 = new Product("Sofa", 1, 1400);
//        t.addProduct(p);
//        t.addProduct(p1);
//        t1.addProduct(p);
//        t1.addProduct(p1);

//        Supplier supplier = new Supplier("XKOM", "Chopina", "Kraków");
//        session.save(supplier);
//        Product product = new Product("Notebook", 20, 3.500);
//        Product product1 = new Product("Macbook", 20, 3.500);
//        Product product2 = new Product("Smartphone", 20, 3.500);
//        session.save(product);
//        session.save(product1);
//        session.save(product2);
//
//        supplier.addSupplied(product);
//        supplier.addSupplied(product1);
//        supplier.addSupplied(product2);
//
//        Supplier s = session.get(Supplier.class, supplier.getId());
//        s.getSupplies().forEach(System.out::println);
//
//        Product p = session.get(Product.class, product.getId());
//        System.out.println(p.getSupplier());

//    domain.Transaction transaction = new domain.Transaction(3);
//    domain.Transaction transaction1 = new domain.Transaction(1);
//        session.save(transaction);
//                session.save(transaction1);
//                List<Product> productList = session
//        .createQuery("from Products", Product.class)
//        .getResultStream().limit(6).collect(Collectors.toList());
//
//        productList.forEach(product -> {
//        transaction.addProduct(product);
//        transaction1.addProduct(product);
//        });
//
//        Product p = session.get(Product.class, productList.get(0).getId());
//
//        p.getTransactions().forEach(System.out::println);
//
//        System.out.println();
//
//        domain.Transaction t = session.get(domain.Transaction.class, transaction.getId());
//
//        t.getProducts().forEach(System.out::println);


//        AddProduct addProduct = new AddProduct(session);
//        AddSupplier addSupplier = new AddSupplier(session);
//        AddSupplierToProduct addSupplierToProduct = new AddSupplierToProduct(session);
//        AddProductSupplied addProductSupplied = new AddProductSupplied(session);
//        AddCategory addCategory = new AddCategory(session);
//        AddProductToCategory addProductToCategory = new AddProductToCategory(session);
//        addProduct.execute();
//        addSupplier.execute();
//        addSupplierToProduct.execute();
//        addCategory.execute();
//        addProductToCategory.execute();