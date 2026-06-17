package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.Order;

@WebServlet("/viewOrder")
public class ViewOrderServlet extends HttpServlet {
	
	OrderDAO orderDao =new OrderDAO();
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		try {
			orderList=orderDao.viewOrders();
			req.setAttribute("OrderList", orderList);
			req.getRequestDispatcher("cart.jsp").forward(req, res);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
