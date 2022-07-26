/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.REUNIONES;
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
@WebServlet(name = "ServletmodificaReu", urlPatterns = {"/ServletmodificaReu"})
@MultipartConfig
public class ServletmodificaReu extends HttpServlet {

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
            out.println("<title>Servlet ServletmodificaReu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletmodificaReu at " + request.getContextPath() + "</h1>");
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
           String des = request.getParameter("des");
        Part ar = request.getPart("archivo");
        int doc = Integer.parseInt(request.getParameter("docente"));
       int grado = Integer.parseInt(request.getParameter("grado"));

       REUNIONES r = new REUNIONES();
       r.setIdreunion(cod);
       r.setDescripcion(des);
       r.setIddocente(doc);
       r.setIdgrado(grado);
       
        

        String type = "" + ar.getContentType();
         "pdf".equals(type);
            InputStream is = ar.getInputStream();
            File fil = new File("F:/Proyectofinal-SC/web/Reuniones/"  + ar.getSubmittedFileName());
            FileOutputStream ous = new FileOutputStream(fil);

            int dato = is.read();
            while (dato != (-1)) {
                ous.write(dato);
                dato = is.read();
            }
            ous.close();
            is.close();
            //almacenar ruta
         r.setArchivo("Reuniones/" + ar.getSubmittedFileName());
        
        
        if (REUNIONES.modificaReunion(r)) {
            
          request.setAttribute("mensaje","LA REUNION SE MODIFICO DE MANERA CORRECTA");
        }else{
            request.setAttribute("mensaje","ERROR LA REUNION NO SE MODIFICO");
        }
        request.getRequestDispatcher("ListaReuniones.jsp").forward(request, response);
        
        
        
        
        
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
