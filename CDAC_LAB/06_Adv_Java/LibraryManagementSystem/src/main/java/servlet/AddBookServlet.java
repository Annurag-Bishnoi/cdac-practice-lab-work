package servlet;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {

	BookDAO bookDAO=new BookDAO();
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		 String title = req.getParameter("title");
         String author = req.getParameter("author");
         String category = req.getParameter("category");
         String publisher = req.getParameter("publisher");
         String isbn = req.getParameter("isbn");
         int quantity = Integer.parseInt(req.getParameter("quantity"));

         Book book = new Book();

         book.setTitle(title);
         book.setAuthor(author);
         book.setCategory(category);
         book.setPublisher(publisher);
         book.setIsbn(isbn);
         book.setQuantity(quantity);

         boolean status;
			try {
				status = bookDAO.createBook(book);
				   if (status) {
		                res.sendRedirect("Dashboard.jsp?msg=1");
		            } else {
		                res.sendRedirect("addBook.jsp?error=1");
		            }
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

      
		 
		
		
		
	}
	
}
