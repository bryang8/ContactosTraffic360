package org.traffic360.contacts.bean;

public class UserLogged {
	public static User userLogged;

	public static User getUserLogged() {
		return userLogged;
	}

	public static void setUserLogged(User userLogged) {
		UserLogged.userLogged = userLogged;
	}
	
}
