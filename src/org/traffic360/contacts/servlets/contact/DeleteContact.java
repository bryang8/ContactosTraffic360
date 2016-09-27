package org.traffic360.contacts.servlets.contact;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.traffic360.contacts.controller.ContactController;

@WebServlet(value={"/delete-contact-confirm"})
public class DeleteContact
extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        Integer idContact = null;
        if (req.getParameter("idContact") != null) {
            idContact = Integer.parseInt(req.getParameter("idContact"));
        }
        if (req.getParameter("final") != null) {
            if (req.getParameter("final").equals("0")) {
                ContactController.getInstance().delete(idContact);
            } else {
                ContactController.getInstance().setUp(idContact);
            }
        } else {
            ContactController.getInstance().setDown(idContact);
        }
        despachador = req.getRequestDispatcher("/redirect.jsp");
        despachador.forward((ServletRequest)req, (ServletResponse)resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}