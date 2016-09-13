package org.traffic360.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.traffic360.contacts.bean.Contact;
import org.traffic360.contacts.bean.Email;
import org.traffic360.contacts.bean.Phone;
import org.traffic360.contacts.bean.Skype;
import org.traffic360.contacts.controller.ContactController;
import org.traffic360.contacts.controller.EmailController;
import org.traffic360.contacts.controller.PhoneController;
import org.traffic360.contacts.controller.SkypeController;

@WebServlet("/add-contact-new")
public class AddContact extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher despachador=null;
		try {			
			Integer ext = (req.getParameter("txtExtension").equals("")) ? null : Integer.parseInt(req.getParameter("txtExtension")); 
			Integer zoiper = (req.getParameter("txtZoiper").equals("")) ? null : Integer.parseInt(req.getParameter("txtZoiper")); 
					
			Contact contact=new Contact(null,
					Integer.parseInt(req.getParameter("txtDepartamento")),
					req.getParameter("txtRol"),
					req.getParameter("txtNombre"),
					req.getParameter("txtApellido"),
					req.getParameter("txtEmpresa"),
					ext,
					zoiper,
					req.getParameter("txtFechaDeIngreso"),
					1);
			ContactController.getInstance().add(contact);
			
			for(int x = 1 ; x<3 ; x++){
				String email = req.getParameter("txtCorreo"+x);
				if(email != null && email.length() > 0){
					Email e = new Email(0,email,ContactController.getInstance().getIdContact(contact));
					EmailController.getInstance().add(e);
				}
			}
			
			for(int x = 1 ; x<3 ; x++){
			String skype = req.getParameter("txtSkype"+x);
				if(skype != null && skype.length()>0){
					Skype s = new Skype(0,skype,ContactController.getInstance().getIdContact(contact));
					SkypeController.getInstance().add(s);
				}
			}
			 				
			
				for(int x = 1 ; x<4 ; x++){
					try{
					Integer number = Integer.parseInt(req.getParameter("txtTelefono"+x));
					Phone  phone = new Phone(0, number, ContactController.getInstance().getIdContact(contact));
					PhoneController.getInstance().add(phone);
					}catch(NumberFormatException num){}	
				}
					
			despachador=req.getRequestDispatcher("/redirect.jsp");
			despachador.forward(req, resp);			
		}
		catch(SQLException ex){}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	
	}
}
