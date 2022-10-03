<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="customers?action=customers">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Update Customer
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${customer.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>old:</th>
                <td>
                    <input type="text" name="old" size="45"
                           value="<c:out value='${customer.old}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>NPhone:</th>
                <td>
                    <input type="text" name="nPhone" size="45"
                           value="<c:out value='${customer.nPhone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${customer.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${customer.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <input type="text" name="category" size="45"
                           value="<c:out value='${customer.category}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>