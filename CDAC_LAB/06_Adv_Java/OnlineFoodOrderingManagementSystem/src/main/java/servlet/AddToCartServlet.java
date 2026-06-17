package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.Order;

@WebServlet("/addOrder")
public class AddToCartServlet extends HttpServlet{
	
	OrderDAO orderDao=new OrderDAO();
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		int foodId=Integer.parseInt(req.getParameter("id"));
		String foodname=req.getParameter("foodname");
		double price=Double.parseDouble(req.getParameter("price"));
		String username = req.getParameter("username");
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		double total_amount= price*quantity;
		
		Order o =new Order(username,foodname,quantity,total_amount);
		
	boolean isOrderCreated;
	try {
		isOrderCreated = orderDao.orderCreate(o);
		if(isOrderCreated) {
			res.sendRedirect("cart.jsp");
		}else {
			res.sendRedirect("menu.jsp");
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
		
	}

}
