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
import javax.servlet.http.HttpSession;
import org.traffic360.contacts.bean.User;
import org.traffic360.contacts.controller.ContactController;
import org.traffic360.contacts.helpers.IPFilter;

@WebServlet(value={"/home"})
public class FillHome
extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] arrstring = IPFilter.allowedips;
        int n = arrstring.length;
        int n2 = 0;
        while (n2 < n) {
            String ip = arrstring[n2];
            if (req.getRemoteAddr().equals(ip)) {
                req.getSession().invalidate();
                req.getSession().removeAttribute("usuario");
                req.getSession().removeAttribute("nick");
                req.getSession().removeAttribute("rol");
                User.setActual((User)null);
                RequestDispatcher despachador = null;
                req.setAttribute("departmentList", (Object)ContactController.getInstance().departmentsList());
                req.setAttribute("contactList", (Object)ContactController.getInstance().contactList());
                req.setAttribute("phoneList", (Object)ContactController.getInstance().phoneList());
                req.setAttribute("emailList", (Object)ContactController.getInstance().emailList());
                req.setAttribute("skypeList", (Object)ContactController.getInstance().skypeList());
                despachador = req.getRequestDispatcher("default.jsp");
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