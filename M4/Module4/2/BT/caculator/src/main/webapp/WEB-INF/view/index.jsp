<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/caculator" method="post">
    <div>
        <input name="a">
        <input name="b">
    </div>
    <div>
        <button type="submit" name="c" value="+">Addition(+)</button>
        <button type="submit" name="c" value="-">Subtraction(-)</button>
        <button type="submit" name="c" value="*">Multiplication(*)</button>
        <button type="submit" name="c" value="/">Division(/)</button>
    </div>
</form>
<c:if test="${res!=null}">
    <div>
        Result: ${res}
    </div>
</c:if>
</body>
</html>