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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Kevin Damian
 */
@WebServlet(name = "ServletRegistrarAlumnoSecre", urlPatterns = {"/ServletRegistrarAlumnoSecre"})
public class ServletRegistrarAlumnoSecre extends HttpServlet {

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
            out.println("<title>Servlet ServletRegistrarAlumnoSecre</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletRegistrarAlumnoSecre at " + request.getContextPath() + "</h1>");
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
        
        String dni = request.getParameter("dni");
        Part fotografia = request.getPart("imagen");
        String nom = request.getParameter("nom");
        String ape = request.getParameter("ape");
        String fech = request.getParameter("fecha");
        String dir = request.getParameter("dir");
        String cor = request.getParameter("correo");
        String celu = request.getParameter("celular");
        String gen = request.getParameter("genero");
        String pro = request.getParameter("proce");
        String aler = request.getParameter("aler");
        String limi = request.getParameter("limi");
        String usu = request.getParameter("usu");
        String contr = request.getParameter("con");
        int apo = Integer.parseInt(request.getParameter("apoderado"));
        int grado = Integer.parseInt(request.getParameter("grado"));
        ALUMNO f = new ALUMNO();
        
        f.setDni(dni);
        f.setNom(nom);
        f.setApellidos(ape);
        f.setSexo(gen);
        f.setFechan(fech);
        f.setEmail(cor);
        f.setCelular(celu);
        f.setDirecion(dir);
        f.setUsuario(usu);
        f.setContraseña(contr);
        f.setProcedencia(pro);
        f.setAlergia(aler);
        f.setLimitaciones(limi);
        f.setIdgrado(grado);
        f.setIdapoderado(apo);
        
        String type = "" + fotografia.getContentType();
        if ("image/jpeg".equals(type) || "image/jpg".equals(type) || "image/png".equals(type)) {
            InputStream is = fotografia.getInputStream();
            File fil = new File("F:/Proyectofinal-SC/web/Fotos/Alumnos/" + fotografia.getSubmittedFileName());
            FileOutputStream ous = new FileOutputStream(fil);

            int dato = is.read();
            while (dato != (-1)) {
                ous.write(dato);
                dato = is.read();
            }
            ous.close();
            is.close();
            //almacenar ruta
            f.setFoto("Fotos/Alumnos/" + fotografia.getSubmittedFileName());
        }
        
        if (ALUMNO.RegistrarAlumno(f)) {
            
          request.setAttribute("mensaje","EL ALUMNO SE INGRESO DE MANERA CORRECTA");
        }else{
            request.setAttribute("mensaje","ERROR EL ALUMNO NO SE INGRESO");
        }
        request.getRequestDispatcher("ListaEstudiantesSecre.jsp").forward(request, response);
        
        
        
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
