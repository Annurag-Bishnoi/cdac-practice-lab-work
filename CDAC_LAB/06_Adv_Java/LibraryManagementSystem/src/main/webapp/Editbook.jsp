<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="model.Book" %>

<%
Book b = (Book) request.getAttribute("book");
%>
    
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

button:hover{
    background:#5563d6;
}
</style>

</head>
<body>

<div class="container">

    <h2>Edit Book</h2>

    <form action="updatebook" method="post">
      
       <input type="hidden" name="id" value="<%= b.getBookId() %>">

        <div class="form-group">
            <label>Book Title</label>
            <input type="text" name="title" value="<%= b.getTitle() %>" required>
        </div>

        <div class="form-group">
            <label>Author</label>
            <input type="text" name="author" value="<%= b.getAuthor() %>" required>
        </div>

        <div class="form-group">
            <label>Category</label>
            <input type="text" name="category" value="<%= b.getCategory() %>"required>
        </div>

        <div class="form-group">
            <label>Publisher </label>
            <input type="text"  name="publisher" value="<%= b.getPublisher() %>"required>
        </div>
         <div class="form-group">
            <label>ISBN </label>
            <input type="text"  name="isbn" value="<%= b.getIsbn() %>"required>
        </div>

        <div class="form-group">
            <label>Quantity</label>
            <input type="number" name="quantity" value="<%= b.getQuantity() %>"required>
        </div>
         <div class="form-group">
            <label>Available Quantity </label>
            <input type="number" name="availableQuantity" value="<%= b.getAvailableQuantity() %>" required>
        </div>

        <button type="submit">Save Book</button>

    </form>

</div>

</body>
</html>
