package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDao = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            boolean isValid = userDao.isValid(username, password);

            if (isValid) {
                HttpSession session = req.getSession();
                session.setAttribute("userid", username);

                res.sendRedirect(req.getContextPath() + "/Dashboard.jsp");
            } else {
                res.sendRedirect(req.getContextPath() + "/login.jsp?error=invalid");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            res.sendRedirect(req.getContextPath() + "/login.jsp?error=server");
        }
    }
}