<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
    String username = (String) session.getAttribute("username");
    String fullName = (String) session.getAttribute("fullName");

    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<%
        String message = request.getParameter("msg");
        if (message != null) {
    %>
        <p style="color:green;">Book Added Successfully</p>
    <%
        }
    %>
    
    <%
        String UpdErr = request.getParameter("Upderr");
        if (UpdErr != null) {
    %>
        <p style="color:red;">Book Update Failed</p>
    <%
        }
    %>

<%
        String Updmsg = request.getParameter("Updmsg");
        if (Updmsg != null) {
    %>
        <p style="color:green;">Book Updated Successfully</p>
    <%
        }
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>

<style>
    *{
        margin:0;
        padding:0;
        box-sizing:border-box;
        font-family: Arial, sans-serif;
    }

    body{
        background: #f4f6f9;
        display:flex;
        justify-content:center;
        align-items:center;
        min-height:100vh;
    }

    .container{
        background:#fff;
        padding:40px;
        width:500px;
        border-radius:12px;
        box-shadow:0 4px 15px rgba(0,0,0,0.15);
        text-align:center;
    }

    h2{
        color:#333;
        margin-bottom:20px;
    }

    h1{
        color:#007bff;
        margin-bottom:30px;
    }

    .menu a{
        display:block;
        text-decoration:none;
        background:#007bff;
        color:white;
        padding:12px;
        margin:12px 0;
        border-radius:6px;
        transition:0.3s;
        font-size:18px;
    }

    .menu a:hover{
        background:#0056b3;
    }

    .logout{
        background:#dc3545 !important;
    }

    .logout:hover{
        background:#b02a37 !important;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Welcome, <%= username %></h2>

    <h1>Library Management</h1>

    <div class="menu">
    
        <a href="addbook.jsp">Add Book</a>
        
        <a href="view">View Books</a>
        
       
        <a href="logout" class="logout">Logout</a>
    </div>
</div>

</body>
</html>