/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;
/**
 *
 * @author Kevin Damian
 */
public class Acceso {
     Conexion db = new Conexion();
    String sql ="";
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
 public Acceso() {
    }
       
    public String validar(String usuario, String contra){
       // String nom ="";
       // String dni="";
       // String foto="";
        String codtipo = "";
        
        try {
               Connection con=Conexion.conectar();
//            Class.forName(db.getDriver());
//            con= DriverManager.getConnection(db.getUrl(),db.getUser(),db.getContraseña());
            sql=" SELECT  c.descripcion FROM usuario u INNER JOIN cargo c ON u.idcargo=c.idcargo WHERE u.usuario='"+usuario+"' AND u.clave='"+contra+"' and c.estado='ACTIVO' ";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()) {
               
               codtipo=rs.getString(1);         
                
            }
            con.close();
            rs.close();
            return codtipo;
        } catch (SQLException e) {
            return codtipo;
        }
    
    }
  
    
    Conexion e=new Conexion();
    PreparedStatement ps;
   
    int r;
    int re=0;
    
       public boolean Validar(String usu, String contra) {
       

       
           try {
                 Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from docente where usuario=? and contraseña=? and estado='Activo'");
            
                  ps.setString(1, usu);
                  ps.setString(2,contra);
                  rs=ps.executeQuery();
                 
                  
                  if (rs.absolute(1)) {
                   return true;
               }
                  
               
           } catch (Exception e) {
               System.err.println("error" + e);
           } finally{
           
               try {
                   if(con!=null )con.close();
                   if (ps!=null) ps.close();
                   if(rs!=null) rs.close();
                       
               } catch (Exception e) {
                   
               System.err.println("error" + e);
               }
           }
                      
      
    
           return false ;
     
    }
    
     public boolean ValidarAl(String usu, String contra) {
       

       
           try {
                 Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from alumno where usuario=? and contraseña=? and estado='MATRICULADO'");
            
                  ps.setString(1, usu);
                  ps.setString(2,contra);
                  rs=ps.executeQuery();
                 
                  
                  if (rs.absolute(1)) {
                   return true;
               }
                  
               
           } catch (Exception e) {
               System.err.println("error" + e);
           } finally{
           
               try {
                   if(con!=null )con.close();
                   if (ps!=null) ps.close();
                   if(rs!=null) rs.close();
                       
               } catch (Exception e) {
                   
               System.err.println("error" + e);
               }
           }
                      
      
    
           return false ;
     
    }
     
     
     
     
      public boolean ValidarPa(String usu, String contra) {
       

       
           try {
                 Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from apoderado where usuario=? and clave=? and estado='Activo'");
            
                  ps.setString(1, usu);
                  ps.setString(2,contra);
                  rs=ps.executeQuery();
                 
                  
                  if (rs.absolute(1)) {
                   return true;
               }
                  
               
           } catch (Exception e) {
               System.err.println("error" + e);
           } finally{
           
               try {
                   if(con!=null )con.close();
                   if (ps!=null) ps.close();
                   if(rs!=null) rs.close();
                       
               } catch (Exception e) {
                   
               System.err.println("error" + e);
               }
           }
                      
      
    
           return false ;
     
    }
}
