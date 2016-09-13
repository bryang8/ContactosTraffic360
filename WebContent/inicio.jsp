<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Contactos</title>
    <link rel="shortcut icon" href="assets/images/notebook.png">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="assets/css/AdminLTE.min.css">
    <link rel="stylesheet" href="assets/css/dataTables.bootstrap.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="assets/css/blue.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    <body>
      <div id="banner" align="center">
        <h2>PERSONAL CUSTOM SERVICES</h2>
      </div>
        <br>
        <div class="row" >
        <div class="col-xs-18">
          <div class="box" id="container">
          <form action="add-contact" >
              <div id="btnAdd">
                <input class="btn btn-success" type="submit" value="Agregar Contacto">    
              </div>
          </form>
            <div class="box-body" >
              <c:forEach items="${departmentList}" var="department">
                  <table id="table" class="table table-striped">
                    <thead>
                        <tr>
                            <th id="department_header">${department.getName()}</th>
                            <th id="header">NOMBRE</th>
                            <th id="header">APELLIDO</th>
                            <th id="header">EMPRESA</th>
                            <th id="header">EXTENSIÓN</th>
                            <th id="header">ZOIPER</th>
                            <th id="header">TELÉFONO <i class="fa fa-phone" aria-hidden="true"></i></th>
                            <th id="header">EMAIL <i class="fa fa-envelope" aria-hidden="true"></i></th>
                            <th id="header">SKYPE <i class="fa fa-skype" aria-hidden="true"></i></th>
                            <th id="header">FECHA DE INGRESO</th>
                            <th id="header"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${contactList}" var="contact">
                        
                        <c:if test="${contact.getIdDepartment() == department.getIdDepartment()}">
                           <tr>
                                <td>${contact.getRol()}</td>
                                <td>${contact.getName()}</td>
                                <td>${contact.getLastName()}</td>
                                <td>${contact.getCompany()}</td>
                                <td>
                                  <c:if test="${contact.getExtension() != 0}">
                                    ${contact.getExtension()}
                                  </c:if>
                                  <c:if test="${contact.getExtension() == 0}">
                                    ---
                                  </c:if>
                                </td>
                                <td>
                                  <c:if test="${contact.getZoiper() != 0}">
                                       ${contact.getZoiper()}
                                  </c:if>
                                  <c:if test="${contact.getZoiper() == 0}">
                                     ---
                                  </c:if>
                                </td>
                               <td>
                                    <c:forEach items="${phoneList}" var="phone">
                                        <c:if test="${phone.getIdContact() == contact.getIdContact()}">
                                            ${phone.getNumber()} <br/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                               <td>
                                    <c:forEach items="${emailList}" var="email">
                                        <c:if test="${email.getIdContact() == contact.getIdContact()}">
                                            ${email.getEmail()} <br/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                               <td>
                                    <c:forEach items="${skypeList}" var="skype">
                                        <c:if test="${skype.getIdContact() == contact.getIdContact()}">
                                            ${skype.getSkype()} <br/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                ${contact.getEnrrollingDate()}</td>
                                <td>
                                	<div class="col-sm-6">
                                		<form action = "edit-contact-view?idContact=${contact.getIdContact()}"  method= "post">
                                	    	<button type="submit" class="btn btn-warning"><i class="fa fa-edit"></i></button>
                                    	</form>
                                	</div>
                                	<div class="col-sm-6">
	                                	<form action = "delete-contact-confirm?idContact=${contact.getIdContact()}"  method= "post">
	                                	    <button type="submit" class="btn btn-danger pull-left"><i class="fa fa-trash"></i></button>
	                                    </form>
                                    </div>
                                </td>
                            </tr>
                        </c:if>
                        
                    </c:forEach>
                </tbody>
            </table>
            <br/>
            <br/>
                
          </c:forEach>
		</div><!-- /.box-body -->
	  </div><!-- /.box -->
	</div>
  </div>
  <footer class="panel-footer">
	<div class="row">
  		<img src="assets/images/traffic360.png" class="img-responsive center-block" alt="Responsive image" width="200">
  	</div>
  	<div class="row">
  		<div class="text-center">
		  <small>*Modificaciones dudas y/o correcciones contactar IT</small>
		</div>
        <a id="logout" href="home">Cerrar Sesion</a>	
        <a id="add-user" href="add-user" style="margin:10px; float:left;">Agregar Administrador</a>
  	</div>
  	</footer>
</body>
</html>