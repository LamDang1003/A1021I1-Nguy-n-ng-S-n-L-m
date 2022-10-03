<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/?action=">List All Products</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Update Product
                </h2>
            </caption>
            <c:forEach items="${listProduct}" var ="p">
            <c:if test="${p != null}">
                <input type="hidden" name="id" value="<c:out value='${p.id}' />"/>
            </c:if>
            <tr>
                <th>name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${p.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${p.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>amount:</th>
                <td>
                    <input type="text" name="amount" size="15"
                           value="<c:out value='${p.amount}' />"
                    />
                </td>
            </tr>
            </c:forEach>
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