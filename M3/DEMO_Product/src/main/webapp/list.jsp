<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>List Product</title>
  </head>
  <body>
  <h1>List Product</h1>
  <h2><a href="/create.jsp?action=create">Create new product</a></h2>
  <table>
    <tr>
      <th>id</th>
      <th>name</th>
      <th>price</th>
      <th>amount</th>
      <th>action</th>
    </tr>
    <c:forEach items="${listProduct}" var ="p">
      <tr>
        <td><c:out value="${p.id}"/></td>
        <td><c:out value="${p.name}"/></td>
        <td><c:out value="${p.price}"/></td>
        <td><c:out value="${p.amount}"/></td>
        <td>
          <a href="/?action=update">Update</a>
          <a href="/?action=delete">Delete</a></td>
      </tr>
    </c:forEach>
  </table>

  </body>
</html>
