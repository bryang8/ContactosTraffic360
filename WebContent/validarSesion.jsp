<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	HttpSession sesion=request.getSession();
	Object user=sesion.getAttribute("usuario");
	Object nick = sesion.getAttribute("nick");
	if(user!=null){
		//response.sendRedirect("default.jsp"); //para evitar el bucle de redireccion
	}else{
		%>
		<jsp:forward page="/login.jsp" >
			<jsp:param name="error" value="Para Acceder al Sistema, por favor Inicie Sesión."/>
		</jsp:forward>
		<%
	}
%>