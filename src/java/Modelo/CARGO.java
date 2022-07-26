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
public class CARGO {
    private int idcargo;
    private String descripcion;
    private String estado;

    public CARGO(int idcargo, String descripcion, String estado) {
        this.idcargo = idcargo;
        this.descripcion = descripcion;
        this.estado = estado;
    }
     public CARGO() {
        this.idcargo = 0;
        this.descripcion = "";
        this.estado = "";
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
      private CallableStatement Cst;
    private ResultSet R;

    public DefaultTableModel Listacargos(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"DESCRIPCION:", "ESTADO:"};
            Cst = Cn.prepareCall("CALL SP_LISTA_GRADOS();");

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

    
    public static boolean RegistrarCargo( CARGO car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_CARGO_INGRESA(?,?)}");
            sp.setString(1, car.getDescripcion());
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
    public static ArrayList<CARGO> ListaCargo() {
        try {
            String SQL = "select * from cargo";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<CARGO> lista = new ArrayList<>();
            CARGO car;
            while (resultado.next()) {
                car = new CARGO();
                car.setIdcargo(resultado.getInt(1));
                car.setDescripcion(resultado.getString(2));
                car.setEstado(resultado.getString(3));
                
                lista.add(car);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //-----------------------------------------------------------------
   public static boolean EliminaCargo(CARGO car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_CARGO_ELIMINA(?)}");
            sp.setInt(1, car.getIdcargo());
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
    public static CARGO getIdCargo(String id) throws SQLException {
       CARGO car = new CARGO();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_cargo where idcargo=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
         car.setIdcargo(rs.getInt(1));
                car.setDescripcion(rs.getString(2));
                car.setEstado(rs.getString(3));
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
    //MODIFICACION 
public static boolean modificaCargo(CARGO car) {
        try {
            CallableStatement cs=null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_CARGO_MODIFICA(?,?,?)}");
            ps.setInt(1,car.getIdcargo());
             ps.setString(2, car.getDescripcion());
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
