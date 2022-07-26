

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" src="assets/images/feyale.jpg">

    <title>FE Y ALEGRIA</title>
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="css/colors/blue.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <section id="wrapper" class="login-register login-sidebar" style="background-image:url(assets/images/background/login-register.jpg);">
        <div class="login-box card">
            <div class="card-body">
                
                
                <form role="form" class="form-horizontal" action="SERVLOGIN" method="POST">
                    <a  class="text-center db"><img src="assets/images/feyale.jpg" /><br/></a>
                    <center> <h2>Personal Academico</h2></center>
                    <div class="form-group m-t-40">
                        <div class="col-xs-12">
                            <input class="form-control" name="txtusuario"  type="text" required="" placeholder="Username">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12">
                            <input class="form-control" name="txtcontra" type="password" required="" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="checkbox checkbox-primary pull-left p-t-0">
                                <input id="checkbox-signup" type="checkbox">
                            </div>
                            <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#exampleModal">
                            Recuperar Contrase�a
                        </button>
                             
                        </div> 
                    </div>
                    <div class="form-group text-center m-t-20">
                        <div class="col-xs-12">
                            <button class="btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light" name="btnIniciar" type="submit">Ingresar</button>
                        </div>
                    </div>
                   
                </form>
       
            </div>
      
            </div>
     
        
    </section>
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Recuperar Contrase�a</h5>
                        </div>
                        <div class="modal-body">
                            <!-- 4:3 aspect ratio -->
                            <div class="embed-responsive embed-responsive-4by3">
                                <iframe class="embed-responsive-item" src="RecuperarContrase�a.jsp"></iframe>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-info btm-sm" data-dismiss="modal" onclick= "self.location.href = 'login.jsp'">
                                CANCELAR</button>
                            <!--<button type="button" class="btn btn-primary">Save changes</button>-->
                        </div>
                    </div>
                </div>
            </div>
        <%
        HttpSession sesion =request.getSession();
        String codtipo = "";
        if (request.getAttribute("codtipo")!=null){
            
            codtipo = (String)request.getAttribute("codtipo");
            
            if(codtipo.equals("Administrador") ){
                
                sesion.setAttribute("usuario", request.getAttribute("usuario"));
                sesion.setAttribute("contra", request.getAttribute("contra"));
                sesion.setAttribute("codtipo", codtipo);
                response.sendRedirect("Index.jsp");
                
            } else if(codtipo.equals("Director") ){                
                sesion.setAttribute("usuario", request.getAttribute("usuario"));
                sesion.setAttribute("contra", request.getAttribute("contra"));
                sesion.setAttribute("codtipo", codtipo);
                response.sendRedirect("Index.jsp"); 
                
            }else if (codtipo.equals("Secretaria") ){
                sesion.setAttribute("usuario", request.getAttribute("usuario"));
                sesion.setAttribute("contra", request.getAttribute("contra"));
                sesion.setAttribute("codtipo", codtipo);
                response.sendRedirect("IndexSecre.jsp");   
                
                }
        }
            
        
        if(request.getParameter("Cerrar")!=null){
        session.invalidate();
        response.sendRedirect("login.jsp"); 
        }
        %>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="assets/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="assets/plugins/bootstrap/js/popper.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="js/sidebarmenu.js"></script>
    <!--stickey kit -->
    <script src="assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
    <script src="assets/plugins/sparkline/jquery.sparkline.min.js"></script>
    <!--Custom JavaScript -->
    <script src="js/custom.min.js"></script>
    <!-- ============================================================== -->
    <!-- Style switcher -->
    <!-- ============================================================== -->
    <script src="/assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
</body>

</html>