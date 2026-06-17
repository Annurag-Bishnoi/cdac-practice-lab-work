package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import model.CartItem;
import model.Order;
import util.DBUtil;


public class OrderDAO {

	public boolean orderCreate(Order o) throws ClassNotFoundException, SQLException {
		
		
		Connection con= DBUtil.getConnection();
		
		String sql= "Insert into orders (username,food_name,quantity,total_amount) values (?,?,?,?)";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1, o.getUsername());
		ps.setString(2,o.getFood_name());
		ps.setInt(3, o.getQuantity());
		ps.setDouble(4, o.getTotal_amount());
		
		int row=ps.executeUpdate();
		
		if(row>0) {
			return true;
		}
		
		
		return false;
	}

	public ArrayList<Order> viewOrders() throws SQLException, ClassNotFoundException {
		ArrayList<Order> orderList=new ArrayList<Order> ();
		Connection con=DBUtil.getConnection();
		
		
		String sql="select * from orders";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ResultSet rs= ps.executeQuery();
		
		
		Order order=null;
		while(rs.next()) {
			order=new Order();
			order.setOrder_id(rs.getInt("order_id"));
			order.setFood_name(rs.getString("food_name"));
			order.setQuantity(rs.getInt("quantity"));
			order.setTotal_amount(rs.getDouble("total_amount"));
			
			
			
			orderList.add(order);
			
			
			
		}
		
		return orderList;
		
	}

	public boolean deleteOrder(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		

		Connection con= DBUtil.getConnection();
		
		String sql="Delete from orders where order_id=?";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		int row=ps.executeUpdate();
		if(row>0) {
			return true;
		}
		
		
		
		
		return false;
		
	}
	
	
}
