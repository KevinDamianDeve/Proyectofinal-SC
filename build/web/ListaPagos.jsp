<%-- 
    Document   : ListaPagos
    Created on : 11-dic-2019, 10:36:13
    Author     : Jeampier
--%>

<%@page import="java.sql.*"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="Modelo.Conexion"%>
<%@page import="Modelo.PAGO"%>
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
            <!-- ============================================================== -->
            <!-- End Topbar header -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Left Sidebar - style you can find in sidebar.scss  -->
            <!-- ============================================================== -->
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
                    <%@include file="navegacion.jsp" %>
                    <!-- Fin Sidebar navigation -->
                </div>
                <!-- End Sidebar scroll-->
            </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
              <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="row page-titles">
                <div class="col-md-5 align-self-center">
                    <h3 class="text-themecolor">Lista de Pagos</h3>
                </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="Index.jsp">Inicio</a></li>
                        <!--<li class="breadcrumb-item">pages</li>-->
                        <li class="breadcrumb-item active">Lista de Pagos</li>
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
                                <h4 class="card-title">Lista de Pagos</h4>
                                <h5 class="card-subtitle">Selecciona la fecha para mas detalles.</h5>
                                  
                                <tr>
                                    <td colspan="2">
                                        <h3><font color="red">
                                            <%=request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : ""%>
                                            </font></h3>
                                    </td>
                                </tr>
                                <table id="example23" class="display nowrap table table-hover table-striped table-bordered" 
                                       cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                          <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="persist">FECHA</th>
                                            <th scope="col" data-tablesaw-sortable-col data-tablesaw-sortable-default-col data-tablesaw-priority="3">ALUMNO</th>
                                            <th scope="col" data-tablesaw-sortable-col data-tablesaw-priority="0">MONTO</th>
                                        </tr>
                                    </thead>
                                    <!--<tbody>
                                        <%
                                            PAGO v = new PAGO();
                                            Conexion cn = new Conexion();
                                            DefaultTableModel t = new DefaultTableModel();

                                            t = v.ListapAGOS(cn.conectar());
                                            for (int i = 0; i < t.getRowCount(); i++) {
                                        %>
                                        <tr>
                                            <td class="title"><a class="link" href="javascript:void(0)"><%= t.getValueAt(i, 0) %></a></td>
                                             <td class="title"><a class="link" href="javascript:void(0)"><%= t.getValueAt(i, 1) %></a></td>
                                    
                                             <td class="title"><a class="link" href="javascript:void(0)"><%= t.getValueAt(i, 2) %></a></td>
                                        </tr>  
                                         <% } %>                                           
                                    </tbody>-->
                                         <tbody>
                                             <% for(Modelo.PAGO a : PAGO.ListaPago()) { %>
                                             <tr>
                                                 <td class="title"><a class="link" href="DetallesPago.jsp?cod=<%= a.getIdpago()%>"><%= a.getFechapago()%></a></td>
                                             <td><%= a.getNombre()%></td>
                                                 <td><%= a.getMonto()%></td>
                                             </tr>
                                             <% }%>
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
                <%@include file="panelcolor.jsp" %>
                
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
    
    <script src="assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
</body>

</html>
<% 
 } else {

  response.sendRedirect("login.jsp");
}
 
 %>