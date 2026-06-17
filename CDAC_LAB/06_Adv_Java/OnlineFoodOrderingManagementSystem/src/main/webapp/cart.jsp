<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
ArrayList<Order> OrderList =
    (ArrayList<Order>)request.getAttribute("OrderList");
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

<a href="viewOrder">View Order</a>


<div class="container">

<h2> Cart List</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Food Name</th>
        <th>Quantity</th>
        <th>Total Amount</th>
        <th>Action</th>
    </tr>

<%
if(OrderList  != null && !OrderList .isEmpty()){

    for(Order order : OrderList ){
%>

<tr>
    <td><%= order.getOrder_id() %></td>
    <td><%= order.getFood_name() %></td>
    <td><%= order.getQuantity() %></td>
    <td><%= order.getTotal_amount() %>
   <td>
        

        <a href="deleteOrder?id=<%= order.getOrder_id() %>"
           class="btn delete"
           onclick="return confirm('Delete this Order?')">
           Delete
        </a>
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

<form action="success.jsp">
<button>Place Your Order</button>
</form>
</div>
<br>
<br>
<a href="menu.jsp">Back to Menu</a>

<br>
<br>
<a href="logout">Logout</a>
<br>


</body>
</html>