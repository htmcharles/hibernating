<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f8ff; /* Light Blue Background */
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 350px;  /* Reduced width */
            text-align: center;
            margin-top: 20px;
        }

        h1 {
            color: #333;
            font-size: 24px;
            margin-bottom: 2px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
        }

        label {
            width: 100%;
            text-align: left;
            font-weight: bold;
        }

        input[type="text"], input[type="email"], input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 2px;  /* Reduced bottom margin */
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px;
            background-color: #007BFF; /* Blue Background */
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error {
            color: red;
            margin-bottom: 15px;
        }

        h2 {
            color: #333;
            font-size: 22px;
            margin-top: 40px;
            text-align: center;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
            font-size: 16px;
            flex-grow: 1; /* Make the table grow to fill remaining space */
            height: 0;
            overflow-y: auto;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        td {
            text-align: center;
        }

    </style>
</head>
<body>
<div class="container">
    <h1>Student Registration</h1>
    <form action="StudentController" method="POST">
        <label>First Name</label><input type="text" name="fname" required><br>
        <label>Last Name</label><input type="text" name="lname" required><br>
        <label>Email</label><input type="email" name="email" required><br>
        <label>Date of Birth</label><input type="date" name="dob" required><br>
        <input type="submit" value="Register">
    </form>

    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
</div>

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
