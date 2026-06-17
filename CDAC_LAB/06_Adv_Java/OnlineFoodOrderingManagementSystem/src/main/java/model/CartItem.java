package model;

public class CartItem {
	
private int food_id;

private String food_name;
private double price;



public CartItem() {
	
}

public CartItem(int food_id, String food_name, double price) {
	
	this.food_id = food_id;
	this.food_name = food_name;
	this.price = price;
}

public int getFood_id() {
	return food_id;
}
public void setFood_id(int food_id) {
	this.food_id = food_id;
}
public String getFood_name() {
	return food_name;
}
public void setFood_name(String food_name) {
	this.food_name = food_name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


	
	
}
