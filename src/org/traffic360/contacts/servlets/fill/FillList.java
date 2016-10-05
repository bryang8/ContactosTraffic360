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
import org.traffic360.contacts.bean.Department;
import org.traffic360.contacts.bean.User;
import org.traffic360.contacts.controller.ContactController;
import org.traffic360.contacts.helpers.IPFilter;

@WebServlet("/list")
public class FillList
extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        ArrayList<String> arrstring = IPFilter.allowedips;
        int n = arrstring.size();
        int n2 = 0;
        while (n2 < n) {
            String ip = arrstring.get(n2);
            if (req.getRemoteAddr().equals(ip)) {
                List<Department> list = ContactController.getInstance().departmentsList();
                for (Department d : list) {
                    d.setName(d.getName().toUpperCase());
                }
                if (User.getActual() != null) {
                    req.setAttribute("userRol", (Object)User.getActual().getRol());
                }
                req.setAttribute("departmentList", (Object)list);
                req.setAttribute("contactList", (Object)ContactController.getInstance().contactList());
                req.setAttribute("phoneList", (Object)ContactController.getInstance().phoneList());
                req.setAttribute("emailList", (Object)ContactController.getInstance().emailList());
                req.setAttribute("skypeList", (Object)ContactController.getInstance().skypeList());
                despachador = req.getRequestDispatcher("inicio.jsp");
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