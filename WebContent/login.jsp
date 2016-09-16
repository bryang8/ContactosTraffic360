<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="assets/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="assets/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="assets/css/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
  	 <div id="imgBack">
  	 </div>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
  <img alt="" src="assets/images/traffic360.png" id="loginLogo">
  
	  <%= (request.getParameter("error")!=null)?request.getParameter("error"):""%>
    <p class="login-box-msg">Ingrese sus credenciales</p>

    <form action="login" method="post">
      <div class="form-group has-feedback">
        <input name="txtUsername" type="text" class="form-control" placeholder="Username">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input name="txtPassword" type="password" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <!-- /.col -->
        <div class="col-md-4 col-sm-4 col-xs-4">
          <button type="submit" id="login-btn"  class="btn btn-primary btn-flat">Login</button>
        </div>
        <!-- /.col -->
        ${error}
      </div>
    </form>
    <!-- /.social-auth-links -->
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

</body>
</html>
