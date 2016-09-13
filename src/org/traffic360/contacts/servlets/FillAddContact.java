package org.traffic360.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.traffic360.contacts.bean.UserLogged;
import org.traffic360.contacts.controller.ContactController;

@WebServlet("/add-contact")
public class FillAddContact extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RequestDispatcher despachador=null;
		if(UserLogged.getUserLogged()!=null){
			req.setAttribute("departmentList",
					ContactController.getInstance().departmentsList());
			despachador=req.getRequestDispatcher("addContact.jsp");	
		}
		else{
			despachador=req.getRequestDispatcher("/home");
		}
		despachador.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}