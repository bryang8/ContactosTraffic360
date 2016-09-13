package org.traffic360.contacts.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.traffic360.contacts.bean.Phone;
import org.traffic360.contacts.db.Conexion;

public class PhoneController {
	private static PhoneController instance;
	public static PhoneController getInstance(){
		return (instance==null)?
				new PhoneController():instance;
	}
	
	public List<Phone> phoneList(Integer idContact){
		ResultSet rs=Conexion.getInstancia().obtenerConsulta("SELECT * from phone WHERE idContact = " 
				+ idContact + ";");
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
	
	public void add(Phone phone){
		Conexion.getInstancia()
			.ejecutarConsulta("INSERT INTO phone values(null,"
					+ phone.getNumber()+","
					+ phone.getIdContact()+");");
	}
	
	public void delete(Integer idPhone){
		Conexion.getInstancia()
			.ejecutarConsulta("DELETE FROM phone WHERE idPhone="+idPhone);
	}
	
	public void edit(Phone phone){
		Conexion.getInstancia()
			.ejecutarConsulta("UPDATE phone SET number = " + phone.getNumber() + " WHERE idPhone = "+ phone.getIdPhone());
	}
	
	public String getPhoneUser(Integer idContact)throws SQLException{
		ResultSet rs = Conexion.getInstancia().obtenerConsulta("Select number From phone where idContact = " + idContact + ";" );
		while(rs.next()){
			return rs.getString("number");
		}
		return "";
	}
	
}
