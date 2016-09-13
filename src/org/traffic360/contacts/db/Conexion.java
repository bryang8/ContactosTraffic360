package org.traffic360.contacts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private Connection conexion;
	private Statement stm;
	private static Conexion instancia;
	
	public static synchronized
	Conexion getInstancia(){
		return (instancia==null)?
				new Conexion():instancia; 
	}
	//(condición)?opcion por verdadero:opcion por falso
	public void ejecutarConsulta(
			String consulta){
		try {
			stm.execute(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet obtenerConsulta(
			String consulta){
		ResultSet rs=null;
		try {
			rs=stm.executeQuery(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public Conexion(){
		try{
			Class.forName(
					"com.mysql.jdbc.Driver"
					).newInstance();
			conexion=DriverManager.
					getConnection(
					"jdbc:mysql://"
					+ "localhost:3306"
					+ "/contacts_db"
					+ "?user=root&password=1234&autoReconnect=true&useSSL=false");
			stm=conexion.createStatement();
		}catch(   IllegalAccessException  
				ex){
			ex.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(SQLException  ex){
			ex.printStackTrace();
		}
	}

	
}
