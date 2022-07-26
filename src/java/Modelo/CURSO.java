/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Kevin Damian
 */
public class CURSO {
    private int idcurso;
    private String nombrecurso;
    private String estado;

    public CURSO(int idcurso, String nombrecurso, String estado) {
        this.idcurso = idcurso;
        this.nombrecurso = nombrecurso;
        this.estado = estado;
    }

    public CURSO() {
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
      
    public static boolean RegistrarCurso(CURSO car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_INGRESA_CURSO(?,?)}");
            sp.setString(1, car.getNombrecurso());
            sp.setString(2, car.getEstado());
           
            if (sp.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }    
    //----------------------------------------
    public static ArrayList<CURSO> ListaCargo() {
        try {
            String SQL = "select * from curso";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<CURSO> lista = new ArrayList<>();
            CURSO car;
            while (resultado.next()) {
                car = new CURSO();
                car.setIdcurso(resultado.getInt(1));
                car.setNombrecurso(resultado.getString(2));
                car.setEstado(resultado.getString(3));
                
                lista.add(car);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //-----------------------------------------------------------------
   public static boolean EliminaCurso(CURSO car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_ELIMINA_CURSO(?)}");
            sp.setInt(1, car.getIdcurso());
            if (sp.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
//VISTA DE APODERADO
    public static CURSO getIdCurso(String id) throws SQLException {
       CURSO car = new CURSO();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_curso where idCurso=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdcurso(rs.getInt(1));
                car.setNombrecurso(rs.getString(2));
                car.setEstado(rs.getString(3));
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
    //MODIFICACION 
public static boolean modificaCurso(CURSO car) {
        try {
            CallableStatement cs=null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_MODIFICA_CURSO(?,?,?)}");
            ps.setInt(1,car.getIdcurso());
             ps.setString(2, car.getNombrecurso());
            ps.setString(3, car.getEstado());
           
            if (ps.executeUpdate()>0) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {

        }
        return false;
    }

    
  
}
