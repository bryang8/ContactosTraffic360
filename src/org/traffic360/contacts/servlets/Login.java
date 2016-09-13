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
import javax.servlet.http.HttpSession;

import org.traffic360.contacts.bean.User;
import org.traffic360.contacts.bean.UserLogged;
import org.traffic360.contacts.controller.ContactController;
import org.traffic360.contacts.controller.UserController;
import org.traffic360.contacts.db.Conexion;

@WebServlet("/login")
public class Login extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher despachador=null;

			String username = req.getParameter("txtUsername");
			String password = req.getParameter("txtPassword");

			try {
				
			User usuario = ContactController.getInstance().validateUser(username, password);
			if(usuario!=null){
				User.setActual(usuario);
				HttpSession sesion=req.getSession(true);
				sesion.setAttribute("usuario",usuario);
				if(User.getActual().getRol() == 1){
					despachador=req.getRequestDispatcher("/redirect.jsp");
				}
				else if(User.getActual().getRol() == 0){
					despachador=req.getRequestDispatcher("/redirect.jsp");
				}
				
			}else{
				req.setAttribute("error", "Verifica tus credenciales");
				despachador=req.getRequestDispatcher("/config");
			}
			despachador.forward(req, resp);

			}catch(SQLException ex){
				System.out.println("hola :(");
			}
			
			
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(req, resp);
		}
	}
