<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.CartItem" %>
    <%@ page import="model.Order" %>
<%@ page import="java.util.ArrayList" %>
 <%    
    String userid = (String)session.getAttribute("userid");
if(userid == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<%
ArrayList<CartItem> CartList =
    (ArrayList<CartItem>)request.getAttribute("CartList");
%>


<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h3>Welcome <%= userid %></h3>

<a href="viewCart">View CartItem</a>


<div class="container">

<h2>Food Cart</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Food Name</th>
        <th>Price</th>
      
        <th>Action</th>
    </tr>

<%
if(CartList  != null && !CartList .isEmpty()){

    for(CartItem cartItem : CartList ){
%>

<tr>
    <td><%= cartItem.getFood_id() %></td>
    <td><%= cartItem.getFood_name() %></td>
    <td><%= cartItem.getPrice() %></td>
   <td>
      <form action="addOrder?id=<%= cartItem.getFood_id()%>" method="post">
      <input type="hidden" value="<%= userid %>" name="username">
      <input type="hidden" value="<%= cartItem.getFood_name()%>" name="foodname">
      <input type="hidden" value="<%= cartItem.getPrice() %>" name="price">
      <label>Quantity:</label>
      <input type="number" name="quantity">
      <button type="submit">Add Item to Cart</button>
      </form>

      
    </td>
</tr>

<%
    }
}else{
%>

<tr>
    <td colspan="7">No Items Available</td>
</tr>

<%
}
%>

</table>

<br>


</div>

<br>
<br>
<a href="cart.jsp">Go To Cart</a>

<br>
<br>

<br>

<br>
<a href="logout">Logout</a>
<br>
<a href=""></a>

</body>
</html>