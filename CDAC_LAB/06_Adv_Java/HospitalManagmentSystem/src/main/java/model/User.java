package model;

public class User {

	private String user_id;
	private String fullname;
	private String username;
	private String email;
	private String role_name;
	private String password;
	private boolean isActive;
	public User() {}
	
	
	
	
	
	
	public User( String fullname,String username, String email, String role_name,String password,boolean isActive) {

		
		this.fullname = fullname;
		this.username=username;
		this.email = email;
		this.password=password;
		this.role_name = role_name;
		this.isActive=isActive;
		
	}
	
	
	
	public boolean isActive() {
		return isActive;
	}






	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getUsername() {
		return username;
	}






	public void setUsername(String username) {
		this.username = username;
	}






	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	
	
	
}
