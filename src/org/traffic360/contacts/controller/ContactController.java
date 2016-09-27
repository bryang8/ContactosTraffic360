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
import org.traffic360.contacts.bean.User;
import org.traffic360.contacts.db.Conexion;
import org.traffic360.contacts.helpers.Encrypt;

public class ContactController {
    private static ContactController instance;

    public static ContactController getInstance() {
        return instance == null ? new ContactController() : instance;
    }

    public List<Department> departmentsList() {
        ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT * from department ;");
        ArrayList<Department> list = new ArrayList<Department>();
        try {
            while (rs.next()) {
                list.add(new Department(Integer.valueOf(rs.getInt("idDepartment")), rs.getString("name")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Contact> contactList() {
        ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT * from contact WHERE status = '1' ;");
        ArrayList<Contact> list = new ArrayList<Contact>();
        if (rs != null) {
            try {
                while (rs.next()) {
                    list.add(new Contact(Integer.valueOf(rs.getInt("idContact")), Integer.valueOf(rs.getInt("idDepartment")), rs.getString("rol"), rs.getString("name"), rs.getString("lastName"), rs.getString("company"), Integer.valueOf(rs.getInt("extension")), Integer.valueOf(rs.getInt("zoiper")), rs.getString("enrrollingDate"), Integer.valueOf(rs.getInt("status"))));
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public List<Contact> contactsDownList() {
        ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT * from contact WHERE status = '0' ;");
        ArrayList<Contact> list = new ArrayList<Contact>();
        if (rs != null) {
            try {
                while (rs.next()) {
                    list.add(new Contact(Integer.valueOf(rs.getInt("idContact")), Integer.valueOf(rs.getInt("idDepartment")), rs.getString("rol"), rs.getString("name"), rs.getString("lastName"), rs.getString("company"), Integer.valueOf(rs.getInt("extension")), Integer.valueOf(rs.getInt("zoiper")), rs.getString("enrrollingDate"), Integer.valueOf(rs.getInt("status"))));
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public List<Phone> phoneList() {
        ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT * from phone ;");
        ArrayList<Phone> list = new ArrayList<Phone>();
        try {
            while (rs.next()) {
                list.add(new Phone(Integer.valueOf(rs.getInt("idPhone")), Integer.valueOf(rs.getInt("number")), Integer.valueOf(rs.getInt("idContact"))));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Email> emailList() {
        ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT * from email ;");
        ArrayList<Email> list = new ArrayList<Email>();
        try {
            while (rs.next()) {
                list.add(new Email(Integer.valueOf(rs.getInt("idEmail")), rs.getString("email"), Integer.valueOf(rs.getInt("idContact"))));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Skype> skypeList() {
        ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT * from skype ;");
        ArrayList<Skype> list = new ArrayList<Skype>();
        try {
            while (rs.next()) {
                list.add(new Skype(Integer.valueOf(rs.getInt("idSkype")), rs.getString("skype"), Integer.valueOf(rs.getInt("idContact"))));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(Contact contact) {
        Conexion.getInstancia().ejecutarConsulta("INSERT INTO contact values(null,'" + contact.getName() + "'," + "'" + contact.getLastName() + "'," + "'" + contact.getRol() + "'," + "'" + contact.getCompany() + "'," + contact.getExtension() + "," + contact.getZoiper() + "," + "'" + contact.getEnrrollingDate() + "','" + contact.getIdDepartment() + "','" + contact.getStatus() + "');");
    }

    public void delete(Integer idContact) {
        Conexion.getInstancia().ejecutarConsulta("delete from contact \t\twhere idContact=" + idContact);
    }

    public void setDown(Integer idContact) {
        Conexion.getInstancia().ejecutarConsulta("UPDATE contact SET status = '0' WHERE idContact = '" + idContact + "';");
    }

    public void setUp(Integer idContact) {
        Conexion.getInstancia().ejecutarConsulta("UPDATE contact SET status = '1' WHERE idContact = '" + idContact + "';");
    }

    public Contact search(Integer idContact) {
        ResultSet rs = null;
        Contact contact = null;
        rs = Conexion.getInstancia().obtenerConsulta("SELECT * FROM contact where idContact = " + idContact);
        try {
            while (rs.next()) {
                contact = new Contact(Integer.valueOf(rs.getInt("idContact")), Integer.valueOf(rs.getInt("idDepartment")), rs.getString("rol"), rs.getString("name"), rs.getString("lastName"), rs.getString("company"), Integer.valueOf(rs.getInt("extension")), Integer.valueOf(rs.getInt("zoiper")), rs.getString("enrrollingDate"), Integer.valueOf(rs.getInt("status")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }

    public void edit(Contact contact) {
        Conexion.getInstancia().ejecutarConsulta("UPDATE contact SET name = '" + contact.getName() + "'," + "lastName = '" + contact.getLastName() + "'," + "rol = '" + contact.getRol() + "'," + "company = '" + contact.getCompany() + "'," + "extension = " + contact.getExtension() + "," + "zoiper = " + contact.getZoiper() + "," + "enrrollingDate = '" + contact.getEnrrollingDate() + "'," + "idDepartment = " + contact.getIdDepartment() + " WHERE idContact = " + contact.getIdContact() + ";");
    }

    public Integer getIdContact(Contact contact) throws SQLException {
        ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT idContact FROM contact WHERE name = '" + contact.getName() + "' and lastName = '" + contact.getLastName() + "' and rol = '" + contact.getRol() + "' and company = '" + contact.getCompany() + "' and idDepartment = '" + contact.getIdDepartment() + "';");
        if (rs.next()) {
            return rs.getInt("idContact");
        }
        return 0;
    }

    public User validateUser(String username, String password) throws SQLException {
        password = Encrypt.Encriptar((String)password);
        ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT idUser, rol FROM user WHERE username = '" + username + "' and password = '" + password + "';");
        User user = null;
        while (rs.next()) {
            user = new User(username, password, Integer.valueOf(rs.getInt("rol")));
        }
        return user;
    }
}