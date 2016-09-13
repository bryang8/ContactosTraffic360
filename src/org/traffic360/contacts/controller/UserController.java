package org.traffic360.contacts.controller;

import org.traffic360.contacts.bean.User;
import org.traffic360.contacts.db.Conexion;
import org.traffic360.contacts.helpers.Encrypt;

public class UserController {
	private static UserController instance;
	public static UserController getInstance(){
		return (instance==null)?
				new UserController():instance;
	}
	
	public void createUser(User user){
		Conexion.getInstancia().ejecutarConsulta("INSERT INTO user VALUES ( null, '"+ user.getUserName() +"','"+Encrypt.Encriptar(user.getPassword())+"');");
	}
}
