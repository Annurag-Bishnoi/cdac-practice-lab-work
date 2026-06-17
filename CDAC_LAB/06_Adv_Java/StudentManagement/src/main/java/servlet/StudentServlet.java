package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.StudentDAO;
import model.Student;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    StudentDAO studentDao = new StudentDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("userid") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        String action = req.getParameter("action");

        try {
            if ("list".equals(action)) {

                ArrayList<Student> list = studentDao.getAllStudents();
                req.setAttribute("studentList", list);

                RequestDispatcher rd = req.getRequestDispatcher("viewStudents.jsp");
                rd.forward(req, res);

            } else if ("edit".equals(action)) {

                int id = Integer.parseInt(req.getParameter("id"));

                Student student = studentDao.getStudentById(id);
                req.setAttribute("student", student);

                RequestDispatcher rd = req.getRequestDispatcher("editStudent.jsp");
                rd.forward(req, res);

            } else if ("delete".equals(action)) {

                int id = Integer.parseInt(req.getParameter("id"));

                studentDao.deleteStudent(id);

                res.sendRedirect("student?action=list");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("Dashboard.jsp");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("userid") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        String action = req.getParameter("action");

        try {
            if ("insert".equals(action)) {

                String name = req.getParameter("name");
                String email = req.getParameter("email");
                String phone = req.getParameter("phone");
                int age = Integer.parseInt(req.getParameter("age"));
                String course = req.getParameter("course");

                Student s = new Student(name, email, phone, age, course);

                studentDao.insertStudent(s);

                res.sendRedirect("Dashboard.jsp?msg=student_added");

            } else if ("update".equals(action)) {

                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                String email = req.getParameter("email");
                String phone = req.getParameter("phone");
                int age = Integer.parseInt(req.getParameter("age"));
                String course = req.getParameter("course");

                Student s = new Student(id, name, email, phone, age, course);

                studentDao.updateStudent(s);

                res.sendRedirect("student?action=list");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("Dashboard.jsp");
        }
    }
}