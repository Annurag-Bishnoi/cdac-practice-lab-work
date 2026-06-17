<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String username = (String) session.getAttribute("username");
    String fullName = (String) session.getAttribute("fullName");

    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Details</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

body{
    background:linear-gradient(135deg,#667eea,#764ba2);
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.container{
    width:450px;
    background:white;
    padding:30px;
    border-radius:15px;
    box-shadow:0px 5px 20px rgba(0,0,0,0.3);
}

h2{
    text-align:center;
    margin-bottom:20px;
    color:#333;
}

.form-group{
    margin-bottom:15px;
}

label{
    display:block;
    margin-bottom:5px;
    font-weight:bold;
}

input{
    width:100%;
    padding:10px;
    border:1px solid #ccc;
    border-radius:8px;
}

button{
    width:100%;
    padding:12px;
    border:none;
    border-radius:8px;
    background:#667eea;
    color:white;
    font-size:16px;
    cursor:pointer;
}
a{
    width:100%;
    padding:12px;
    border:none;
    border-radius:8px;
    background:#667eea;
    color:white;
    font-size:16px;
    cursor:pointer;
}

button:hover{
    background:#5563d6;
}
</style>

</head>
<body>

<div class="container">

    <h2>Add Book</h2>

    <form action="addbook" method="post">

        <label>Book Title:</label>
        <input type="text" name="title" required>
        <br><br>

        <label>Author:</label>
        <input type="text" name="author" required>
        <br><br>

        <label>Category:</label>
        <input type="text" name="category">
        <br><br>

        <label>Publisher:</label>
        <input type="text" name="publisher">
        <br><br>

        <label>ISBN:</label>
        <input type="text" name="isbn">
        <br><br>

        <label>Quantity:</label>
        <input type="number" name="quantity" min="1" required>
        <br><br>

        

        <button type="submit">Save Book</button>
        <br>
        <br>
        <a href="Dashboard.jsp">Back to Dashboard</a>
        <br>
        <br>
        <a href="ViewBook.jsp">View Books</a>

    </form>

</div>

</body>
</html>