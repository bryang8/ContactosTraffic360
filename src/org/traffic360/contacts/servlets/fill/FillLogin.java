package org.traffic360.contacts.servlets.fill;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.traffic360.contacts.bean.User;

@WebServlet("/config")
public class FillLogin
extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        despachador = User.getActual() != null ? req.getRequestDispatcher("/list") : req.getRequestDispatcher("login.jsp");
        despachador.forward((ServletRequest)req, (ServletResponse)resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}