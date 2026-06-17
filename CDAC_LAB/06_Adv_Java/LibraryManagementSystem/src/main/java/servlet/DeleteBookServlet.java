package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;

@WebServlet("/deletebook")
public class DeleteBookServlet extends HttpServlet {
	
	BookDAO bookDao=new BookDAO();
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		boolean isDeleted;
		try {
			isDeleted = bookDao.deleteBook(id);
			   if(isDeleted) {
	               res.sendRedirect("view");
	           } else {
	               res.sendRedirect("view");
	           }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}


}
