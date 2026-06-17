package servlet;



import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;
import model.Student;

@WebServlet("/registerStudent")
public class StudentRegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private StudentDAO studentDAO = new StudentDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");
        int age = Integer.parseInt(request.getParameter("age"));

        Student student = new Student(name, email, phone, course, age);

        boolean status = studentDAO.saveStudent(student);

        if (status) {
            response.sendRedirect("listStudents");
        } else {
            request.setAttribute("error", "Student registration failed");
            request.getRequestDispatcher("student-register.jsp").forward(request, response);
        }
    }
}
