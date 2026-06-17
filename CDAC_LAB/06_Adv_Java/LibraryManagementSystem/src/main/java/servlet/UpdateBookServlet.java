package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

@WebServlet("/updatebook")
public class UpdateBookServlet extends HttpServlet {
	
	BookDAO bookdao=new BookDAO();
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String title=req.getParameter("title");
		 String author = req.getParameter("author");
		 String category=req.getParameter("category");
		 String publisher =req.getParameter("publisher");
		 String isbn=req.getParameter("isbn");
		 int quantity=Integer.parseInt(req.getParameter("quantity"));
		 int availableQuantity=Integer.parseInt(req.getParameter("availableQuantity"));
		 
		 
		  Book book = new Book();

	         book.setTitle(title);
	         book.setAuthor(author);
	         book.setCategory(category);
	         book.setPublisher(publisher);
	         book.setIsbn(isbn);
	         book.setQuantity(quantity);
	         book.setAvailableQuantity(availableQuantity);
		 
	         boolean status;
		 try {
			status= bookdao.updateBook(book,id);
			

			if(status) {
				
				
				res.sendRedirect("Dashboard.jsp?Updmsg=1");
				
			}
			else {
				res.sendRedirect("Dashboard.jsp?Upderr=1");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
