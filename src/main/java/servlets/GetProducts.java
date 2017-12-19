package servlets;

import Configuration.Config;
import domain.Product;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/getProducts")
public class GetProducts extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        Session session = Config.getSession();
        List<Product> products = session
                .createQuery("from Products", Product.class)
                .getResultList();
        session.close();
        request.setAttribute("products", products);
        request.getRequestDispatcher("productsDetails.jsp").forward(request, response);
    }
}
