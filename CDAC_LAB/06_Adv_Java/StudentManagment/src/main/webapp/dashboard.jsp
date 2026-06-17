<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
    String username = (String) session.getAttribute("username");

    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

    <h2>Welcome, <%= username %></h2>

    <hr>

    <a href="student-register.jsp">Register Student</a>
    <br><br>

    <a href="listStudents">View Students</a>
    <br><br>

    <a href="logout">Logout</a>

</body>
</html>