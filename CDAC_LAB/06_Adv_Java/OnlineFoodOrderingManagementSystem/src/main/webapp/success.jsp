<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%    
    String userid = (String)session.getAttribute("userid");
if(userid == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Order Placed  Successfully</h3>

<br>
<br>
<a href="menu.jsp">Back to Menu</a>

<br>
<br>
<a href="logout">Logout</a>
<br>
</body>
</html>