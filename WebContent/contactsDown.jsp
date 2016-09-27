<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/validarSesion.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    	dropdown:hover{
    		color: #ffffff;
    		background: #ffffff;
    	}
    	dropdown-toggle{
    		padding: 5px;
    	}
    </style>
  </head>
	    <nav class="navbar navbar-fixed-top" id="banner">
	    	<div class="container-fluid">
	    		<div class="navbar-header header-size">
	    			<span id="navbar-title">PERSONAL CUSTOM SERVICES</span>
	    			<ul class="nav navbar-nav navbar-right" id="nav-right">	        
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle" id="drop-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=nick %><span class="caret"></span></a>
			          <ul class="dropdown-menu">		          
			            <li><a href="home">cerrar sesion</a></li>
			          </ul>
			        </li>
			     </ul>		
	    		</div>    		
	    	</div>
	    </nav>
        <br>
        <br>
        <br>
        <br>   
         <div class="row" >
        <div class="col-md-12">
          <div class="container-fluid">
          <form action="list" >
              <div id="btnAdd">
              	<input class="btn btn-primary" type="submit" value="Contactos">
              </div>
          </form>
          </div></div></div>
        
        <div class="row" >
        <div class="col-md-12">
          <div class="box" id="container">
          	
            <div class="box-body" style="overflow:auto">
              
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
                            <th id="header" style="min-width:150px;"></th>
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
                                            ${skype.getSkype()} <br/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                ${contact.getEnrrollingDate()}</td>
                                <td>                                	
							   <%										
									Object rol=sesion.getAttribute("rol");
									if(rol.equals(0)){										
										%>	
											<div class="col-md-4 col-xs-4 col-sm-4">												
											    <button type="submit" onClick="confirmSetUp(${contact.getIdContact()})" class="btn btn-info"><i class="fa fa-arrow-up"></i></button>											   	
											</div>
										<%
									}else{
										%>	
											<div class="col-md-12 col-xs-12 col-sm-12">												
											    <button type="submit" onClick="confirmSetUp(${contact.getIdContact()})" class="btn btn-info"><i class="fa fa-arrow-up"></i></button>											   	
											</div>
										<%
									}									
									if(rol.equals(0)){										
										%>	
											<div class="col-md-4 col-xs-4 col-sm-4">
												<form action = "edit-contact-view?idContact=${contact.getIdContact()}"  method= "post">
											    	<button type="submit" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											   	</form>
											</div>
											<div class="col-md-4 col-xs-4 col-sm-4">
										    	<button type="submit" onClick="confirmDelete(${contact.getIdContact()})" class="btn btn-danger pull-left"><i class="fa fa-trash"></i></button>
											</div>
										<%
									}
								%>                                		                        																	
                                </td>
                            </tr>
                        </c:if>                        
                    </c:forEach>
                    <tr style="height:15px"></tr>
                </tbody>
                </c:forEach>
            </table>
            <br/>
            <br/>
                
          
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
        
  	</div>
  	</footer>
  	<script>
		function confirmDelete(idContacto) {		    
		    var dialog = confirm("Desea Eliminar?");
		    if (dialog != true) {
		    	$.get("/contacts-down");
		    } else {		    	
		    	$.get('delete-contact-confirm?idContact='+idContacto+'${contact.getIdContact()}&final=0');
		    	location.reload(true);
		    }		    
		}
		
		function confirmSetUp(idContacto) {		    
		    var dialog = confirm("Desea Restablecer?");
		    if (dialog != true) {
		    	$.get("/contacts-down");
		    } else {		    	
		    	$.get('delete-contact-confirm?idContact='+idContacto+'${contact.getIdContact()}&final=1');
		    	location.reload(true);
		    }		    
		}
	</script>
</body>
</html>