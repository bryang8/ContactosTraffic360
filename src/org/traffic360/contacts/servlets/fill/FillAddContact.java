package org.traffic360.contacts.servlets.fill;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.traffic360.contacts.controller.ContactController;

@WebServlet(value={"/add-contact"})
public class FillAddContact
extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        List list = ContactController.getInstance().departmentsList();
        req.setAttribute("departmentList", (Object)list);
        despachador = req.getRequestDispatcher("addContact.jsp");
        despachador.forward((ServletRequest)req, (ServletResponse)resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}