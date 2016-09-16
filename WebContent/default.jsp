<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ taglib prefix="c"  
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title >Contactos</title>
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
    <!-- iCheck -->
    <link rel="stylesheet" href="assets/css/blue.css">
    <link rel="stylesheet" href="assets/css/loginbox.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
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
	<div class="row">
	<div class="col-md-12">
	  <div class="box" id="container">
		<div class="box-body" style="overflow:auto" >
              <table id="table" class="table table-striped table-responsive">
              <c:forEach items="${departmentList}" var="department">
                <thead>
                    <tr>
                        <th id="department_header">${department.getName()}</th>
                        <th id="header">NOMBRE</th>
                        <th id="header">EMPRESA</th>
                        <th id="header">EXTENSIÓN</th>
                        <th id="header">ZOIPER</th>
                        <th id="header"><i class="fa fa-phone" aria-hidden="true"></i></th>
                        <th id="header"><i class="fa fa-envelope" aria-hidden="true"></i></th>
                        <th id="header"><i class="fa fa-skype" aria-hidden="true"></i></th>
                        <th id="header">INGRESO</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${contactList}" var="contact">
                        
                        <c:if test="${contact.getIdDepartment() == department.getIdDepartment()}">
                           <tr>
                                <td>${contact.getRol()}</td>
                                <td>${contact.getName()} ${contact.getLastName()}</td>                                
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
                                          <a href="skype:${skype.getSkype()}">${skype.getSkype()}</a>
                                          <br/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>${contact.getEnrrollingDate()}</td>
                            </tr>
                        </c:if>
                       
                    </c:forEach>
                    <tr style="height:15px"></tr>
                </tbody>
                </c:forEach>
            </table>
		</div>
	</div>
	
		<br/>
        <br/>
		<div id="header2">PLANTA TELEFONICA</div>          
            <table id="planta-telefonica" class="table table-striped">
              <thead>
                <tr>
                  <th id="cols">Función</th>
                  <th id="cols">Descripción</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td id="tdPlanta">Numero de Planta</td>
                  <td>2444-4747</td>
                </tr>
                <tr>
                  <td id="tdPlanta">Hablar llamadas</td>
                  <td>*41 + número de extensión</td>
                </tr>
                <tr>
                  <td id="tdPlanta">Desvio a celular</td>
                  <td>Transfer + 9 + número de cel. + FWD/DND</td>
                </tr>
                <tr>
                  <td id="tdPlanta">Desvio de la planta</td>
                  <td>*7102 + número de extensión + #</td>
                </tr>
                <tr>
                  <td id="tdPlanta">Conferencia</td>
                  <td>Realizar llamadas + conf. + ext. + conf. </td>
                </tr>
              </tbody>
            </table>
	  </div><!-- /.box -->
	<br>
  </div>
  <footer class="panel-footer">
	<div class="row">
  		<img src="assets/images/traffic360.png" class="img-responsive center-block" alt="Responsive image" width="200">
  	</div>
  	<div class="row">
  		<div class="text-center">
		  <small>*Modificaciones dudas y/o correcciones contactar IT</small>
	 	 </div>
  	</div>
		</footer>


</body>
</html>