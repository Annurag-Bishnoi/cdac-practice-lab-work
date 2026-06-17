package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;
import util.DbConnection;

public class BookDAO {
	
	

	public boolean createBook(Book b) throws ClassNotFoundException, SQLException {
		
		boolean status = false;
		
		Connection con = DbConnection.getConnection();
		
		String sql="INSERT INTO books (title, author, category, publisher, isbn, quantity, available_quantity) VALUES (?,?,?,?,?,?,?)";
		
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		 ps.setString(1, b.getTitle());
         ps.setString(2, b.getAuthor());
         ps.setString(3, b.getCategory());
         ps.setString(4, b.getPublisher());
         ps.setString(5, b.getIsbn());
         ps.setInt(6, b.getQuantity());
         ps.setInt(7, b.getQuantity());
		
		int row=ps.executeUpdate();
		
		if(row>0) {
		status= true;
		}
		
		return status;
		
		
	}
	
	
	public ArrayList<Book> viewBooks() throws SQLException, ClassNotFoundException {
		
		ArrayList<Book> bookList=new ArrayList<Book>();
		Connection con= DbConnection.getConnection();
		
		String sql="SELECT * FROM books ORDER BY book_id DESC";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			 Book book = new Book();

             book.setBookId(rs.getInt("book_id"));
             book.setTitle(rs.getString("title"));
             book.setAuthor(rs.getString("author"));
             book.setCategory(rs.getString("category"));
             book.setPublisher(rs.getString("publisher"));
             book.setIsbn(rs.getString("isbn"));
             book.setQuantity(rs.getInt("quantity"));
             book.setAvailableQuantity(rs.getInt("available_quantity"));

             bookList.add(book);
		
			
		}
		
		
		return bookList;
		
		
	}


	public boolean deleteBook(int id) throws ClassNotFoundException, SQLException {
	
		Connection con= DbConnection.getConnection();
		
		String sql="Delete from books where book_id=?";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		int row=ps.executeUpdate();
		if(row>0) {
			return true;
		}
		
		
		
		
		return false;
	}


	public Book bookGetById(int id) throws SQLException, ClassNotFoundException {
		
	Connection con= DbConnection.getConnection();
		
		String sql="Select * from books where book_id=?";
		
		PreparedStatement ps= con.prepareStatement(sql);
	
		ps.setInt(1, id);
		
ResultSet rs= ps.executeQuery();
	Book b=null;
		while(rs.next()) {
			b=new Book();
			b.setBookId(Integer.parseInt(rs.getString("book_id")));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setCategory(rs.getString("category"));
			b.setPublisher(rs.getString("publisher"));
			b.setIsbn(rs.getString("isbn"));
			b.setQuantity(rs.getInt("quantity"));
			b.setAvailableQuantity(rs.getInt("available_quantity"));
			
		
			
		}
		return b;
	}


	public boolean updateBook(Book b,int id) throws ClassNotFoundException, SQLException {
		
Connection con = DbConnection.getConnection();
		
		String sql="UPDATE books SET title = ?, author = ?, category = ?, publisher = ?, isbn = ?, quantity = ?, available_quantity = ? WHERE book_id = ?";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		 ps.setString(1, b.getTitle());
         ps.setString(2, b.getAuthor());
         ps.setString(3, b.getCategory());
         ps.setString(4, b.getPublisher());
         ps.setString(5, b.getIsbn());
         ps.setInt(6, b.getQuantity());
         ps.setInt(7, b.getAvailableQuantity() );
         ps.setInt(8, id);
		
		
		int row=ps.executeUpdate();
		
		if(row>0) {
			return true;
		}
		return false;
		
		
	}
	
	
	
	
	
	

}
