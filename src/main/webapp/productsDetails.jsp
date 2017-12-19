<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Manage Products</title>
</head>
<body>
<%@ page import="java.util.List,domain.*" %>
<h3> Available Products Details </h3>
<%
    List<Product> products = (List<Product>)request.getAttribute("products");
%>
<h4> Total Number of Products is <%= products.size() %> </h4>
<table border="1">
    <tr>
        <td> ID</td> <td>NAME </td> <td> ON STOCK </td> <td> PRICE </td>
    </tr>
    <%
        for (Product product : products) {
    %>
    <tr>
        <td><%= product.getId() %>
        </td>
        <td><%= product.getProductName() %>
        </td>
        <td><%= product.getUnitsOnStock() %>
        </td>
        <td><%= product.getPrice() %>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>