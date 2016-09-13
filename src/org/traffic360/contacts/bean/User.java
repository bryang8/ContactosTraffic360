package org.traffic360.contacts.bean;

public class User {
	private String userName;
	private String password;
	private Integer rol;
	private static User actual;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userName, String password, Integer rol) {
		super();
		this.userName = userName;
		this.password = password;
		this.rol = rol;
	}
	
	public static User getActual() {
		return actual;
	}
	public static void setActual(User actual) {
		User.actual = actual;
	}
	public Integer getRol() {
		return rol;
	}
	public void setRol(Integer rol) {
		this.rol = rol;
	}
	
	
}
