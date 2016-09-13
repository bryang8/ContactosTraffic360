package org.traffic360.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.traffic360.contacts.bean.User;
import org.traffic360.contacts.controller.UserController;



@WebServlet("/add-new-user")
public class AddUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher despachador = null;
		
		User user = new User(req.getParameter("txtUsername"), req.getParameter("txtPassword"),0);
		UserController.getInstance().createUser(user);		
		
		despachador = req.getRequestDispatcher("redirect.jsp");
		despachador.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
