<%-- 
    Document   : IndexProfe
    Created on : 07-ene-2020, 12:23:10
    Author     : Kevin Damian
--%>


<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="Modelo.Conexion"%>
<%@page import="Modelo.ALUMNO"%>
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
Modelo.DOCENTE car = new Modelo.DOCENTE();
        try {
            Connection con = Modelo.Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(" SELECT iddocente, nombres, apellidos, correo, foto FROM docente WHERE usuario=? AND contraseña =?");
            ps.setString(1, usu);
            ps.setString(2, contra);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               
                car.setIddodocente(rs.getInt(1));
                car.setNombres(rs.getString(2));
                car.setApellidos(rs.getString(3));
                 car.setCorreo(rs.getString(4));
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
                                                <h4>Usuario: <%=usu%> </h4>
                                        
                                        </div>
                                    </li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#"><i class="ti-user"></i> <%=car.getNombres() %> <%=car.getApellidos()%>  </a></li>
                                    <li><a href="#"><i class="ti-email"></i> <%=car.getCorreo() %></a></li>
                                    <li role="separator" class="divider"></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="SERVLOGINDOCENTE?cerrar=true"><i class="fa fa-power-off"></i> Salir</a></li>
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
                <%@include file="navegacionProfe.jsp" %>
                <!-- Fin Sidebar navigation -->
            </div>
        
        </aside>
     
        <div class="page-wrapper">
         <% String grado = request.getParameter("gra");%>
            <div class="row page-titles">
                <div class="col-md-5 align-self-center">
                    <h3 class="text-themecolor">Lista de Estudiantes  de <%=grado%></h3>
                </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a >Inicio</a></li>
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
                <div class="row">
                    <div class="col-12">
                        <!-- Column -->
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Selecciona un alumno para ver el curso</h4>
                  <table id="example23" class="display nowrap table table-hover table-striped table-bordered" 
                                       cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                      <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="persist"> Id Alumno </th>
                                       <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="persist">Alumno</th>
                                       <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="persist">Dni</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                          <% int ca =Integer.parseInt(request.getParameter("cod"));%>
                                        <%
                                            ALUMNO v = new ALUMNO();
                                            Conexion cn = new Conexion();
                                            DefaultTableModel t = new DefaultTableModel();

                                            t = v.ListaAlumnosPorGrado(ca, cn.conectar());
                                            for (int i = 0; i < t.getRowCount(); i++) {
                                        %>
                                
                                        <tr>
                                            <td class="title"><a class="link" ><%= t.getValueAt(i, 0)%></a></td>
                                            <td class="title"><a class="link" href="DetalleNotasProfe.jsp?codgra=<%=ca%>&codal=<%= t.getValueAt(i, 0)%> " ><%= t.getValueAt(i, 1)%></a></td>
                                            <td class="title"><a class="link" ><%= t.getValueAt(i, 2)%></a></td>

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
   <script src="assets/plugins/bootstrap/js/popper.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/jquery.slimscroll.js"></script>
    <script src="js/waves.js"></script>
    <script src="js/sidebarmenu.js"></script>
   <script src="assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
    <script src="assets/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="js/custom.min.js"></script>
        <script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
    
         
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
    <script src="Table/buttons.flash.min.js" type="text/javascript"></script>
    <script src="Table/buttons.html5.min.js" type="text/javascript"></script>
    <script src="Table/buttons.print.min.js" type="text/javascript"></script>
    <script src="Table/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="Table/pdfmake.min.js" type="text/javascript"></script>
    <script src="Table/vfs_fonts.js" type="text/javascript"></script>
           <script src="assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>

      <script>
    $(document).ready(function() {
        $('#myTable').DataTable();
        $(document).ready(function() {
            var table = $('#example').DataTable({
                "columnDefs": [{
                    "visible": false,
                    "targets": 2
                }],
                "order": [
                    [2, 'asc']
                ],
                "displayLength": 25,
                "drawCallback": function(settings) {
                    var api = this.api();
                    var rows = api.rows({
                        page: 'current'
                    }).nodes();
                    var last = null;
                    api.column(2, {
                        page: 'current'
                    }).data().each(function(group, i) {
                        if (last !== group) {
                            $(rows).eq(i).before('<tr class="group"><td colspan="5">' + group + '</td></tr>');
                            last = group;
                        }
                    });
                }
            });
            // Order by the grouping
            $('#example tbody').on('click', 'tr.group', function() {
                var currentOrder = table.order()[0];
                if (currentOrder[0] === 2 && currentOrder[1] === 'asc') {
                    table.order([2, 'desc']).draw();
                } else {
                    table.order([2, 'asc']).draw();
                }
            });
        });
    });
    $('#example23').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    });
    </script>
</body>

</html>
  <% 
 } else {

  response.sendRedirect("loginprofe.jsp");
}
 
 %>