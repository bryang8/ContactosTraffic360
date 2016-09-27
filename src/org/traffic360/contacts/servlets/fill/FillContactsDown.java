package org.traffic360.contacts.servlets.fill;

import java.io.IOException;
import java.util.ArrayList;
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
import org.traffic360.contacts.bean.User;
import org.traffic360.contacts.controller.ContactController;
import org.traffic360.contacts.helpers.IPFilter;

@WebServlet(value={"/contacts-down"})
public class FillContactsDown
extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        String[] arrstring = IPFilter.allowedips;
        int n = arrstring.length;
        int n2 = 0;
        while (n2 < n) {
            String ip = arrstring[n2];
            if (req.getRemoteAddr().equals(ip)) {
                ArrayList<Department> list = new ArrayList<Department>();
                List<Department> departmentList = ContactController.getInstance().departmentsList();
                List<Contact> contactList = ContactController.getInstance().contactsDownList();
                for (Contact c : contactList) {
                    for (Department d : departmentList) {
                        if (d.getIdDepartment() != c.getIdDepartment() || list.contains((Object)d)) continue;
                        list.add(d);
                    }
                }
                for (Department d : list) {
                    d.setName(d.getName().toUpperCase());
                }
                if (User.getActual() != null && User.getActual().getRol() == 0) {
                    req.setAttribute("edit-permission", (Object)0);
                }
                req.setAttribute("departmentList", list);
                req.setAttribute("contactList", (Object)contactList);
                req.setAttribute("phoneList", (Object)ContactController.getInstance().phoneList());
                req.setAttribute("emailList", (Object)ContactController.getInstance().emailList());
                req.setAttribute("skypeList", (Object)ContactController.getInstance().skypeList());
                despachador = req.getRequestDispatcher("contactsDown.jsp");
                despachador.forward((ServletRequest)req, (ServletResponse)resp);
                break;
            }
            ++n2;
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}