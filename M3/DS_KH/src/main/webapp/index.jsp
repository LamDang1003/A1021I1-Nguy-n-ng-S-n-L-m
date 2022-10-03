<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2022
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Danh Sách Khách Hàng</title>
  </head>
  <body>
  <h1>Danh Sách Khách Hàng</h1>
  <table class="table">
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Birthday</th>
      <th>Address</th>
      <th>Img</th>
    </tr>

    <c:forEach items = "${customerList}" var="customer">
    <tr>
      <td><c:out value="${customer.id}"/></td>
      <td>${customer.name}</td>
      <td>${customer.birthDay}</td>
      <td>${customer.address}</td>
      <td><img src="${customer.img}" width="100px"></td>
    </tr>
    </c:forEach>
  </table>
  </body>
</html>