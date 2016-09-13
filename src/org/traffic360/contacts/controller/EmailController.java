package org.traffic360.contacts.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.traffic360.contacts.bean.Contact;
import org.traffic360.contacts.bean.Email;
import org.traffic360.contacts.bean.Phone;
import org.traffic360.contacts.db.Conexion;

public class EmailController {
	private static EmailController instance;
	public static EmailController getInstance(){
		return (instance==null)?
				new EmailController():instance;
	}
	
	public List<Email> emailList(Integer idContact){
		ResultSet rs=Conexion.getInstancia().obtenerConsulta("SELECT * from email WHERE idContact = " 
				+ idContact + ";");
		List<Email> list=new ArrayList();
		try {
			while(rs.next()){
				list.add(new Email(
						rs.getInt("idEmail"),
						rs.getString("email"),
						rs.getInt("idContact")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void add(Email email){
		Conexion.getInstancia()
			.ejecutarConsulta("INSERT INTO email values(null,'"
					+ email.getEmail()+"',"
					+ email.getIdContact()+");");
	}
	
	public void delete(Integer idEmail){
		Conexion.getInstancia()
			.ejecutarConsulta("DELETE FROM email WHERE idEmail="+idEmail); 
	}
	
	public void edit(Email email){
		Conexion.getInstancia()
			.ejecutarConsulta("UPDATE email SET email = '" + email.getEmail() + "' WHERE idEmail = "+ email.getIdEmail());
	}
	
	public String getEmailUser(Integer idContact)throws SQLException{
		ResultSet rs = Conexion.getInstancia().obtenerConsulta("Select email From email where idContact = " + idContact + ";" );
		while(rs.next()){
			return rs.getString("email");
		}
		return "";
	}
}
