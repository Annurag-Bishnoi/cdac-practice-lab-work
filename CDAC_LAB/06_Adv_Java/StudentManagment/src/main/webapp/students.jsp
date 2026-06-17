
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>

<%
    String username = (String) session.getAttribute("username");

    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Student> students = (List<Student>) request.getAttribute("students");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>

    <h2>Student Data</h2>

    <table border="1" >

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Course</th>
            <th>Age</th>
        </tr>

        <%
            if (students != null && !students.isEmpty()) {
                for (Student s : students) {
        %>

        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getEmail() %></td>
            <td><%= s.getPhone() %></td>
            <td><%= s.getCourse() %></td>
            <td><%= s.getAge() %></td>
        </tr>

        <%
                }
            } else {
        %>

        <tr>
            <td colspan="6">No students found</td>
        </tr>

        <%
            }
        %>

    </table>

    <br>

    <a href="student-register.jsp">Add New Student</a>
    <br><br>

    <a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>