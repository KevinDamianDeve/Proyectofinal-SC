/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Apoderado;
import Modelo.DOCENTE;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Kevin Damian
 */
@WebServlet(name = "ServletmodificaDocente", urlPatterns = {"/ServletmodificaDocente"})
@MultipartConfig
public class ServletmodificaDocente extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletmodificaDocente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletmodificaDocente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        int cod = Integer.parseInt(request.getParameter("cod"));
        String nom = request.getParameter("nom");
        String ape = request.getParameter("ape");
         String dir = request.getParameter("dire");
          String fec = request.getParameter("fec");
        int dni = Integer.parseInt(request.getParameter("dn"));
        Part fo = request.getPart("imagen");
        String esta = request.getParameter("esta");
         String cor = request.getParameter("cor");
         String cel = request.getParameter("cel");
        String tel = request.getParameter("tel");
        
        String usu = request.getParameter("usu");
        String cont = request.getParameter("con");
        String tit = request.getParameter("titu");
        
        
        Modelo.DOCENTE fot = new Modelo.DOCENTE();
        fot.setIddodocente(cod);
        fot.setDni(dni);
        fot.setNombres(nom);
        fot.setApellidos(ape);
        fot.setFecha_n(fec);
        fot.setCorreo(cor);
        fot.setCelular(cel);
        fot.setTelefono_fijo(tel);
        fot.setDireccion(dir);
        fot.setUsuario(usu);
        fot.setContra(cont);
        fot.setTitulo(tit);
        fot.setEstado(esta);
        

        String type = "" + fo.getContentType();
        if ("image/jpeg".equals(type) || "image/jpg".equals(type) || "image/png".equals(type)) {
            InputStream is = fo.getInputStream();
            File fil = new File("F:/Proyectofinal-SC/web/Fotos/Docente/" + fo.getSubmittedFileName());
            FileOutputStream ous = new FileOutputStream(fil);

            int dato = is.read();
            while (dato != (-1)) {
                ous.write(dato);
                dato = is.read();
            }
            ous.close();
            is.close();
            fot.setFoto("Fotos/Docente/" + fo.getSubmittedFileName());
        }

        if (DOCENTE.modificaDocente(fot)) {
            request.setAttribute("mensaje","EL DOCENTE SE MODIFICO DE MANERA CORRECTA");
        }else{
            request.setAttribute("mensaje","ERROR EL DOCENTE NO SE MODIFICO");
        }
        request.getRequestDispatcher("ListaDocente.jsp").forward(request, response);
        
        processRequest(request, response);
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
