package org.traffic360.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/edit-contact")
public class EditContact extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher despachador = null;		
		Integer ext = (req.getParameter("txtExtension").equals("")) ? null : Integer.parseInt(req.getParameter("txtExtension")); 
		Integer zoiper = (req.getParameter("txtZoiper").equals("")) ? null : Integer.parseInt(req.getParameter("txtZoiper")); 
		
		Contact contact=new Contact(Integer.parseInt(req.getParameter("txtIdContacto")),
				Integer.parseInt(req.getParameter("txtDepartamento")),
				req.getParameter("txtRol"),
				req.getParameter("txtNombre"),
				req.getParameter("txtApellido"),
				req.getParameter("txtEmpresa"),
				ext,
				zoiper,
				req.getParameter("txtFechaDeIngreso"),
				Integer.parseInt(req.getParameter("txtStatus")));
		ContactController.getInstance().edit(contact);
		
		editContact(req, contact);
		
		despachador=req.getRequestDispatcher("/redirect.jsp");
		despachador.forward(req, resp);			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	public void editContact(HttpServletRequest req, Contact contact){
		
		List<Email> emailList = EmailController.getInstance().emailList(contact.getIdContact());
		List<Skype> skypeList = SkypeController.getInstance().skypeList(contact.getIdContact());
		List<Phone> phoneList = PhoneController.getInstance().phoneList(contact.getIdContact());
		
		for(int x = 1; x<4; x++){
			if(!req.getParameter("txtTelefono" + x).isEmpty()){
				if ( x <= phoneList.size() ){
					Phone phone = phoneList.get(x-1);
					phone.setNumber(Integer.parseInt(req.getParameter("txtTelefono" + x)));
					PhoneController.getInstance().edit(phone);
				}
				else{
					Phone phone = new Phone(0, Integer.parseInt(req.getParameter("txtTelefono"+ x))
							,contact.getIdContact());
					PhoneController.getInstance().add(phone);
				}
			}
			else{
				if ( x <= phoneList.size() ){
					PhoneController.getInstance().delete(phoneList.get(x-1).getIdPhone());
				}
			}
		}
		
		for(int x = 1; x<3; x++){
			if(!req.getParameter("txtCorreo" + x).isEmpty()){
				if ( x <= emailList.size() ){
					Email email = emailList.get(x-1);
					email.setEmail(req.getParameter("txtCorreo" + x));
					EmailController.getInstance().edit(email);
				}
				else{
					Email email = new Email(0, req.getParameter("txtCorreo"+ x)
							,contact.getIdContact());
					EmailController.getInstance().add(email);
				}
			}
			else{
				if ( x <= skypeList.size() ){
					EmailController.getInstance().delete(emailList.get(x-1).getIdEmail());
				}
			}
		}
		
		for(int x = 1; x<3; x++){
			if(!req.getParameter("txtSkype" + x).isEmpty()){
				if ( x <= skypeList.size() ){
					Skype skype = skypeList.get(x-1);
					skype.setSkype(req.getParameter("txtSkype" + x));
					SkypeController.getInstance().edit(skype);
				}
				else{
					Skype skype = new Skype(0, req.getParameter("txtSkype"+ x)
							,contact.getIdContact());
					SkypeController.getInstance().add(skype);
				}
			}
			else{
				if ( x <= skypeList.size() ){
					SkypeController.getInstance().delete(skypeList.get(x-1).getIdSkype());
				}
			}
		}
	}
}
