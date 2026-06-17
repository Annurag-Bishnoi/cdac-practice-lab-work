<%@ page import="model.Student" %>

<%
    String userId = (String) session.getAttribute("userid");

    if (userId == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    Student s = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>

<h2>Edit Student</h2>

<form action="student?action=update" method="post">

    <input type="hidden" name="id" value="<%= s.getId() %>">

    Name:
    <input type="text" name="name" value="<%= s.getName() %>" required>
    <br><br>

    Email:
    <input type="email" name="email" value="<%= s.getEmail() %>" required>
    <br><br>

    Phone:
    <input type="text" name="phone" value="<%= s.getPhone() %>" required>
    <br><br>

    Age:
    <input type="number" name="age" value="<%= s.getAge() %>" required>
    <br><br>

    Course:
    <input type="text" name="course" value="<%= s.getCourse() %>" required>
    <br><br>

    <button type="submit">Update Student</button>

</form>

<br>

<a href="student?action=list">Back</a>

</body>
</html>