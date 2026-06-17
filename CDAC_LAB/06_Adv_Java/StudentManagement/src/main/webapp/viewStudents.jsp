<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Student" %>

<%
    String userId = (String) session.getAttribute("userid");

    if (userId == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("studentList");
%>

<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
</head>
<body>

<h2>Student List</h2>

<table border="3" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Age</th>
        <th>Course</th>
        <th>Action</th>
    </tr>

    <%
        if (studentList != null) {
            for (Student s : studentList) {
    %>

    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getPhone() %></td>
        <td><%= s.getAge() %></td>
        <td><%= s.getCourse() %></td>
        <td>
            <a href="student?action=edit&id=<%= s.getId() %>">Edit</a>
            |
            <a href="student?action=delete&id=<%= s.getId() %>">Delete</a>
        </td>
    </tr>

    <%
            }
        }
    %>

</table>

<br>

<a href="Dashboard.jsp">Back to Dashboard</a>

</body>
</html>