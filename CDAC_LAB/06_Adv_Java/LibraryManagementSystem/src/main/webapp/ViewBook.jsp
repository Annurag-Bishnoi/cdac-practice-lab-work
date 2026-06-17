<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Book" %>
<%@ page import="java.util.ArrayList" %>

<%
        String error = request.getParameter("error");
        if (error != null) {
    %>
        <p style="color:red;">Invalid username or password</p>
    <%
        }
    %>
    
<%
ArrayList<Book> bookList =
    (ArrayList<Book>)request.getAttribute("bookList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Books</title>

<style>
body{
    font-family: Arial, sans-serif;
    background:#f4f6f9;
    padding:20px;
}

.container{
    width:90%;
    margin:auto;
    background:white;
    padding:20px;
    border-radius:10px;
    box-shadow:0px 2px 10px rgba(0,0,0,0.2);
}

h2{
    text-align:center;
    margin-bottom:20px;
    color:#333;
}

table{
    width:100%;
    border-collapse:collapse;
}

th{
    background:#007bff;
    color:white;
}

th,td{
    border:1px solid #ddd;
    padding:12px;
    text-align:center;
}

tr:nth-child(even){
    background:#f8f9fa;
}

.btn{
    text-decoration:none;
    color:white;
    padding:8px 12px;
    border-radius:5px;
}

.edit{
    background:#28a745;
}

.delete{
    background:#dc3545;
}

.edit:hover{
    background:#218838;
}

.delete:hover{
    background:#c82333;
}
</style>

</head>
<body>

<div class="container">

<h2>Library Books</h2>

<table>
    <tr>
    <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Publisher</th>
            <th>ISBN</th>
            <th>Total Quantity</th>
            <th>Available Quantity</th>
        <th>Action</th>
    </tr>

<%
if(bookList != null && !bookList.isEmpty()){

    for(Book book : bookList){
%>

<tr>
     <td><%= book.getBookId() %></td>
            <td><%= book.getTitle() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getCategory() %></td>
            <td><%= book.getPublisher() %></td>
            <td><%= book.getIsbn() %></td>
            <td><%= book.getQuantity() %></td>
            <td><%= book.getAvailableQuantity() %></td>

    <td>
        <a href="editbook?id=<%= book.getBookId() %>"
           class="btn edit">Edit</a>

        <a href="deletebook?id=<%= book.getBookId() %>"
           class="btn delete"
           onclick="return confirm('Delete this book?')">
           Delete
        </a>
    </td>
</tr>

<%
    }
}else{
%>

<tr>
    <td colspan="7">No Books Available</td>
</tr>

<%
}
%>

</table>
<br>
<br>
<a href="addbook.jsp">Add New Book</a>
<br>
<br>
<a href="Dashboard.jsp"> Back to Dashboard</a>

</div>

</body>
</html>