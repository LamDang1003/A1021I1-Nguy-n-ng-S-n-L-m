<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" type="text/css" href="list.css">
</head>
<body>
<center>
    <h1>Product Management</h1>
    <a  href="products?action=products">List All Product</a>
</center>

<h2 align="left">
    <a STYLE="background-color: blue" href="/products?action=create">Add New Product</a>
</h2>

<c:if test="${isUpdated}">Updated successful</c:if>

<div align="right">
    <form method="post" action="/products?action=search">
        <input name="search">
        <button>Search By Name</button>
    </form>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Products</h2></caption>
        <tr style="background-color: aqua">
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>amount</th>
            <th>color</th>
            <th>description</th>
<%--            <th>category</th>--%>
            <th>nameCategory</th>
            <th>action</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr style="background-color: burlywood">
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.amount}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.description}"/></td>
<%--                <td><c:out value="${product.category}"/></td>--%>
                <td><c:out value="${product.nameCategory}"/></td>
                <td>
                    <a style="background-color: chartreuse" href="/products?action=update&id=${product.id}">Update</a>
                    <a style="background-color: red" href="/products?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>

        </tr>
    </table>
</div>
</body>
</html>