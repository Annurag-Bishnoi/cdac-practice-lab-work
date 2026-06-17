<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <% 
    
    String msg=request.getParameter("msg");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% if("student_added".equals(msg)) {%>
<p>Patient Added Successfully</p>

<%  
} else if("Failed_ToAddStudent".equals(msg)){ %>
<p>Patient Failed To Add</p>
<% } %>

<a href="addPatient.jsp">Add Patient</a>
<a href="viewPatient.jsp">View Patient</a>
</body>
</html>