<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/19/2022
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="/convert" method="post">
      <div>USD: <input name="usd" value="${usd}"></div>
      <div>Rate: 1 USD~ 23000 VND</div>
      <div>Result:~ <label style="color: blue">${res}</label></div>
      <button>Convert</button>
    </form>
  </body>
</html>
