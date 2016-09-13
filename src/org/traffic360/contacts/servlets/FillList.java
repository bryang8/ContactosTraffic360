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

import org.traffic360.contacts.bean.User;
import org.traffic360.contacts.bean.Department;
import org.traffic360.contacts.bean.UserLogged;
import org.traffic360.contacts.controller.ContactController;

@WebServlet("/list")
public class FillList extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher despachador=null;
			for(String ip :IPFilter.allowedips){
				if(req.getRemoteAddr().equals(ip)){
					List<Department> list = ContactController.getInstance().departmentsList();
					for(Department d: list){
						d.setName(d.getName().toUpperCase());
					}
					req.setAttribute("edit-permission", 1);
					req.setAttribute("departmentList",
							list);
					req.setAttribute("contactList",
							ContactController.getInstance().contactList());
					req.setAttribute("phoneList",
							ContactController.getInstance().phoneList());
					req.setAttribute("emailList",
							ContactController.getInstance().emailList());
					req.setAttribute("skypeList",
							ContactController.getInstance().skypeList());	
					despachador=req.getRequestDispatcher("inicio.jsp");
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
