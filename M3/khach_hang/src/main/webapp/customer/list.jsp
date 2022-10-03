<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" type="text/css" href="list.jsp">
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <a href="customers?action=customers">List All Customer</a>
    <h2>
        <a href="/customers?action=create">Add New Customer</a>
    </h2>
</center>

<c:if test="${isUpdated}">Updated successful</c:if>

<div align="center">
    <form method="post" action="/customers?action=search">
        <input name="search">
        <button>Search By Address</button>
    </form>
</div>
<div align="center">
    <form method="post" action="/customers?action=findById">
        <input name="findById">
        <button>Find By Id</button>
    </form>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Customers</h2></caption>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>old</th>
            <th>nPhone</th>
            <th>email</th>
            <th>address</th>
            <th>category</th>
            <th>nameCategory</th>
            <th>note</th>
            <th>action</th>
        </tr>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.old}"/></td>
                <td><c:out value="${customer.nPhone}"/></td>
                <td><c:out value="${customer.email}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td><c:out value="${customer.category}"/></td>
                <td><c:out value="${customer.categoryName}"/></td>
                <td>qư</td>
                <td>
                    <a href="/customers?action=update&id=${customer.id}">Update</a>
                    <a href="/customers?action=delete&id=${customer.id}">Delete</a>
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