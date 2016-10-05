package org.traffic360.contacts.servlets.contact;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.traffic360.contacts.bean.Contact;
import org.traffic360.contacts.bean.Email;
import org.traffic360.contacts.bean.Phone;
import org.traffic360.contacts.bean.Skype;
import org.traffic360.contacts.controller.ContactController;
import org.traffic360.contacts.controller.EmailController;
import org.traffic360.contacts.controller.PhoneController;
import org.traffic360.contacts.controller.SkypeController;

@WebServlet("/add-contact-new")
public class AddContact
extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        if (req.getParameter("txtDepartamento").isEmpty() & req.getParameter("txtRol").isEmpty() & req.getParameter("txtNombre").isEmpty() & req.getParameter("txtApellido").isEmpty() & req.getParameter("txtEmpresa").isEmpty()) {
            req.setAttribute("er", (Object)"Completa todos los campos necesarios");
            despachador = req.getRequestDispatcher("/add-contact");
            despachador.forward((ServletRequest)req, (ServletResponse)resp);
        } else {
            try {
                Integer ext = req.getParameter("txtExtension").equals("") ? null : Integer.valueOf(Integer.parseInt(req.getParameter("txtExtension")));
                Integer zoiper = req.getParameter("txtZoiper").equals("") ? null : Integer.valueOf(Integer.parseInt(req.getParameter("txtZoiper")));
                Contact contact = new Contact(null, Integer.valueOf(Integer.parseInt(req.getParameter("txtDepartamento"))), req.getParameter("txtRol"), req.getParameter("txtNombre"), req.getParameter("txtApellido"), req.getParameter("txtEmpresa"), ext, zoiper, req.getParameter("txtFechaDeIngreso"), Integer.valueOf(1));
                ContactController.getInstance().add(contact);
                int x = 1;
                while (x < 3) {
                    String email = req.getParameter("txtCorreo" + x);
                    if (email != null && email.length() > 0) {
                        Email e = new Email(Integer.valueOf(0), email, ContactController.getInstance().getIdContact(contact));
                        EmailController.getInstance().add(e);
                    }
                    ++x;
                }
                x = 1;
                while (x < 3) {
                    String skype = req.getParameter("txtSkype" + x);
                    if (skype != null && skype.length() > 0) {
                        Skype s = new Skype(Integer.valueOf(0), skype, ContactController.getInstance().getIdContact(contact));
                        SkypeController.getInstance().add(s);
                    }
                    ++x;
                }
                x = 1;
                while (x < 4) {
                    try {
                        Integer number = Integer.parseInt(req.getParameter("txtTelefono" + x));
                        Phone phone = new Phone(Integer.valueOf(0), number, ContactController.getInstance().getIdContact(contact));
                        PhoneController.getInstance().add(phone);
                    }
                    catch (NumberFormatException number) {
                        // empty catch block
                    }
                    ++x;
                }
                despachador = req.getRequestDispatcher("/redirect.jsp");
                despachador.forward((ServletRequest)req, (ServletResponse)resp);
            }
            catch (SQLException ext) {
                // empty catch block
            }
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}