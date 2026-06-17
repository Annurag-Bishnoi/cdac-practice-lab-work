<%
    String userId = (String) session.getAttribute("userid");

    if (userId == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>

<h2>Add Student</h2>

<form action="student?action=insert" method="post">

    Name:
    <input type="text" name="name" required>
    <br><br>

    Email:
    <input type="email" name="email" required>
    <br><br>

    Phone:
    <input type="text" name="phone" required>
    <br><br>

    Age:
    <input type="number" name="age" required>
    <br><br>

    Course:
    <input type="text" name="course" required>
    <br><br>

    <button type="submit">Add Student</button>

</form>

<br>

<a href="Dashboard.jsp">Back</a>

</body>
</html>