<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
</head>
<body>
<h1>Student Registration</h1>
<form action="StudentController" method="POST">
    <label>First Name</label><input type="text" name="fname"><br>
    <label>Last Name</label><input type="text" name="lname"><br>
    <label>Email</label><input type="text" name="email"><br>
    <input type="submit" value="Register">
</form>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<h2>List of Students</h2>
<table>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Date of Birth</th>
        <th>Age</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td><c:out value="${student.firstName}"/></td>
            <td><c:out value="${student.lastName}"/></td>
            <td><c:out value="${student.email}"/></td>
            <td><c:out value="${student.dob}"/></td>
            <td><c:out value="${student.age}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
