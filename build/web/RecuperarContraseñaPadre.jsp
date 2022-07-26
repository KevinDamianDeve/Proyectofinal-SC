<%-- 
    Document   : RecuperarContraseñaPadre
    Created on : 10-ene-2020, 15:49:28
    Author     : Kevin Damian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="css/colors/blue.css" id="theme" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RECUPERAR CONTRASEÑA</title>
    </head>
    <body>
           
                <form  action="recuperarap" method="POST">
                    <div class="form-group ">
                        <div class="col-xs-12">
                            <h3>Recordar Contraseña del Apoderado</h3>
                            <p class="text-muted">Ingresa Email y DNI. Luego accede a tu correo para ver contraseña.. </p>
                        </div>
                    </div>
                    <div class="form-group ">
                        <div class="col-xs-12">
                            <input class="form-control" type="text " name="email" required="" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group ">
                        <div class="col-xs-12">
                            <input class="form-control" type="text" name="dni" required="" placeholder="DNI">
                        </div>
                    </div>
                    <div class="form-group text-center m-t-20">
                        <div class="col-xs-12">
                 <button class="btn btn-primary btn-lg btn-block text-uppercase waves-effect waves-light"  type="submit">Recuperar</button>
                 <tr>
                     <td colspan="2">
                         <h5><font color="red">
                             <%=request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : ""%>
                             </font></h5>
                     </td>
                 </tr>
                        </div>
                        
                    </div>
                </form>
    
         <script src="assets/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="assets/plugins/bootstrap/js/popper.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
 
        
        
    </body>
</html>
