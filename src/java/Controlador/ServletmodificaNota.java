/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.NOTAS;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kevin Damian
 */
@WebServlet(name = "ServletmodificaNota", urlPatterns = {"/ServletmodificaNota"})
public class ServletmodificaNota extends HttpServlet {

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
            out.println("<title>Servlet ServletmodificaNota</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletmodificaNota at " + request.getContextPath() + "</h1>");
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
        
          
        int cod = Integer.parseInt(request.getParameter("co"));
       int coda = Integer.parseInt(request.getParameter("al"));
       int c = Integer.parseInt(request.getParameter("cur"));
        int tri = Integer.parseInt(request.getParameter("tr"));
     float not =  Float.parseFloat(request.getParameter("no"));
    String obs =  request.getParameter("ob");            
              
               Modelo.NOTAS fo = new Modelo.NOTAS();
               fo.setIdnotas(cod);
               fo.setIdalumno(coda);
               fo.setIdcurso(c);
               fo.setIdtrimestre(tri);
               fo.setNota(not);
               fo.setObservacion(obs);       
        
            if (NOTAS.modificaNotas(fo)){
            request.setAttribute("mensaje","LA NOTA SE MODIFICO DE MANERA CORRECTA");
            }else{
            request.setAttribute("mensaje","ERROR LA NOTA NO SE MODIFICO");
            }
            request.getRequestDispatcher("Listanotas.jsp").forward(request, response);
            processRequest(request, response);
                  
            
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
