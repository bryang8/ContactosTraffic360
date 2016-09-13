package org.traffic360.contacts.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.traffic360.contacts.bean.Phone;
import org.traffic360.contacts.bean.Skype;
import org.traffic360.contacts.db.Conexion;

public class SkypeController {
	private static SkypeController instance;
	public static SkypeController getInstance(){
		return (instance==null)?
				new SkypeController():instance;
	}
	
	public List<Skype> skypeList(Integer idContact){
		ResultSet rs=Conexion.getInstancia().obtenerConsulta("SELECT * from skype WHERE idContact = "
				+ idContact + ";");
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
	
	public void add(Skype skype){
		Conexion.getInstancia()
			.ejecutarConsulta("INSERT INTO skype values(null,'"
					+ skype.getSkype()+"',"
					+ skype.getIdContact()+");");
	}
	
	public void delete(Integer idSkype){
		Conexion.getInstancia()
			.ejecutarConsulta("DELETE FROM skype WHERE idSkype= "+idSkype);
	}
	
	public void edit(Skype skype){
		Conexion.getInstancia()
			.ejecutarConsulta("UPDATE skype SET skype = '" + skype.getSkype() + "' WHERE idSkype = "+ skype.getIdSkype() + " ;" );
	}
	
	public String getSkypeUser(Integer idContact)throws SQLException{
		ResultSet rs = Conexion.getInstancia().obtenerConsulta("Select skype From skype where idContact = " + idContact + ";" );
		while(rs.next()){
			return rs.getString("skype");
		}
		return "";
	}
}
