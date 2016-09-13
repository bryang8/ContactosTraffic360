<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="assets/images/notebook.png">
    <title>Traffic360 - Contactos</title>
    <link href='assets/img/icon.png' rel='shortcut icon' type='image/png'>
    <!-- <link rel="stylesheet" href="assets/css/estilo.css" > -->
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
    
    <!-- include alertify.css -->
    <link rel="stylesheet" href="assets/css/alertify.min.css" />
    <link rel="stylesheet" href="assets/css/default.min.css" />

    <!-- include boostrap theme  -->
    <link rel="stylesheet" href="assets/css/themes/bootstrap.css">

    <!-- include alertify script -->
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
    <link rel="stylesheet" href="assets/css/skin-blue.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="row">
    <div class="box box-info col-md-10">
      <div class="box-header with-border">
          <h3 class="box-title">EDITAR CONTACTO</h3>
      </div>
	<form action="edit-contact" method="post" class="form-horizontal">
        <div class="row">
	<input type="hidden" value="${contacto.getIdContact()}" name="txtIdContacto">
    <input type="hidden" value="${contacto.getStatus()}" name="txtStatus">
        <div class="col-md-4"> 
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">EMPRESA:</label>
                <div class="col-sm-4">
                    <input type="text" required value="${contacto.getCompany()}"  placeholder="EMPRESA" name="txtEmpresa"><br>
                </div>    
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">DEPARTAMENTO:</label>
                <div class="col-sm-4">
                    <select name="txtDepartamento">
                        <c:forEach items="${departmentList}" var="departament">
                                <option value="${departament.getIdDepartment()}">${departament.getName()}</option>
                        </c:forEach>
                    </select>	
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">ROL:</label>
                <div class="col-sm-4">
                      <input type="text"  required value="${contacto.getRol()}" placeholder="ROL" name="txtRol"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">NOMBRE:</label>
                <div class="col-sm-4">
                      <input type="text"  required value="${contacto.getName()}" placeholder="NOMBRE" name="txtNombre"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">APELLIDO:</label>
                <div class="col-sm-4">
                    <input type="text" required value="${contacto.getLastName()}" placeholder="APELLIDO" name="txtApellido"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">EXTENSION:</label>
                <div class="col-sm-4">
                    <input type="number" value="${contacto.getExtension()}" placeholder="EXTENSION" name="txtExtension"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">ZOIPER:</label>
                <div class="col-sm-4">
                    <input type="number" value="${contacto.getZoiper()}" placeholder="ZOIPER" name="txtZoiper"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">FECHA DE INGRESO:</label>
                <div class="col-sm-4">
                <input type="date" placeholder="FECHA DE INGRESO" value="${contacto.getEnrrollingDate()}" name="txtFechaDeIngreso"><br>
                </div>
            </div>
            </div>
            <div class="col-md-4"> 
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">TELEFONO 1:</label>
                <div class="col-sm-4">
                    <input type="number" value="${numero1}" placeholder="TELEFONO" name="txtTelefono1"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">TELEFONO 2:</label>
                <div class="col-sm-4">
                    <input type="number" value="${numero2}" placeholder="TELEFONO" name="txtTelefono2"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">TELEFONO 3:</label>
                <div class="col-sm-4">
                    <input type="number" value="${numero3}" placeholder="TELEFONO" name="txtTelefono3"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">CORREO 1:</label>
                <div class="col-sm-4">
                    <input type="mail" value="${correo1}" placeholder="CORREO" name="txtCorreo1"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">CORREO 2:</label>
                <div class="col-sm-4">
                    <input type="mail" value="${correo2}" placeholder="CORREO" name="txtCorreo2"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">SKYPE 1:</label>
                <div class="col-sm-4">
                    <input type="text" value="${skype1}" placeholder="SKYPE" name="txtSkype1"><br>
                </div>
            </div>
            <div class="form-group ">
                <label for="inputEmail3" class="col-sm-7 control-label">SKYPE 2:</label>
                <div class="col-sm-4">
                    <input type="text" value="${skype2}" placeholder="SKYPE" name="txtSkype2"><br>
                </div>
            </div>
        </div>                      
       

        </div>
        <div class="row">
          <div class="box-footer">
              <div class="col-md-7">
                  <div class="col-sm-3 pull-right">
                    <button type="submit" class="btn btn-primary pull-left">GUARDAR</button>
                  </div>
                  <a href="/contactosTraffic360/list"><input type="button" class="btn btn-dafault pull-right" value="CANCELAR"/></a>
              </div>
          </div>
        </div>
    </form>
        </div>
    </div>
    
</body>
   
</html>
    
