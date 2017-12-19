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
<h3> Insert Product </h3>
<h4> Enter Product Details  </h4>
<form action="insertProduct" method="POST">
    <table >
        <tr> <td>NAME </td>
            <td> <input type="text" name="name" /> </td>
        </tr>
        <tr> <td>ON STOCK </td>
            <td> <input type="text" name="onStock" /> </td>
        </tr>
        <tr> <td>PRICE </td>
            <td> <input type="text" name="price" /> </td>
        </tr>
        <tr> <td><input type="Submit" value="Save"/> </td>
        </tr>
    </table>
</form>
</body>
</html>