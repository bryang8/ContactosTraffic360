package org.traffic360.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.traffic360.contacts.bean.Contact;
import org.traffic360.contacts.bean.Department;
import org.traffic360.contacts.bean.Email;
import org.traffic360.contacts.bean.Phone;
import org.traffic360.contacts.bean.Skype;
import org.traffic360.contacts.bean.UserLogged;
import org.traffic360.contacts.controller.ContactController;
import org.traffic360.contacts.controller.EmailController;
import org.traffic360.contacts.controller.PhoneController;
import org.traffic360.contacts.controller.SkypeController;

@WebServlet("/edit-contact-view")
public class FillEditContact extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher despachador = null;
		if(UserLogged.getUserLogged()!=null){
			Contact contact = ContactController.getInstance().search(Integer.parseInt(req.getParameter("idContact")));
			req.setAttribute("contacto", contact);
			
			List<Phone> phoneList = PhoneController.getInstance().phoneList(contact.getIdContact());
			List<Email> emailList = EmailController.getInstance().emailList(contact.getIdContact());
			List<Skype> skypeList = SkypeController.getInstance().skypeList(contact.getIdContact());		
			
			int i = 1;
			for(Phone p: phoneList){
				req.setAttribute("numero" + i, p.getNumber());
				i++;			
			}
			
			i = 1;
			for(Email e: emailList){
				req.setAttribute("correo" + i, e.getEmail());
				i++;			
			}
			
			i = 1;
			for(Skype s: skypeList){
				req.setAttribute("skype" + i, s.getSkype());
				i++;			
			}		
			
			List<Department> list = ContactController.getInstance().departmentsList();
			int x =0;
			for (Department d : list){
				if(d.getIdDepartment() == contact.getIdDepartment()){
					list.set(x, list.get(0));
					list.set(0, d);
				}
				x++;
			}
			req.setAttribute("departmentList",list);		
			
			despachador = req.getRequestDispatcher("editContact.jsp");
		}
		else{
			despachador = req.getRequestDispatcher("/home");
		}
		despachador.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
