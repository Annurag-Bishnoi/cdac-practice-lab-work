<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String userId = (String) session.getAttribute("userid");

    if (userId == null || userId.trim().isEmpty()) {
        response.sendRedirect("login.jsp");
        return;
    }

    String msg = request.getParameter("msg");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management Dashboard</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #2c3e50;
            color: white;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar h2 {
            margin: 0;
        }

        .container {
            width: 900px;
            margin: 50px auto;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            text-align: center;
        }

        .message {
            font-weight: bold;
            margin-bottom: 20px;
        }

        .success {
            color: green;
        }

        .error {
            color: red;
        }

        .card-container {
            display: flex;
            justify-content: center;
            gap: 25px;
            margin-top: 30px;
        }

        .card {
            width: 220px;
            padding: 25px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #fafafa;
        }

        .card h3 {
            color: #2c3e50;
        }

        .btn {
            display: inline-block;
            padding: 12px 20px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 10px;
        }

        .btn-add {
            background-color: #2ecc71;
        }

        .btn-view {
            background-color: #3498db;
        }

        .btn-logout {
            background-color: #e74c3c;
        }

        .btn:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>

<div class="navbar">
    <h2>SMS Portal</h2>
    <div>
        Logged in as: <strong><%= userId %></strong>
    </div>
</div>

<div class="container">

    <h1>Welcome to Student Management System</h1>
    <p>Select an option below to manage student records.</p>

    <%
        if ("student_added".equals(msg)) {
    %>
        <p class="message success">Student added successfully!</p>
    <%
        } else if ("student_updated".equals(msg)) {
    %>
        <p class="message success">Student updated successfully!</p>
    <%
        } else if ("student_deleted".equals(msg)) {
    %>
        <p class="message success">Student deleted successfully!</p>
    <%
        } else if ("error".equals(msg)) {
    %>
        <p class="message error">Something went wrong. Please try again.</p>
    <%
        }
    %>

    <div class="card-container">

        <div class="card">
            <h3>Add Student</h3>
            <p>Create a new student record.</p>
            <a href="addStudent.jsp" class="btn btn-add">Add Student</a>
        </div>

        <div class="card">
            <h3>View Students</h3>
            <p>View, edit, or delete student records.</p>
            <a href="student?action=list" class="btn btn-view">View Students</a>
        </div>

        <div class="card">
            <h3>Logout</h3>
            <p>End your current session.</p>
            <a href="logout" class="btn btn-logout">Logout</a>
        </div>

    </div>

</div>

</body>
</html>