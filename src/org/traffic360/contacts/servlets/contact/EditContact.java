package org.traffic360.contacts.servlets.contact;

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
import org.traffic360.contacts.bean.Contact;
import org.traffic360.contacts.bean.Email;
import org.traffic360.contacts.bean.Phone;
import org.traffic360.contacts.bean.Skype;
import org.traffic360.contacts.controller.ContactController;
import org.traffic360.contacts.controller.EmailController;
import org.traffic360.contacts.controller.PhoneController;
import org.traffic360.contacts.controller.SkypeController;

@WebServlet(value={"/edit-contact"})
public class EditContact
extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        Integer ext = req.getParameter("txtExtension").equals("") ? null : Integer.valueOf(Integer.parseInt(req.getParameter("txtExtension")));
        Integer zoiper = req.getParameter("txtZoiper").equals("") ? null : Integer.valueOf(Integer.parseInt(req.getParameter("txtZoiper")));
        Contact contact = new Contact(Integer.valueOf(Integer.parseInt(req.getParameter("txtIdContacto"))), Integer.valueOf(Integer.parseInt(req.getParameter("txtDepartamento"))), req.getParameter("txtRol"), req.getParameter("txtNombre"), req.getParameter("txtApellido"), req.getParameter("txtEmpresa"), ext, zoiper, req.getParameter("txtFechaDeIngreso"), Integer.valueOf(Integer.parseInt(req.getParameter("txtStatus"))));
        ContactController.getInstance().edit(contact);
        this.editContact(req, contact);
        despachador = req.getRequestDispatcher("/redirect.jsp");
        despachador.forward((ServletRequest)req, (ServletResponse)resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    public void editContact(HttpServletRequest req, Contact contact) {
        List emailList = EmailController.getInstance().emailList(contact.getIdContact());
        List skypeList = SkypeController.getInstance().skypeList(contact.getIdContact());
        List phoneList = PhoneController.getInstance().phoneList(contact.getIdContact());
        int x = 1;
        while (x < 4) {
            if (!req.getParameter("txtTelefono" + x).isEmpty()) {
                Phone phone;
                if (x <= phoneList.size()) {
                    phone = (Phone)phoneList.get(x - 1);
                    phone.setNumber(Integer.valueOf(Integer.parseInt(req.getParameter("txtTelefono" + x))));
                    PhoneController.getInstance().edit(phone);
                } else {
                    phone = new Phone(Integer.valueOf(0), Integer.valueOf(Integer.parseInt(req.getParameter("txtTelefono" + x))), contact.getIdContact());
                    PhoneController.getInstance().add(phone);
                }
            } else if (x <= phoneList.size()) {
                PhoneController.getInstance().delete(((Phone)phoneList.get(x - 1)).getIdPhone());
            }
            ++x;
        }
        x = 1;
        while (x < 3) {
            if (!req.getParameter("txtCorreo" + x).isEmpty()) {
                Email email;
                if (x <= emailList.size()) {
                    email = (Email)emailList.get(x - 1);
                    email.setEmail(req.getParameter("txtCorreo" + x));
                    EmailController.getInstance().edit(email);
                } else {
                    email = new Email(Integer.valueOf(0), req.getParameter("txtCorreo" + x), contact.getIdContact());
                    EmailController.getInstance().add(email);
                }
            } else if (x <= skypeList.size()) {
                EmailController.getInstance().delete(((Email)emailList.get(x - 1)).getIdEmail());
            }
            ++x;
        }
        x = 1;
        while (x < 3) {
            if (!req.getParameter("txtSkype" + x).isEmpty()) {
                Skype skype;
                if (x <= skypeList.size()) {
                    skype = (Skype)skypeList.get(x - 1);
                    skype.setSkype(req.getParameter("txtSkype" + x));
                    SkypeController.getInstance().edit(skype);
                } else {
                    skype = new Skype(Integer.valueOf(0), req.getParameter("txtSkype" + x), contact.getIdContact());
                    SkypeController.getInstance().add(skype);
                }
            } else if (x <= skypeList.size()) {
                SkypeController.getInstance().delete(((Skype)skypeList.get(x - 1)).getIdSkype());
            }
            ++x;
        }
    }
}