<%-- 
    Document   : IndexSecre
    Created on : 28-dic-2019, 22:47:08
    Author     : Kevin Damian
--%><%@page import="java.sql.SQLException"%>


<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%

HttpSession object= request.getSession(false);
if (object.getAttribute("usuario")!=null && object.getAttribute("contra")!=null )
{
    
String usu=(String)object.getAttribute("usuario");
String contra=(String)object.getAttribute("contra");
String codtipo=(String)object.getAttribute("codtipo");

            

%>
<%
Modelo.USUARIO car = new Modelo.USUARIO();
        try {
            Connection con = Modelo.Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("  SELECT  u.nombre, u.apellidos, u.email, u.foto FROM usuario u  INNER JOIN cargo c ON u.idcargo=c.idcargo WHERE u.usuario=? AND u.clave=?  AND c.descripcion=? ");
            ps.setString(1, usu);
            ps.setString(2, contra);
            ps.setString(3, codtipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               
                car.setNombres(rs.getString(1));
                car.setApellidos(rs.getString(2));
                 car.setEmail(rs.getString(3));
                car.setFoto(rs.getString(4));
                
                con.close();

            }
        } catch (SQLException ex) {

        }
        %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
        <title>FE Y ALEGRIA</title>
        <!-- Bootstrap Core CSS -->
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Bootstrap responsive table CSS -->
        <link href="assets/plugins/tablesaw-master/dist/tablesaw.css" rel="stylesheet">
        <!-- Custom CSS -->
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

    <body class="fix-header fix-sidebar card-no-border">
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
        <div id="main-wrapper">
            <!-- ============================================================== -->
            <!-- Topbar header - style you can find in pages.scss -->
            <!-- ============================================================== -->
            <header class="topbar">
                <nav class="navbar top-navbar navbar-expand-md navbar-light">
               
                    <!-- ============================================================== -->
                    <!-- End Logo -->
                    <!-- ============================================================== -->
                    <div class="navbar-collapse">
                        <!-- ============================================================== -->
                        <!-- toggle and nav items -->
                        <!-- ============================================================== -->
                        <ul class="navbar-nav mr-auto mt-md-0">
                            <!-- This is  -->
                            <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="mdi mdi-menu"></i></a> </li>
                            <li class="nav-item m-l-10"> <a class="nav-link sidebartoggler hidden-sm-down text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                          
                            
                        </ul>
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                        <ul class="navbar-nav my-lg-0">
                        
                           <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="<%=car.getFoto() %>" alt="user" class="profile-pic" /></a>
                            <div class="dropdown-menu dropdown-menu-right scale-up">
                                <ul class="dropdown-user">
                                    <li>
                                        <div class="dw-user-box">
                                            <div class="u-img"><img src="<%=car.getFoto() %>"  alt="user"  height="60" width="50"></div>
                                          
                                            <div class="u-text">
                                                <h4> Usuario: <%=usu%> </h4>
                                                <h4> Tipo: <%=codtipo%> </h4>
                                        </div>
                                    </li>
                                    <li role="separator" class="divider"></li>
                                    <li><a ><i class="ti-user"></i> <%=car.getNombres() %>    <%=car.getApellidos()%> </a></li>
                                    <li><a href=""><i class="ti-email"></i> <%=car.getEmail()%></a></li>
                                    <li role="separator" class="divider"></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="login.jsp?Cerrar=true"><i class="fa fa-power-off"></i> Salir</a></li>
                                </ul>
                            </div>
                        </li>
                        </ul>
                    </div>
                </nav>
            </header>
    
        <aside class="left-sidebar">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- User profile -->
                <div class="user-profile">
                    <!-- User profile image -->
                    <div class="profile-img"> <img src="assets/images/feyale.jpg"  alt="user"  height="60" width="50" />
                        <!-- this is blinking heartbit-->
                        <div class="notify setpos"> <span class="heartbit"></span> <span class="point"></span> </div>
                    </div>
               
                </div>
                <!-- End User profile text-->
                <!-- Inicio Sidebar navigation -->
                <%@include file="navegacionSecre.jsp" %>
                <!-- Fin Sidebar navigation -->
            </div>
        
        </aside>
     
        <div class="page-wrapper">
         
            <div class="row page-titles">
                <div class="col-md-5 align-self-center">
                    <h3 class="text-themecolor">TABLERO</h3>
                </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Inicio</a></li>
                        <li class="breadcrumb-item active">Tablero </li>
                    </ol>
                </div>
                <div>
                    <button class="right-side-toggle waves-effect waves-light btn-inverse btn btn-circle btn-sm pull-right m-l-10"><i class="ti-settings text-white"></i></button>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
             
                <!-- Row -->
         
                <!-- Row -->
                <!-- Row -->
           
                <!-- Row -->
                <div class="row">
                    <!-- Column -->
                    <div class="col-lg-3">
                        <div class="card card-inverse card-success">
                            <div class="card-body">
                                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                                    <!-- Carousel items -->
                                    <div class="carousel-inner">
                                        <div class="carousel-item flex-column carousel-item-next carousel-item-left">
                                            
                                            <%

                                                Connection con = Modelo.Conexion.conectar();

                                                try {
                                                    PreparedStatement ps = con.prepareStatement("SELECT COUNT(idAlumno) FROM alumno WHERE estado='NO MATRICULADO' ");
                                                    ResultSet rs = ps.executeQuery();

                                                    while (rs.next()) {


                                            %>
                                            <p class="text-white"></p>
                                            <h2 class="text-white font-light"><%=rs.getInt(1)%><span class="font-bold"> </span><br>
                                                <%

                                                        }
                                                    } catch (Exception e) {
                                                    }

                                                %>
                                      </h2>
                                            <div class="text-white m-t-10">
                                                <i>  <h6 class="text-white font-light">ALUMNOS INSCRITOS<span class="font-bold"> </span><br></h6></i>

                                            </div>
                                        </div>
                                        
                                        <div class="carousel-item flex-column active carousel-item-left">
                                            <i class="fa fa-facebook fa-2x text-white"></i>
                                            <p class="text-white"></p>
                                            <h3 class="text-white font-light"> <span class="font-bold"></span><br>
                                      </h3>
                                            <div class="text-white m-t-20">
                                                <i></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                    <!-- Column -->
                          <div class="col-lg-3">
                        <div class="card card-inverse card-danger">
                            <div class="card-body">
                                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                                    <!-- Carousel items -->
                                    <div class="carousel-inner">
                                        <div class="carousel-item flex-column carousel-item-next carousel-item-left">
                                            
                                            <%


                                                try {
                                                    PreparedStatement ps = con.prepareStatement(" SELECT COUNT(idAlumno) FROM alumno WHERE estado='MATRICULADO'");
                                                    ResultSet rs = ps.executeQuery();

                                                    while (rs.next()) {


                                            %>
                                            <p class="text-white"></p>
                                            <h2 class="text-white font-light"><%=rs.getInt(1)%><span class="font-bold"> </span><br>
                                                <%

                                                        }
                                                    } catch (Exception e) {
                                                    }

                                                %>
                                      </h2>
                                            <div class="text-white m-t-10">
                                                <i>  <h6 class="text-white font-light">ALUMNOS MATRICULADOS<span class="font-bold"> </span><br></h6></i>

                                            </div>
                                        </div>
                                        
                                        <div class="carousel-item flex-column active carousel-item-left">
                                            <i class="fa fa-facebook fa-2x text-white"></i>
                                            <p class="text-white"></p>
                                            <h3 class="text-white font-light"> <span class="font-bold"></span><br>
                                      </h3>
                                            <div class="text-white m-t-20">
                                                <i></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                 
                    <!-- Column -->
                </div>
              
         
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Right sidebar -->
                <!-- ============================================================== -->
                <!-- .right-sidebar -->
                 <%@include file="panelcolor.jsp" %>
                <!-- ============================================================== -->
                <!-- End Right sidebar -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
               <%@include file="footer.jsp" %>
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
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
    <!--Custom JavaScript -->
    <script src="js/custom.min.js"></script>
    <!-- ============================================================== -->
    <!-- This page plugins -->
    <!-- ============================================================== -->
    <!--sparkline JavaScript -->
    <script src="assets/plugins/sparkline/jquery.sparkline.min.js"></script>
    <!--morris JavaScript -->
    <script src="assets/plugins/raphael/raphael-min.js"></script>
    <script src="assets/plugins/morrisjs/morris.min.js"></script>
    <!-- Chart JS -->
    <script src="js/dashboard1.js"></script>
    <!-- ============================================================== -->
    <!-- Style switcher -->
    <!-- ============================================================== -->
    <script src="assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
</body>

</html>
  <% 
 } else {

  response.sendRedirect("login.jsp");
}
 
 %>