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
public class TRIMESTRE {
    private int idtrimestre;
    private String des;

    public TRIMESTRE(int idtrimestre, String des) {
        this.idtrimestre = idtrimestre;
        this.des = des;
    }

    public TRIMESTRE() {
    }

    public int getIdtrimestre() {
        return idtrimestre;
    }

    public void setIdtrimestre(int idtrimestre) {
        this.idtrimestre = idtrimestre;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
     
    
      private CallableStatement Cst;
    private ResultSet R;

    public DefaultTableModel ListaTri(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"id:", "tri:"};
            Cst = Cn.prepareCall("CALL sp_LISTATRI();");

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

    
    public static boolean RegistraTrimestre( TRIMESTRE car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_TRIMESTRE_INGRESA(?)}");
            sp.setString(1, car.getDes());
           
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
    public static ArrayList<TRIMESTRE> ListaTrimestre() {
        try {
            String SQL = "select * from trimestre";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<TRIMESTRE> lista = new ArrayList<>();
            TRIMESTRE car;
            while (resultado.next()) {
                car = new TRIMESTRE();
                car.setIdtrimestre(resultado.getInt(1));
                car.setDes(resultado.getString(2));
                
                lista.add(car);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //-----------------------------------------------------------------
   public static boolean EliminaTrimestre(TRIMESTRE car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_TRIMESTRE_ELIMINA(?)}");
            sp.setInt(1, car.getIdtrimestre());
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
    public static TRIMESTRE getCodTrimestre(String id) throws SQLException {
       TRIMESTRE car = new TRIMESTRE();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_trimestre where idTri=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
         car.setIdtrimestre(rs.getInt(1));
                car.setDes(rs.getString(2));
                
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
    //MODIFICACION 
public static boolean modificaTri(TRIMESTRE car) {
        try {
            CallableStatement cs=null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_TRIMESTRE_MODIFICA(?,?)}");
            ps.setInt(1,car.getIdtrimestre());
             ps.setString(2, car.getDes());
                   
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
