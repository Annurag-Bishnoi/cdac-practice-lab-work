package model;

public class Order{

	private int order_id;
	private String username;
	private String food_name;
	private int quantity;
	private double total_amount;
	
	
	public Order() {
	
	}
	
	
	public Order(String username, String food_name, int quantity, double total_amount) {
		super();
		this.username = username;
		this.food_name = food_name;
		this.quantity = quantity;
		this.total_amount = total_amount;
	}


	public Order(int order_id, String username, String food_name, int quantity, double total_amount) {
		
		this.order_id = order_id;
		this.username = username;
		this.food_name = food_name;
		this.quantity = quantity;
		this.total_amount = total_amount;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	
	
	
	
	
	
	
	
}
