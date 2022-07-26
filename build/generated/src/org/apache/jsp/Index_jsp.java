package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/navegacion.jsp");
    _jspx_dependants.add("/panelcolor.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");


HttpSession object= request.getSession(false);
if (object.getAttribute("usuario")!=null && object.getAttribute("contra")!=null )
{
    
String usu=(String)object.getAttribute("usuario");
String contra=(String)object.getAttribute("contra");
String codtipo=(String)object.getAttribute("codtipo");

            


      out.write('\n');

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
        
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <!-- Favicon icon -->\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/images/favicon.png\">\n");
      out.write("        <title>FE Y ALEGRIA</title>\n");
      out.write("        <!-- Bootstrap Core CSS -->\n");
      out.write("        <link href=\"assets/plugins/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Bootstrap responsive table CSS -->\n");
      out.write("        <link href=\"assets/plugins/tablesaw-master/dist/tablesaw.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- You can change the theme colors from here -->\n");
      out.write("        <link href=\"css/colors/blue.css\" id=\"theme\" rel=\"stylesheet\">\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"fix-header fix-sidebar card-no-border\">\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- Preloader - style you can find in spinners.css -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <div class=\"preloader\">\n");
      out.write("            <svg class=\"circular\" viewBox=\"25 25 50 50\">\n");
      out.write("            <circle class=\"path\" cx=\"50\" cy=\"50\" r=\"20\" fill=\"none\" stroke-width=\"2\" stroke-miterlimit=\"10\" /> </svg>\n");
      out.write("        </div>\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- Main wrapper - style you can find in pages.scss -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <div id=\"main-wrapper\">\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- Topbar header - style you can find in pages.scss -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <header class=\"topbar\">\n");
      out.write("                <nav class=\"navbar top-navbar navbar-expand-md navbar-light\">\n");
      out.write("               \n");
      out.write("                    <!-- ============================================================== -->\n");
      out.write("                    <!-- End Logo -->\n");
      out.write("                    <!-- ============================================================== -->\n");
      out.write("                    <div class=\"navbar-collapse\">\n");
      out.write("                        <!-- ============================================================== -->\n");
      out.write("                        <!-- toggle and nav items -->\n");
      out.write("                        <!-- ============================================================== -->\n");
      out.write("                        <ul class=\"navbar-nav mr-auto mt-md-0\">\n");
      out.write("                            <!-- This is  -->\n");
      out.write("                            <li class=\"nav-item\"> <a class=\"nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark\" href=\"javascript:void(0)\"><i class=\"mdi mdi-menu\"></i></a> </li>\n");
      out.write("                            <li class=\"nav-item m-l-10\"> <a class=\"nav-link sidebartoggler hidden-sm-down text-muted waves-effect waves-dark\" href=\"javascript:void(0)\"><i class=\"ti-menu\"></i></a> </li>\n");
      out.write("                          \n");
      out.write("                            \n");
      out.write("                        </ul>\n");
      out.write("                        <!-- ============================================================== -->\n");
      out.write("                        <!-- User profile and search -->\n");
      out.write("                        <!-- ============================================================== -->\n");
      out.write("                        <ul class=\"navbar-nav my-lg-0\">\n");
      out.write("                        \n");
      out.write("                           <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle text-muted waves-effect waves-dark\" href=\"\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"><img src=\"");
      out.print(car.getFoto() );
      out.write("\" alt=\"user\" class=\"profile-pic\" /></a>\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-right scale-up\">\n");
      out.write("                                <ul class=\"dropdown-user\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <div class=\"dw-user-box\">\n");
      out.write("                                            <div class=\"u-img\"><img src=\"");
      out.print(car.getFoto() );
      out.write("\"  alt=\"user\"  height=\"60\" width=\"50\"></div>\n");
      out.write("                                          \n");
      out.write("                                            <div class=\"u-text\">\n");
      out.write("                                                <h4> Usuario: ");
      out.print(usu);
      out.write(" </h4>\n");
      out.write("                                                <h4> Tipo: ");
      out.print(codtipo);
      out.write(" </h4>\n");
      out.write("                                        </div>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li role=\"separator\" class=\"divider\"></li>\n");
      out.write("                                    <li><a ><i class=\"ti-user\"></i> ");
      out.print(car.getNombres() );
      out.write("    ");
      out.print(car.getApellidos());
      out.write(" </a></li>\n");
      out.write("                                    <li><a href=\"\"><i class=\"ti-email\"></i> ");
      out.print(car.getEmail());
      out.write("</a></li>\n");
      out.write("                                    <li role=\"separator\" class=\"divider\"></li>\n");
      out.write("                                    <li role=\"separator\" class=\"divider\"></li>\n");
      out.write("                                    <li><a href=\"login.jsp?Cerrar=true\"><i class=\"fa fa-power-off\"></i> Salir</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </header>\n");
      out.write("    \n");
      out.write("        <aside class=\"left-sidebar\">\n");
      out.write("            <!-- Sidebar scroll-->\n");
      out.write("            <div class=\"scroll-sidebar\">\n");
      out.write("                <!-- User profile -->\n");
      out.write("                <div class=\"user-profile\">\n");
      out.write("                    <!-- User profile image -->\n");
      out.write("                    <div class=\"profile-img\"> <img src=\"assets/images/feyale.jpg\"  alt=\"user\"  height=\"60\" width=\"50\" />\n");
      out.write("                        <!-- this is blinking heartbit-->\n");
      out.write("                        <div class=\"notify setpos\"> <span class=\"heartbit\"></span> <span class=\"point\"></span> </div>\n");
      out.write("                    </div>\n");
      out.write("               \n");
      out.write("                </div>\n");
      out.write("                <!-- End User profile text-->\n");
      out.write("                <!-- Inicio Sidebar navigation -->\n");
      out.write("                ");
      out.write("<!-- Sidebar navigation-->\n");
      out.write("                <nav class=\"sidebar-nav\">\n");
      out.write("                    <ul id=\"sidebarnav\">\n");
      out.write("                        <li class=\"nav-devider\"></li>\n");
      out.write("                        <li class=\"nav-small-cap\">Personal</li>\n");
      out.write("                        <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-gauge\"></i><span class=\"hide-menu\">Panel Control \n");
      out.write("                                    <span class=\"label label-rouded label-themecolor pull-right\">4</span></span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                <li><a href=\"Index.jsp\">Inicio </a></li>\n");
      out.write("                                <!--<li><a href=\"index2.html\">Analytical</a></li>\n");
      out.write("                                <li><a href=\"index3.html\">Demographical</a></li>\n");
      out.write("                                <li><a href=\"index4.html\">Modern</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">Apoderado</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                <li><a href=\"ListaPadres.jsp\">Lista de Padres</a></li>\n");
      out.write("                                <li><a href=\"NuevoPadre.jsp\">Nuevo Padre</a></li>\n");
      out.write("                                <!--<li><a href=\"app-ticket.html\">Support Ticket</a></li>\n");
      out.write("                                <li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">Estudiantes</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                 <li><a href=\"ListaEstudiantes.jsp\">Lista de Estudiantes</a></li>\n");
      out.write("                                 <li><a href=\"NuevoEstudiante.jsp\">Nuevo Estudiante</a></li>\n");
      out.write("                                <li><a href=\"ListaEstudiantesNoMatriculados.jsp\">Inscritos</a></li>\n");
      out.write("                               \n");
      out.write("                                <!--<li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                         <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">GRADOS</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                 <li><a href=\"ListaGrado.jsp\">Lista de Grados</a></li>\n");
      out.write("                                 <li><a href=\"NuevoGrado.jsp\">Agregar Grados</a></li>\n");
      out.write("                                <!--<li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                           <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">CARGOS</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                 <li><a href=\"ListaCargo.jsp\">Lista de Cargos</a></li>\n");
      out.write("                                 <li><a href=\"NuevoCargo.jsp\">Agregar Cargos</a></li>\n");
      out.write("                                <!--<li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                         <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">USUARIOS</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                 <li><a href=\"ListaUsuarios.jsp\">Lista de Usuarios</a></li>\n");
      out.write("                                 <li><a href=\"NuevoUsuario.jsp\">Agregar Usuarios</a></li>\n");
      out.write("                                <!--<li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">PAGOS</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                 <li><a href=\"ListaPagos.jsp\">Lista de Pagos</a></li>\n");
      out.write("                                 <li><a href=\"NuevoPago.jsp\">Agregar Pago</a></li>\n");
      out.write("                                <!--<li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                         <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">PERIODOS</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                 <li><a href=\"ListaPeriodos.jsp\">Lista de Periodos</a></li>\n");
      out.write("                                 <li><a href=\"NuevoPeriodo.jsp\">Agregar Periodo</a></li>\n");
      out.write("                                <!--<li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                     <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">MATRICULA</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                 <li><a href=\"ListaMatriculas.jsp\">Lista de Matricula</a></li>\n");
      out.write("                                 <li><a href=\"NuevaMatricula.jsp\">Agregar Matricula</a></li>\n");
      out.write("                                <!--<li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                      \n");
      out.write("                        <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">DOCENTE</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                <li><a href=\"ListaDocente.jsp\">Lista de Docentes</a></li>\n");
      out.write("                                <li><a href=\"NuevoDocente.jsp\">Agregar Docente</a></li>\n");
      out.write("                                <!--<li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                         <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">CURSOS</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                <li><a href=\"Listacurso.jsp\">Lista de Cursos</a></li>\n");
      out.write("                                <li><a href=\"Nuevocurso.jsp\">Agregar Curso</a></li>\n");
      out.write("                                <!--<li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">TRIMESTRE</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                <li><a href=\"Listatrimestre.jsp\">Lista de Trimestres</a></li>\n");
      out.write("                                <li><a href=\"NuevoTrimestre.jsp\">Agregar Trimestre</a></li>\n");
      out.write("                                <!--<li><a href=\"app-contact.html\">Contact / Employee</a></li>\n");
      out.write("                                <li><a href=\"app-contact2.html\">Contact Grid</a></li>\n");
      out.write("                                <li><a href=\"app-contact-detail.html\">Contact Detail</a></li>-->\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">CURSOS DEL DOCENTE</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                <li><a href=\"Listacursosdocente.jsp\">Cursos del Docente</a></li>\n");
      out.write("                                <li><a href=\"Nuevocursodocente.jsp\">Agregar Cursos Al Docente</a></li>\n");
      out.write("                                <li><a href=\"ListaGradoDocente.jsp\">Buscar</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li> <a class=\"has-arrow waves-effect waves-dark\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"mdi mdi-bullseye\"></i><span class=\"hide-menu\">NOTAS</span></a>\n");
      out.write("                            <ul aria-expanded=\"false\" class=\"collapse\">\n");
      out.write("                                <li><a href=\"Listanotas.jsp\">Lista de Notas</a></li>\n");
      out.write("                                <li><a href=\"NotaSeleccionaGrado.jsp\">Nueva Nota</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("                <!-- End Sidebar navigation -->");
      out.write("\n");
      out.write("                <!-- Fin Sidebar navigation -->\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("        </aside>\n");
      out.write("     \n");
      out.write("        <div class=\"page-wrapper\">\n");
      out.write("         \n");
      out.write("            <div class=\"row page-titles\">\n");
      out.write("                <div class=\"col-md-5 align-self-center\">\n");
      out.write("                    <h3 class=\"text-themecolor\">TABLERO</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-7 align-self-center\">\n");
      out.write("                    <ol class=\"breadcrumb\">\n");
      out.write("                        <li class=\"breadcrumb-item\"><a href=\"javascript:void(0)\">Inicio</a></li>\n");
      out.write("                        <li class=\"breadcrumb-item active\">Tablero </li>\n");
      out.write("                    </ol>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <button class=\"right-side-toggle waves-effect waves-light btn-inverse btn btn-circle btn-sm pull-right m-l-10\"><i class=\"ti-settings text-white\"></i></button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- End Bread crumb and right sidebar toggle -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- Container fluid  -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <!-- ============================================================== -->\n");
      out.write("                <!-- Start Page Content -->\n");
      out.write("                <!-- ============================================================== -->\n");
      out.write("                <!-- Row -->\n");
      out.write("             \n");
      out.write("                <!-- Row -->\n");
      out.write("         \n");
      out.write("                <!-- Row -->\n");
      out.write("                <!-- Row -->\n");
      out.write("           \n");
      out.write("                <!-- Row -->\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <!-- Column -->\n");
      out.write("                    <div class=\"col-lg-3\">\n");
      out.write("                        <div class=\"card card-inverse card-success\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                                    <!-- Carousel items -->\n");
      out.write("                                    <div class=\"carousel-inner\">\n");
      out.write("                                        <div class=\"carousel-item flex-column carousel-item-next carousel-item-left\">\n");
      out.write("                                            \n");
      out.write("                                            ");


                                                Connection con = Modelo.Conexion.conectar();

                                                try {
                                                    PreparedStatement ps = con.prepareStatement("SELECT COUNT(idAlumno) FROM alumno WHERE estado='NO MATRICULADO' ");
                                                    ResultSet rs = ps.executeQuery();

                                                    while (rs.next()) {


                                            
      out.write("\n");
      out.write("                                            <p class=\"text-white\"></p>\n");
      out.write("                                            <h2 class=\"text-white font-light\">");
      out.print(rs.getInt(1));
      out.write("<span class=\"font-bold\"> </span><br>\n");
      out.write("                                                ");


                                                        }
                                                    } catch (Exception e) {
                                                    }

                                                
      out.write("\n");
      out.write("                                      </h2>\n");
      out.write("                                            <div class=\"text-white m-t-10\">\n");
      out.write("                                                <i>  <h6 class=\"text-white font-light\">ALUMNOS INSCRITOS<span class=\"font-bold\"> </span><br></h6></i>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        \n");
      out.write("                                        <div class=\"carousel-item flex-column active carousel-item-left\">\n");
      out.write("                                            <i class=\"fa fa-facebook fa-2x text-white\"></i>\n");
      out.write("                                            <p class=\"text-white\"></p>\n");
      out.write("                                            <h3 class=\"text-white font-light\"> <span class=\"font-bold\"></span><br>\n");
      out.write("                                      </h3>\n");
      out.write("                                            <div class=\"text-white m-t-20\">\n");
      out.write("                                                <i></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Column -->\n");
      out.write("                    <!-- Column -->\n");
      out.write("                          <div class=\"col-lg-3\">\n");
      out.write("                        <div class=\"card card-inverse card-danger\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                                    <!-- Carousel items -->\n");
      out.write("                                    <div class=\"carousel-inner\">\n");
      out.write("                                        <div class=\"carousel-item flex-column carousel-item-next carousel-item-left\">\n");
      out.write("                                            \n");
      out.write("                                            ");



                                                try {
                                                    PreparedStatement ps = con.prepareStatement(" SELECT COUNT(idAlumno) FROM alumno WHERE estado='MATRICULADO'");
                                                    ResultSet rs = ps.executeQuery();

                                                    while (rs.next()) {


                                            
      out.write("\n");
      out.write("                                            <p class=\"text-white\"></p>\n");
      out.write("                                            <h2 class=\"text-white font-light\">");
      out.print(rs.getInt(1));
      out.write("<span class=\"font-bold\"> </span><br>\n");
      out.write("                                                ");


                                                        }
                                                    } catch (Exception e) {
                                                    }

                                                
      out.write("\n");
      out.write("                                      </h2>\n");
      out.write("                                            <div class=\"text-white m-t-10\">\n");
      out.write("                                                <i>  <h6 class=\"text-white font-light\">ALUMNOS MATRICULADOS<span class=\"font-bold\"> </span><br></h6></i>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        \n");
      out.write("                                        <div class=\"carousel-item flex-column active carousel-item-left\">\n");
      out.write("                                            <i class=\"fa fa-facebook fa-2x text-white\"></i>\n");
      out.write("                                            <p class=\"text-white\"></p>\n");
      out.write("                                            <h3 class=\"text-white font-light\"> <span class=\"font-bold\"></span><br>\n");
      out.write("                                      </h3>\n");
      out.write("                                            <div class=\"text-white m-t-20\">\n");
      out.write("                                                <i></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Column -->\n");
      out.write("                    <!-- Column -->\n");
      out.write("                       <div class=\"col-lg-3\">\n");
      out.write("                        <div class=\"card card-inverse card-info\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                                    <!-- Carousel items -->\n");
      out.write("                                    <div class=\"carousel-inner\">\n");
      out.write("                                        <div class=\"carousel-item flex-column carousel-item-next carousel-item-left\">\n");
      out.write("                                            \n");
      out.write("                                            ");



                                                try {
                                                    PreparedStatement ps = con.prepareStatement("SELECT COUNT(iddocente)FROM docente ");
                                                    ResultSet rs = ps.executeQuery();

                                                    while (rs.next()) {


                                            
      out.write("\n");
      out.write("                                            <p class=\"text-white\"></p>\n");
      out.write("                                            <h2 class=\"text-white font-light\">");
      out.print(rs.getInt(1));
      out.write("<span class=\"font-bold\"> </span><br>\n");
      out.write("                                                ");


                                                        }
                                                    } catch (Exception e) {
                                                    }

                                                
      out.write("\n");
      out.write("                                      </h2>\n");
      out.write("                                            <div class=\"text-white m-t-10\">\n");
      out.write("                                                <i>  <h6 class=\"text-white font-light\">DOCENTES<span class=\"font-bold\"> </span><br></h6></i>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        \n");
      out.write("                                        <div class=\"carousel-item flex-column active carousel-item-left\">\n");
      out.write("                                            <i class=\"fa fa-facebook fa-2x text-white\"></i>\n");
      out.write("                                            <p class=\"text-white\"></p>\n");
      out.write("                                            <h3 class=\"text-white font-light\"> <span class=\"font-bold\"></span><br>\n");
      out.write("                                      </h3>\n");
      out.write("                                            <div class=\"text-white m-t-20\">\n");
      out.write("                                                <i></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Column -->\n");
      out.write("                </div>\n");
      out.write("              \n");
      out.write("         \n");
      out.write("                <!-- ============================================================== -->\n");
      out.write("                <!-- End PAge Content -->\n");
      out.write("                <!-- ============================================================== -->\n");
      out.write("                <!-- ============================================================== -->\n");
      out.write("                <!-- Right sidebar -->\n");
      out.write("                <!-- ============================================================== -->\n");
      out.write("                <!-- .right-sidebar -->\n");
      out.write("                 ");
      out.write("<div class=\"right-sidebar\">\n");
      out.write("                    <div class=\"slimscrollright\">\n");
      out.write("                        <div class=\"rpanel-title\"> Service Panel <span><i class=\"ti-close right-side-toggle\"></i></span> </div>\n");
      out.write("                        <div class=\"r-panel-body\">\n");
      out.write("                            <ul id=\"themecolors\" class=\"m-t-20\">\n");
      out.write("                                <li><b>With Light sidebar</b></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"default\" class=\"default-theme\">1</a></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"green\" class=\"green-theme\">2</a></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"red\" class=\"red-theme\">3</a></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"blue\" class=\"blue-theme working\">4</a></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"purple\" class=\"purple-theme\">5</a></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"megna\" class=\"megna-theme\">6</a></li>\n");
      out.write("                                <li class=\"d-block m-t-30\"><b>With Dark sidebar</b></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"default-dark\" class=\"default-dark-theme\">7</a></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"green-dark\" class=\"green-dark-theme\">8</a></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"red-dark\" class=\"red-dark-theme\">9</a></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"blue-dark\" class=\"blue-dark-theme\">10</a></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"purple-dark\" class=\"purple-dark-theme\">11</a></li>\n");
      out.write("                                <li><a href=\"javascript:void(0)\" data-theme=\"megna-dark\" class=\"megna-dark-theme \">12</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                      \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- ============================================================== -->\n");
      out.write("                <!-- End Right sidebar -->\n");
      out.write("                <!-- ============================================================== -->");
      out.write("\n");
      out.write("                <!-- ============================================================== -->\n");
      out.write("                <!-- End Right sidebar -->\n");
      out.write("                <!-- ============================================================== -->\n");
      out.write("            </div>\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- End Container fluid  -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- footer -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("               ");
      out.write("<footer class=\"footer\">\n");
      out.write("                © 2019 Proyecto final FEYALEGRIA\n");
      out.write("</footer>");
      out.write("\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- End footer -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("        </div>\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- End Page wrapper  -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("    </div>\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- End Wrapper -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- All Jquery -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <script src=\"assets/plugins/jquery/jquery.min.js\"></script>\n");
      out.write("    <!-- Bootstrap tether Core JavaScript -->\n");
      out.write("    <script src=\"assets/plugins/bootstrap/js/popper.min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    <!-- slimscrollbar scrollbar JavaScript -->\n");
      out.write("    <script src=\"js/jquery.slimscroll.js\"></script>\n");
      out.write("    <!--Wave Effects -->\n");
      out.write("    <script src=\"js/waves.js\"></script>\n");
      out.write("    <!--Menu sidebar -->\n");
      out.write("    <script src=\"js/sidebarmenu.js\"></script>\n");
      out.write("    <!--stickey kit -->\n");
      out.write("    <script src=\"assets/plugins/sticky-kit-master/dist/sticky-kit.min.js\"></script>\n");
      out.write("    <!--Custom JavaScript -->\n");
      out.write("    <script src=\"js/custom.min.js\"></script>\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- This page plugins -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!--sparkline JavaScript -->\n");
      out.write("    <script src=\"assets/plugins/sparkline/jquery.sparkline.min.js\"></script>\n");
      out.write("    <!--morris JavaScript -->\n");
      out.write("    <script src=\"assets/plugins/raphael/raphael-min.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/morrisjs/morris.min.js\"></script>\n");
      out.write("    <!-- Chart JS -->\n");
      out.write("    <script src=\"js/dashboard1.js\"></script>\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- Style switcher -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <script src=\"assets/plugins/styleswitcher/jQuery.style.switcher.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write(" ");
 
 } else {

  response.sendRedirect("login.jsp");
}
 
 
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
