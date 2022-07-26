/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ALUMNO;
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

/**
 *
 * @author Kevin Damian
 */
@WebServlet(name = "ServletModificaAlumno", urlPatterns = {"/ServletModificaAlumno"})
@MultipartConfig
public class ServletModificaAlumno extends HttpServlet {

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
            out.println("<title>Servlet ServletModificaAlumno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletModificaAlumno at " + request.getContextPath() + "</h1>");
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
        
        int cod=Integer.parseInt(request.getParameter("cod"));
                 String dni = request.getParameter("dn");
                 Part fo = request.getPart("imagen");
                 
                 String nom = request.getParameter("nom");
                 String ape = request.getParameter("ape");
                 String fec = request.getParameter("fec");             
                 String dir = request.getParameter("dir");                 
                 String tel = request.getParameter("tel");  
                 String cor = request.getParameter("cor");                 
                 String gen = request.getParameter("genero");
                 String pro = request.getParameter("proce");
                 String aler = request.getParameter("aler");
                 String limi = request.getParameter("limi");
                 String usu = request.getParameter("usu");
                 String cont = request.getParameter("con");  
                  int apo=Integer.parseInt(request.getParameter("apo"));
                 int gra=Integer.parseInt(request.getParameter("grado"));
                 String est = request.getParameter("esta");
               
                 
            
               Modelo.ALUMNO fot = new Modelo.ALUMNO();
               fot.setIdalumno(cod);
               fot.setDni(dni);
        fot.setNom(nom);
        fot.setApellidos(ape);
        fot.setFechan(fec);
        fot.setDirecion(dir);
        fot.setCelular(tel);
        fot.setEmail(cor);
        fot.setSexo(gen);
        fot.setProcedencia(pro);
        fot.setAlergia(aler);
        fot.setLimitaciones(limi);
        
        fot.setUsuario(usu);
        fot.setContraseña(cont);
        fot.setIdapoderado(apo);
        fot.setIdgrado(gra);
        fot.setEstado(est);
        
    String type = "" + fo.getContentType();
        if ("image/jpeg".equals(type) || "image/jpg".equals(type) || "image/png".equals(type)) {
            InputStream is = fo.getInputStream();
            File fil = new File("F:/Proyectofinal-SC/web/Fotos/Alumnos/" + fo.getSubmittedFileName());
            FileOutputStream ous = new FileOutputStream(fil);

            int dato = is.read();
            while (dato != (-1)) {
                ous.write(dato);
                dato = is.read();
            }
            ous.close();
            is.close();
            fot.setFoto("Fotos/Alumnos/" + fo.getSubmittedFileName());
        }
        
            if (ALUMNO.modificaAlumno(fot))
            {
            request.setAttribute("mensaje","EL ESTUDIANTE SE MODIFICO DE MANERA CORRECTA");
        }else{
            request.setAttribute("mensaje","ERROR EL ESTUDIANTE NO SE MODIFICO");
        }
        request.getRequestDispatcher("ListaEstudiantes.jsp").forward(request, response);
        
        
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
