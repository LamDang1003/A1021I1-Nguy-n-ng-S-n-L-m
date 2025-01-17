<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>$Title$</title>
  <style>
    table{
      width: 100%;
    }

    td{
      border: 1px solid;
    }
  </style>
</head>
<body>
<h2>Product List ${tmp}</h2>
<table>
  <thead>
  <th>id</th>
  <th>name</th>
  <th>color</th>
  <th>price</th>
  <th>action</th>
  </thead>
  <tbody>
  <c:forEach items="${products}" var="p">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.price}</td>
      <td>${p.amount}</td>
      <td>
        <a href="#">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
