<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Patient</title>
    <link rel="stylesheet" type="text/css" href="list.jsp">
</head>
<body>
<center>
    <h1>Patient Management</h1>
    <a href="patients?action=patients">List All Patient</a>
    <h2>
        <a href="/patients?action=create">Add New Patient</a>
    </h2>
</center>

<c:if test="${isUpdated}">Updated successful</c:if>

<div align="center">
    <form method="post" action="/patients?action=search">
        <input name="search">
        <button>Search By Name</button>
    </form>
</div>
<div align="center">
    <form method="post" action="/patients?action=findById">
        <input name="findById">
        <button>Find By Id</button>
    </form>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Patients</h2></caption>
        <tr>
            <th>id</th>
            <th>name</th>

            <th>action</th>
        </tr>
        <c:forEach var="patient" items="${listPatient}">
            <tr>
                <td><c:out value="${patient.id}"/></td>
                <td><c:out value="${patient.name}"/></td>

                <td>
                    <a href="/patients?action=update&id=${patient.id}">Update</a>
                    <a href="/patients?action=delete&id=${patient.id}">Delete</a>
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