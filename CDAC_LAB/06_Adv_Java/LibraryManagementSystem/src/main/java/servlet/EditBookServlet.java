package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

@WebServlet("/editbook")
public class EditBookServlet extends HttpServlet {
//	
	BookDAO bookDao=new BookDAO();
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	int id=	Integer.parseInt(req.getParameter("id"));
		
		try {
			Book b=bookDao.bookGetById(id);
			
			req.setAttribute("book",b);
			req.getRequestDispatcher("Editbook.jsp").forward(req, res);
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
