package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

@WebServlet("/view")
public class ViewBookServlet extends HttpServlet {

	
	BookDAO bookDao=new BookDAO();
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
	ArrayList<Book> booklist=new ArrayList<>();
	
	try {
		
		
		booklist=bookDao.viewBooks();
		
		req.setAttribute("bookList", booklist);
		req.getRequestDispatcher("ViewBook.jsp").forward(req, res);
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
}
