package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <!-- Favicon icon -->\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" src=\"assets/images/feyale.jpg\">\n");
      out.write("\n");
      out.write("    <title>FE Y ALEGRIA</title>\n");
      out.write("    <link href=\"assets/plugins/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- You can change the theme colors from here -->\n");
      out.write("    <link href=\"css/colors/blue.css\" id=\"theme\" rel=\"stylesheet\">\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("<![endif]-->\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- Preloader - style you can find in spinners.css -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <div class=\"preloader\">\n");
      out.write("        <svg class=\"circular\" viewBox=\"25 25 50 50\">\n");
      out.write("            <circle class=\"path\" cx=\"50\" cy=\"50\" r=\"20\" fill=\"none\" stroke-width=\"2\" stroke-miterlimit=\"10\" /> </svg>\n");
      out.write("    </div>\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- Main wrapper - style you can find in pages.scss -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <section id=\"wrapper\" class=\"login-register login-sidebar\" style=\"background-image:url(assets/images/background/login-register.jpg);\">\n");
      out.write("        <div class=\"login-box card\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <form role=\"form\" class=\"form-horizontal\" action=\"SERVLOGIN\" method=\"POST\">\n");
      out.write("                    <a  class=\"text-center db\"><img src=\"assets/images/feyale.jpg\" /><br/></a>\n");
      out.write("                    <center> <h2>Personal Academico</h2></center>\n");
      out.write("                    <div class=\"form-group m-t-40\">\n");
      out.write("                        <div class=\"col-xs-12\">\n");
      out.write("                            <input class=\"form-control\" name=\"txtusuario\"  type=\"text\" required=\"\" placeholder=\"Username\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"col-xs-12\">\n");
      out.write("                            <input class=\"form-control\" name=\"txtcontra\" type=\"password\" required=\"\" placeholder=\"Password\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <div class=\"checkbox checkbox-primary pull-left p-t-0\">\n");
      out.write("                                <input id=\"checkbox-signup\" type=\"checkbox\">\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-outline-primary\" data-toggle=\"modal\" data-target=\"#exampleModal\">\n");
      out.write("                            Recuperar Contraseña\n");
      out.write("                        </button>\n");
      out.write("                             \n");
      out.write("                        </div> \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group text-center m-t-20\">\n");
      out.write("                        <div class=\"col-xs-12\">\n");
      out.write("                            <button class=\"btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light\" name=\"btnIniciar\" type=\"submit\">Ingresar</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                   \n");
      out.write("                </form>\n");
      out.write("       \n");
      out.write("            </div>\n");
      out.write("      \n");
      out.write("            </div>\n");
      out.write("     \n");
      out.write("        \n");
      out.write("    </section>\n");
      out.write("    <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <h5 class=\"modal-title\" id=\"exampleModalLabel\">Recuperar Contraseña</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <!-- 4:3 aspect ratio -->\n");
      out.write("                            <div class=\"embed-responsive embed-responsive-4by3\">\n");
      out.write("                                <iframe class=\"embed-responsive-item\" src=\"RecuperarContraseña.jsp\"></iframe>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <button type=\"button\" class=\"btn btn-info btm-sm\" data-dismiss=\"modal\" onclick= \"self.location.href = 'login.jsp'\">\n");
      out.write("                                CANCELAR</button>\n");
      out.write("                            <!--<button type=\"button\" class=\"btn btn-primary\">Save changes</button>-->\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        ");

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
        
      out.write("\n");
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
      out.write("    <script src=\"assets/plugins/sparkline/jquery.sparkline.min.js\"></script>\n");
      out.write("    <!--Custom JavaScript -->\n");
      out.write("    <script src=\"js/custom.min.js\"></script>\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- Style switcher -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <script src=\"/assets/plugins/styleswitcher/jQuery.style.switcher.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
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
