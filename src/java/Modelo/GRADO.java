/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin Damian
 */
public class GRADO {
    private int idgrado;
    private String gradoseccion;
    private int maxalumnos;
    private int total;

    public GRADO(int idgrado, String gradoseccion, int maxalumnos, int total) {
        this.idgrado = idgrado;
        this.gradoseccion = gradoseccion;
        this.maxalumnos = maxalumnos;
        this.total = total;
       
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public String getGradoseccion() {
        return gradoseccion;
    }

    public void setGradoseccion(String gradoseccion) {
        this.gradoseccion = gradoseccion;
    }

    public int getMaxalumnos() {
        return maxalumnos;
    }

    public void setMaxalumnos(int maxalumnos) {
        this.maxalumnos = maxalumnos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public GRADO() {
    }

 
    
    
      private CallableStatement Cst;
    private ResultSet R;

    public DefaultTableModel ListaGRADO(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"GRADO:", "MAX:"};
            Cst = Cn.prepareCall("CALL SP_LISTAGRADO();");

            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[2];
                for (int i = 0; i < 2; i++) {
                    dato[i] = R.getString(i + 1);
                }
                c.addRow(dato);
            }
            Cn.close();
            return c;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        } 
    }

 
    
    public static boolean RegistrarGrado( GRADO car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_GRADO_INGRESA(?,?)}");
            sp.setString(1, car.getGradoseccion());
            sp.setInt(2, car.getMaxalumnos());
           
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
    public static ArrayList<GRADO> ListaGrado() {
        try {
            String SQL = "select * from grado";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<GRADO> lista = new ArrayList<>();
            GRADO car;
            while (resultado.next()) {
                car = new GRADO();
                car.setIdgrado(resultado.getInt(1));
                car.setGradoseccion(resultado.getString(2));
                car.setMaxalumnos(resultado.getInt(3));
                car.setTotal(resultado.getInt(4));
                lista.add(car);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //-----------------------------------------------------------------
   public static boolean EliminaGrado(GRADO car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_GRADO_ELIMINA(?)}");
            sp.setInt(1, car.getIdgrado());
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
    public static GRADO getIdGRado(String id) throws SQLException {
       GRADO car = new GRADO();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_grado where idgrado=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
         car.setIdgrado(rs.getInt(1));
                car.setGradoseccion(rs.getString(2));
                car.setMaxalumnos(rs.getInt(3));
                car.setTotal(rs.getInt(4));
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
    //MODIFICACION 
public static boolean modificaGrado(GRADO car) {
        try {
            CallableStatement cs=null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_GRADO_MODIFICA(?,?,?)}");
            ps.setInt(1,car.getIdgrado());
             ps.setString(2, car.getGradoseccion());
            ps.setInt(3, car.getMaxalumnos());
           
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
