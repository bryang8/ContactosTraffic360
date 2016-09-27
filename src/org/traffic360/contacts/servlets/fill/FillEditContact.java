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
import org.traffic360.contacts.bean.Contact;
import org.traffic360.contacts.bean.Department;
import org.traffic360.contacts.bean.Email;
import org.traffic360.contacts.bean.Phone;
import org.traffic360.contacts.bean.Skype;
import org.traffic360.contacts.controller.ContactController;
import org.traffic360.contacts.controller.EmailController;
import org.traffic360.contacts.controller.PhoneController;
import org.traffic360.contacts.controller.SkypeController;

@WebServlet(value={"/edit-contact-view"})
public class FillEditContact
extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        Contact contact = ContactController.getInstance().search(Integer.valueOf(Integer.parseInt(req.getParameter("idContact"))));
        req.setAttribute("contacto", (Object)contact);
        List<Phone> phoneList = PhoneController.getInstance().phoneList(contact.getIdContact());
        List<Email> emailList = EmailController.getInstance().emailList(contact.getIdContact());
        List<Skype> skypeList = SkypeController.getInstance().skypeList(contact.getIdContact());
        int i = 1;
        for (Phone p : phoneList) {
            req.setAttribute("numero" + i, (Object)p.getNumber());
            ++i;
        }
        i = 1;
        for (Email e : emailList) {
            req.setAttribute("correo" + i, (Object)e.getEmail());
            ++i;
        }
        i = 1;
        for (Skype s : skypeList) {
            req.setAttribute("skype" + i, (Object)s.getSkype());
            ++i;
        }
        List<Department> list = ContactController.getInstance().departmentsList();
        int x = 0;
        for (Department d : list) {
            if (d.getIdDepartment() == contact.getIdDepartment()) {
                list.set(x, (Department)list.get(0));
                list.set(0, d);
            }
            ++x;
        }
        req.setAttribute("departmentList", (Object)list);
        despachador = req.getRequestDispatcher("editContact.jsp");
        despachador.forward((ServletRequest)req, (ServletResponse)resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}