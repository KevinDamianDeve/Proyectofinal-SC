


<%@page import="Modelo.Apoderado"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="Modelo.Conexion"%>
<%@page import="Modelo.NOTAS"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

HttpSession object= request.getSession(false);
if (object.getAttribute("usu")!=null && object.getAttribute("contra")!=null )
{
    
String usu=(String)object.getAttribute("usu");
String contra=(String)object.getAttribute("contra");

            

%>
<%
Modelo.Apoderado car = new Modelo.Apoderado();
        try {
            Connection con = Modelo.Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(" SELECT idapoderado, nombre, apellidos, email, foto from apoderado  WHERE usuario=? AND clave =?");
            ps.setString(1, usu);
            ps.setString(2, contra);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               
                car.setIdApoderado(rs.getInt(1));
                car.setNombre(rs.getString(2));
                car.setApellidos(rs.getString(3));
                 car.setEmail(rs.getString(4));
                car.setFoto(rs.getString(5));
                
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
    <title>FE Y ALEGRIA</title>
    <!-- Bootstrap Core CSS -->
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- morris CSS -->
    <link href="assets/plugins/morrisjs/morris.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/colors/blue.css" id="theme" rel="stylesheet">
    
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
             
                <div class="navbar-collapse">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav mr-auto mt-md-0">
                        <!-- This is  -->
                        <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="mdi mdi-menu"></i></a> </li>
                        <li class="nav-item m-l-10"> <a class="nav-link sidebartoggler hidden-sm-down text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                     
                    </ul>
                  
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
                                        
                                        </div>
                                    </li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#"><i class="ti-user"></i> <%=car.getNombre()%> <%=car.getApellidos()%>  </a></li>
                                    <li><a href="#"><i class="ti-email"></i> <%=car.getEmail() %></a></li>
                                    <li role="separator" class="divider"></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="SERVLOGINPADRE?cerrar=true"><i class="fa fa-power-off"></i> Salir</a></li>
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
                <%@include file="navegacionPadre.jsp" %>
                <!-- Fin Sidebar navigation -->
            </div>
        
        </aside>
     
        <div class="page-wrapper">
         
            <div class="row page-titles">
                <div class="col-md-5 align-self-center">
                    <h3 class="text-themecolor">Reuniones  </h3>
                </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Inicio</a></li>
                        <li class="breadcrumb-item active">Reuniones </li>
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
           <div class="row">
                    <div class="col-12">
                        <!-- Column -->
                        <div class="card">
                            <div class="card-body">
                  <table id="example23" class="display nowrap table table-hover table-striped table-bordered" 
                                       cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                       <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="persist">COD REUNION</th>
                                        <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="persist">DOCENTE</th>
                                         <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="persist">GRADO</th>
                                        <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="persist">FECHA</th>
                                         <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="persist">DESCRIPCION</th>
                                        <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="persist">ARCHIVO</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            int idalumno = Integer.parseInt(request.getParameter("codal"));
                                                Modelo.ALUMNO a = new Modelo.ALUMNO();
                                                try {
                                                    Connection con = Modelo.Conexion.conectar();
                                                    PreparedStatement ps = con.prepareStatement(" SELECT idgrado  from alumno  WHERE idalumno =?");
                                                    ps.setInt(1, idalumno);
                                                    ResultSet rs = ps.executeQuery();
                                                    if (rs.next()) {

                                                        a.setIdgrado(rs.getInt(1));

                                                        con.close();

                                                    }
                                                } catch (SQLException ex) {

                                                }

                                            int al=a.getIdgrado();

                                            NOTAS v = new NOTAS();
                                            Conexion cn = new Conexion();
                                            DefaultTableModel t = new DefaultTableModel();

                                            t = v.REUNIO( al , cn.conectar());
                                            for (int i = 0; i < t.getRowCount(); i++) {
                                        %>
                                
                                        <tr>
                                            <td class="title"><a class="link" ><%= t.getValueAt(i, 0)%></a></td>
                                            <td class="title"><a class="link"    ><%= t.getValueAt(i, 1)%></a></td>
                                            <td class="title"><a class="link" ><%= t.getValueAt(i, 2)%></a></td>
                                            <td class="title"><a class="link"    ><%= t.getValueAt(i, 3)%></a></td>
                                            <td class="title"><a class="link" ><%= t.getValueAt(i, 4)%></a></td>
                                            <td class="title"><a class="link" href="<%= t.getValueAt(i, 5)%>" target="_blank"   ><%= t.getValueAt(i, 5)%></a></td>

                                        </tr>  
                                         <% } %>                                           
                                    </tbody>
              </table>
                   
                            </div>
                        </div>
                        <!-- Column -->
                    </div>
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

  response.sendRedirect("loginPadre.jsp");
}
 
 %>