package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CartItem;
import util.DBUtil;

public class ViewCartDAO {
	
	
	
	public ArrayList<CartItem> viewCart() throws SQLException, ClassNotFoundException{
		
		ArrayList<CartItem> cartList=new ArrayList<CartItem> ();
		Connection con=DBUtil.getConnection();
		
		
		String sql="select * from food_items";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ResultSet rs= ps.executeQuery();
		
		
		CartItem cartitem=null;
		while(rs.next()) {
			cartitem=new CartItem();
			cartitem.setFood_id(rs.getInt(1));
			cartitem.setFood_name(rs.getString(2));
			cartitem.setPrice(rs.getDouble(3));
			
			cartList.add(cartitem);
			
			
			
		}
		
		return cartList;
		
	}

}
