package org.traffic360.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.traffic360.contacts.bean.User;
import org.traffic360.contacts.bean.UserLogged;
import org.traffic360.contacts.controller.ContactController;

@WebServlet("/home")
public class FillHome extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for(String ip :IPFilter.allowedips){
			if(req.getRemoteAddr().equals(ip)){
				req.getSession().invalidate();
				req.getSession().removeAttribute("usuario");
				req.getSession().removeAttribute("rol");
				UserLogged.setUserLogged(null);
				User.setActual(null);
				RequestDispatcher despachador=null;
				req.setAttribute("departmentList",
						ContactController.getInstance().departmentsList());
				req.setAttribute("contactList",
						ContactController.getInstance().contactList());
				req.setAttribute("phoneList",
						ContactController.getInstance().phoneList());
				req.setAttribute("emailList",
						ContactController.getInstance().emailList());
				req.setAttribute("skypeList",
						ContactController.getInstance().skypeList());
				despachador=req.getRequestDispatcher("default.jsp");
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
