package servlets;

import Configuration.Config;
import domain.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insertProduct")
public class InsertProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int onStock = Integer.parseInt(request.getParameter("onStock"));

        Product p = new Product(name, onStock, price);
        Session session = Config.getSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
        response.sendRedirect("getProducts");
    }
}
