package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ViewCartDAO;
import model.CartItem;

@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet{
	ViewCartDAO viewcartdao=new ViewCartDAO();
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<CartItem> itemList=new ArrayList<CartItem>();
		
			try {
				itemList=viewcartdao.viewCart();
				
				req.setAttribute("CartList", itemList);
				req.getRequestDispatcher("menu.jsp").forward(req, res);
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
	
}
