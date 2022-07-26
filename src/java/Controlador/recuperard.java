/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Richard
 */
@WebServlet(name = "recuperard", urlPatterns = {"/recuperard"})
public class recuperard extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("email");
        String dn = request.getParameter("dni");
        try {
            if (enviarcorreo(correo, dn)) {
                
          request.setAttribute("mensaje","Envio Correctamente, Revise su correo");
            } else {
            request.setAttribute("mensaje","Error.. Datos incorrectos");
            }
           request.getRequestDispatcher("RecuperarContraseñaDocente.jsp").forward(request, response);

        } catch (Exception e) {
        }
    }

    public static boolean enviarcorreo(String correo, String dni) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean enviado = false;

        try {

            //Parte de la consulta para verificar el dni
            String consulta = "SELECT nombres, apellidos, correo, contraseña FROM docente WHERE correo=? AND dni =?";//Prevenir el sqlInyector
            Connection con = Conexion.conectar();
            pst = con.prepareStatement(consulta);
            pst.setString(1, correo);
            pst.setString(2, dni);

            rs = pst.executeQuery();

            Properties prop = System.getProperties();

            enviado = true;

            //Comparacion de si se ejecuto la consulta
            if (rs.next()) {

                rs.last();
                int nfilas = rs.getRow();
                rs.beforeFirst();
                rs.next();

                //Parte del servidor de correo                
                String host = "smtp.gmail.com";

                //Variables
                // String de = "soportefastfood@gmail.com";
                //String clave = "modest@@lv@r@do753";
                String de = "milagrosinga3010@gmail.com";
                String clave = "Milagritos3010";
                String para = rs.getString(3);
                String asunto = "Recuperación de credenciales";
                String mensaje = "<html>"
                        + "        <head> "
                        + "                <meta charset='utf-8'>"
                        + "                <meta http-equiv='x-ua-compatible' content='ie=edge'>"
                        + "                <title>Recuperar Contraseña</title> "
                        + "                <meta name='viewport' content='width=device-width, initial-scale=1'> "
                        + "                <style type='text/css'>"
                        + "            @media screen { "
                        + "                @font-face { "
                        + "                    font-family: 'Source Sans Pro'; "
                        + "                    font-style: normal; "
                        + "                    font-weight: 400; "
                        + "                    src: local('Source Sans Pro Regular'), local('SourceSansPro-Regular'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/ODelI1aHBYDBqgeIAH2zlBM0YzuT7MdOe03otPbuUS0.woff) format('woff');"
                        + "                } "
                        + "                @font-face { "
                        + "                    font-family: 'Source Sans Pro'; "
                        + "                    font-style: normal;"
                        + "                    font-weight: 700; "
                        + "                    src: local('Source Sans Pro Bold'), local('SourceSansPro-Bold'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/toadOcfmlt9b38dHJxOBGFkQc6VGVFSmCnC_l7QZG60.woff) format('woff');"
                        + "                } "
                        + "            }"
                        + "            body, "
                        + "            table,"
                        + "            td, "
                        + "            a { "
                        + "                -ms-text-size-adjust: 100%; "
                        + "                -webkit-text-size-adjust: 100%; "
                        + "            }"
                        + "            table,"
                        + "            td { "
                        + "                mso-table-rspace: 0pt;"
                        + "                mso-table-lspace: 0pt;"
                        + "            }"
                        + "            img {"
                        + "                -ms-interpolation-mode: bicubic;"
                        + "            }"
                        + "            a[x-apple-data-detectors] {"
                        + "                font-family: inherit !important;"
                        + "                font-size: inherit !important;"
                        + "            font-weight: inherit !important;"
                        + "                line-height: inherit !important;"
                        + "                color: inherit !important;"
                        + "                text-decoration: none !important;"
                        + "            }"
                        + "            div[style*='margin: 16px 0;'] {"
                        + "                margin: 0 !important;"
                        + "        }"
                        + "            body {"
                        + "            width: 100% !important;"
                        + "            height: 100% !important;"
                        + "                padding: 0 !important;"
                        + "                margin: 0 !important;"
                        + "            }"
                        + "            table {"
                        + "                border-collapse: collapse !important;"
                        + "            }"
                        + "            a {"
                        + "                color: #1a82e2;"
                        + "            }"
                        + "            img {"
                        + "                height: auto;"
                        + "                line-height: 100%;"
                        + "                text-decoration: none;"
                        + "                border: 0;"
                        + "                outline: none;"
                        + "            }"
                        + "        </style>"
                        + "    </head>"
                        + "    <body style=\"background-color: #e9ecef;\">"
                        + "        <div class='preheader'"
                        + "            style=\"display: none; max-width: 0; max-height: 0; overflow: hidden; font-size: 1px; line-height: 1px; color: #fff; opacity: 0;\">"
                        + "    </div>"
                        + "        <table border='0' cellpadding='0' cellspacing='0' width='100%'>"
                        + "            <tr>"
                        + "                <td align='center' bgcolor='#e9ecef'>"
                        + "                    <table border='0' cellpadding='0' cellspacing='0' width='100%' style='max-width: 600px;'>"
                        + "                        <tr>"
                        + "                            <td align='center' valign='top' style='padding: 36px 24px;'>"
                        + "                                <a href='http://rerpsystem.tonohost.com' target='_blank' style=\"display: inline-block;\">"
                        + "                                    <img src=\"https://img2.freepng.es/20180717/hfa/kisspng-computer-icons-skype-icon-design-clip-art-change-password-5b4d9bfa76ade0.9128217115318128584861.jpg\" alt='Logo' border='0' width='48'"
                        + "                                        style=\"display: block; width: 48px; max-width: 48px; min-width: 48px;\">"
                        + "                                </a>"
                        + "                        </td>"
                        + "                        </tr>"
                        + "                    </table>"
                        + "                </td>"
                        + "            </tr>"
                        + "            <tr>"
                        + "                <td align='center' bgcolor='#e9ecef'>"
                        + "                    <table border='0' cellpadding='0' cellspacing='0' width='100%' style='max-width: 600px;'>"
                        + "                        <tr>"
                        + "                            <td align='left' bgcolor='#ffffff'"
                        + "                                style=\"padding: 36px 24px 0; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; border-top: 3px solid #d4dadf;\">"
                        + "                                <h1 style=\"margin: 0; font-size: 32px; font-weight: 700; letter-spacing: -1px; line-height: 48px;\">"
                        + "                                    Recuperar su Contraseña</h1>"
                        + "                            </td>"
                        + "                    </tr>"
                        + "                    </table>"
                        + "                </td>"
                        + "            </tr>"
                        + "            <tr>"
                        + "                <td align='center' bgcolor='#e9ecef'>"
                        + "                    <table border='0' cellpadding='0' cellspacing='0' width='100%' style='max-width: 600px;'>"
                        + "                        <tr>"
                        + "                            <td align='left' bgcolor='#ffffff'"
                        + "                                style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">"
                        + "                                <p style='margin: 0;'>" + rs.getString(1) + " " + rs.getString(2) + ", Usted solicitud su clave de acceso "
                        + "                                    para el Colegio Fe y Alegria. CLAVE:</p>"
                        + "                            </td>"
                        + "                        </tr>"
                        + "                        <tr>"
                        + "                            <td align='left' bgcolor='#ffffff'>"
                        + "                            <table border='0' cellpadding='0' cellspacing='0' width='100%'>"
                        + "                                <tr>"
                        + "                                    <td align='center' bgcolor='#ffffff' style='padding: 12px;'>"
                        + "                                            <table border='0' cellpadding='0' cellspacing='0'>"
                        + "                                                <tr>"
                        + "                                                    <td align='center' bgcolor='#1a82e2' style='border-radius: 6px;'>"
                        + "                                                        <a href='#' "
                        + "                                                            style=\"display: inline-block; padding: 16px 36px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; color: #ffffff; text-decoration: none; border-radius: 6px;\">"
                        + rs.getString(4)
                        + "                                                            </a>"
                        + "                                                </td>"
                        + "                                                </tr>"
                        + "                                            </table>"
                        + "                                        </td>"
                        + "                                    </tr>"
                        + "                                </table>"
                        + "                            </td>"
                        + "                        </tr>"
                        + "                        <tr>"
                        + "                            <td align='left' bgcolor='#ffffff'"
                        + "                                style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">"
                        + "                                 <hr style=\"border-color: #0079F8; border: 2\"> "
                                                     
                        + "                        </td>"
                        + "                        </tr>"
                        + "                    </table>"
                        + "                </td>"
                        + "            </tr>"
                        + "            <tr>"
                        + "                <td align='center' bgcolor='#e9ecef' style='padding: 24px;'>"
                        + "                    <table border='0' cellpadding='0' cellspacing='0' width='100%' style='max-width: 600px;'>"
                        + "                        <tr>"
                        + "                            <td align='center' bgcolor='#e9ecef'"
                        + "                                style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">"
                        + "                                <p style='margin: 0;'>Recibió este correo electrónico porque recibimos una solicitud de [Recuperacion] para su cuenta. Si no solicitó [Recuperacion], puede eliminar este correo electrónico de manera segura..</p>"
                        + "                            </td>"
                        + "                        </tr>"
                        + "                        <tr>"
                        + "                            <td align='center' bgcolor='#e9ecef'"
                        + "                                style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">"
                        + "                                <p style='margin: 0;'>FE Y ALEGRIA<a "
                        + "                                        target='_blank'></a></p></br>"
                        + "                            </td>"
                        + "                        </tr>"
                        + "                    </table>"
                        + "                </td>"
                        + "            </tr>"
                        + "        </table>"
                        + "    </body>"
                        + "    </html>";

                prop.put("mail.smtp.starttls.enable", "true");
                prop.put("mail.smtp.host", host);
                prop.put("mail.smtp.user", de);
                prop.put("mail.smtp.password", clave);
                prop.put("mail.smtp.port", 587);
                prop.put("mail.smtp.auth", "true");

                Session sesion = Session.getDefaultInstance(prop, null);

                MimeMessage message = new MimeMessage(sesion);

                message.setFrom(new InternetAddress(de));

                /*
                Nota: Para enviar correo electronico masivo 

                InternetAddress[] direcciones = new InternetAddress[para.length];
                    for(int i = 0; i < para.length; i++){
                        direcciones[i] new InternetAddress(para[i]);
                    }

                    for ( int = 0; i < direcciones.length; i++){
                        message.addRecipient(Message.RecipientRype.TO, direcciones[i]);
                    }
                 */
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));

                message.setSubject(asunto);
                message.setText(mensaje, "ISO-8859-1", "html");

                Transport transport = sesion.getTransport("smtp");

                transport.connect(host, de, clave);

                transport.sendMessage(message, message.getAllRecipients());

                transport.close();

                //--------------------
                return enviado;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error " + e);
        } finally {
            try {
                if (Conexion.conectar() != null) {
                    Conexion.conectar().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error"
                        + " " + e);
            }
        }

        return false;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
