package org.traffic360.contacts.controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.traffic360.contacts.bean.Contact;
import org.traffic360.contacts.bean.Department;
import org.traffic360.contacts.bean.Email;
import org.traffic360.contacts.bean.Phone;
import org.traffic360.contacts.bean.Skype;
import org.traffic360.contacts.db.Conexion;
import org.traffic360.contacts.helpers.Encrypt;

import com.mysql.jdbc.PreparedStatement;


public class ContactController {
	private static ContactController instance;
	public static ContactController getInstance(){
		return (instance==null)?
				new ContactController():instance;
	}
	public List<Department> departmentsList(){
		ResultSet rs=Conexion.getInstancia().obtenerConsulta("SELECT * from department ;");
		List<Department> list=new ArrayList();
		try {
			while(rs.next()){
				list.add(new Department(
						rs.getInt("idDepartment"),
						rs.getString("name")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Contact> contactList(){
		ResultSet rs=Conexion.getInstancia().obtenerConsulta("SELECT * from contact WHERE status = '1' ;");
		List<Contact> list=new ArrayList();
		if(rs != null){
			try {
				while(rs.next()){
					list.add(new Contact(
							rs.getInt("idContact"),
							rs.getInt("idDepartment"),
							rs.getString("rol"),
							rs.getString("name"),
							rs.getString("lastName"),
							rs.getString("company"),
							rs.getInt("extension"),
							rs.getInt("zoiper"),
							rs.getString("enrrollingDate"),
							rs.getInt("status")
							));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Phone> phoneList(){
		ResultSet rs=Conexion.getInstancia().obtenerConsulta("SELECT * from phone ;");
		List<Phone> list=new ArrayList();
		try {
			while(rs.next()){
				list.add(new Phone(
						rs.getInt("idPhone"),
						rs.getInt("number"),
						rs.getInt("idContact")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Email> emailList(){
		ResultSet rs=Conexion.getInstancia().obtenerConsulta("SELECT * from email ;");
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
	
	public List<Skype> skypeList(){
		ResultSet rs=Conexion.getInstancia().obtenerConsulta("SELECT * from skype ;");
		List<Skype> list=new ArrayList();
		try {
			while(rs.next()){
				list.add(new Skype(
						rs.getInt("idSkype"),
						rs.getString("skype"),
						rs.getInt("idContact")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void add(Contact contact){
		Conexion.getInstancia()
			.ejecutarConsulta(
					"INSERT INTO contact values(null,"
					+ "'"+contact.getName()+"',"
					+ "'"+contact.getLastName()+"',"
					+ "'"+contact.getRol()+"',"
					+ "'"+contact.getCompany()+"',"
					+contact.getExtension()+","
					+contact.getZoiper()+","
					+"'"+contact.getEnrrollingDate()+"','"
					+contact.getIdDepartment()+"','"
					+contact.getStatus()+"');" );
	}
	
	
	public void delete(Integer idContact){
		Conexion.getInstancia()
			.ejecutarConsulta(
					"delete from contact "
					+ "		where idContact="+idContact);
	}
	
	public void setDown(Integer idContact){
		Conexion.getInstancia()
			.ejecutarConsulta(
					"UPDATE contact SET status = '0' WHERE idContact = '" + idContact + "';");
	}

	
	public Contact search(Integer idContact){
		ResultSet rs = null;
		Contact contact = null;
		rs = Conexion.getInstancia()
			.obtenerConsulta(
					"SELECT * FROM contact "
					+ "where idContact = " + idContact);
		
		try{
			while(rs.next()){
				contact = new Contact(
						rs.getInt("idContact"),
						rs.getInt("idDepartment"),
						rs.getString("rol"),
						rs.getString("name"),
						rs.getString("lastName"),
						rs.getString("company"),
						rs.getInt("extension"),
						rs.getInt("zoiper"),
						rs.getString("enrrollingDate"),
						rs.getInt("status")
						);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return contact;
	}
	
	public void edit(Contact contact){
		Conexion.getInstancia()
			.ejecutarConsulta(
					"UPDATE contact SET name = '" +contact.getName()+"',"
					+ "lastName = '"+contact.getLastName() +"',"
					+ "rol = '"+ contact.getRol()+"',"
					+ "company = '" + contact.getCompany()+"',"
					+ "extension = "+contact.getExtension() +","
					+ "zoiper = "+ contact.getZoiper()+","
					+ "enrrollingDate = '"+ contact.getEnrrollingDate()+"',"
					+ "idDepartment = "+contact.getIdDepartment()
					+" WHERE idContact = "+ contact.getIdContact() + ";");

	}
	
	public Integer getIdContact(Contact contact)throws SQLException{
	   ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT idContact FROM contact WHERE name = '" +  contact.getName()
			   + "' and lastName = '" + contact.getLastName() + "' and rol = '" + contact.getRol() + "' and company = '" + contact.getCompany()
			   + "' and idDepartment = '" + contact.getIdDepartment() + "';");
       while(rs.next()){
           return rs.getInt("idContact");
       }		    
	   return 0;
	}
	
	public boolean validateUser(String username, String password)throws SQLException{
		  password = Encrypt.Encriptar(password);
		  ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT idUser FROM user WHERE username = '" +  username
				   + "' and password = '" + password + "';");
	       while(rs.next()){
	           return true;
	       }		    
		   return false;
		}
}