package org.traffic360.contacts.servlets;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.traffic360.contacts.bean.User;
import org.traffic360.contacts.controller.ContactController;

@WebServlet(value={"/login"})
public class Login
extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        String username = req.getParameter("txtUsername");
        String password = req.getParameter("txtPassword");
        try {
            User usuario = ContactController.getInstance().validateUser(username, password);
            if (usuario != null) {
                User.setActual((User)usuario);
                HttpSession sesion = req.getSession(true);
                sesion.setAttribute("usuario", (Object)usuario);
                sesion.setAttribute("nick", (Object)usuario.getUserName());
                User.setActual((User)usuario);
                if (User.getActual().getRol() == 1) {
                    sesion.setAttribute("rol", (Object)1);
                    despachador = req.getRequestDispatcher("/redirect.jsp");
                } else if (User.getActual().getRol() == 0) {
                    sesion.setAttribute("rol", (Object)0);
                    despachador = req.getRequestDispatcher("/redirect.jsp");
                }
            } else {
                req.setAttribute("error", (Object)"Verifica tus credenciales");
                despachador = req.getRequestDispatcher("/config");
            }
            despachador.forward((ServletRequest)req, (ServletResponse)resp);
        }
        catch (SQLException ex) {
            System.out.println("hola :(");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}