package org.traffic360.contacts.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.traffic360.contacts.bean.Contact;
import org.traffic360.contacts.bean.Department;
import org.traffic360.contacts.bean.UserLogged;
import org.traffic360.contacts.controller.ContactController;

@WebServlet("/contacts-down")
public class FillContactsDown extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	RequestDispatcher despachador=null;
	for(String ip :IPFilter.allowedips){
		if(req.getRemoteAddr().equals(ip)){
			List<Department> list = new ArrayList<Department>();
			List<Department> departmentList = ContactController.getInstance().departmentsList();
			List<Contact> contactList = ContactController.getInstance().contactsDownList();
			
			for(Contact c: contactList){				
				for(Department d: departmentList){
					if(d.getIdDepartment() == c.getIdDepartment()){
						if(!list.contains(d)){
							list.add(d);
						}						
					}
				}
			}
			
			for(Department d: list){
				d.setName(d.getName().toUpperCase());		
			}
			
			if(UserLogged.getUserLogged() != null){
				if(UserLogged.getUserLogged().getRol() == 0){
					req.setAttribute("edit-permission", 0);
				}
			}						
			req.setAttribute("departmentList", list);
			req.setAttribute("contactList", contactList);
			req.setAttribute("phoneList", ContactController.getInstance().phoneList());
			req.setAttribute("emailList", ContactController.getInstance().emailList());
			req.setAttribute("skypeList", ContactController.getInstance().skypeList());	
			
			
			
			despachador=req.getRequestDispatcher("contactsDown.jsp");
			despachador.forward(req, resp);
			break;
		}
	
	}
}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}

