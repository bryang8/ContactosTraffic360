package org.traffic360.contacts.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.traffic360.contacts.helpers.Reader;

public class Conexion {
    private Connection conexion;
    private Statement stm;
    private static Conexion instancia;
    private static String IP_SERVIDOR;
    private static String PUERTO_SERVIDOR;
    private static String NOMBRE_DB;
    private static String USER;
    private static String PASSWORD;
    

    public static synchronized Conexion getInstancia(){
        return instancia == null ? new Conexion() : instancia;
    }

    public void ejecutarConsulta(String string) {
        try {
            this.stm.execute(string);
        }
        catch (SQLException var2_2) {
            var2_2.printStackTrace();
        }
    }

    public ResultSet obtenerConsulta(String string) {
        ResultSet resultSet = null;
        try {
            resultSet = this.stm.executeQuery(string);
        }
        catch (SQLException var3_3) {
            var3_3.printStackTrace();
        }
        return resultSet;
    }

    public Conexion() {
    	
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conexion = DriverManager.getConnection("jdbc:mysql://151.236.218.69:3306/contactos_traffic?user=it@traffic360&password=Traff1c.c0nt4ct5&autoReconnect=true&useSSL=false");
            this.stm = this.conexion.createStatement();
        }
        catch (IllegalAccessException var1_1) {
            var1_1.printStackTrace();
        }
        catch (ClassNotFoundException var1_2) {
            var1_2.printStackTrace();
        }
        catch (InstantiationException var1_3) {
            var1_3.printStackTrace();
        }
        catch (SQLException var1_4) {
            var1_4.printStackTrace();
        }
    }
}