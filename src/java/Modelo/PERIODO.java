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
public class PERIODO {
    private int idperiodo;
    private String periodo;
    private String estado;

    public PERIODO(int idperiodo, String periodo, String estado) {
        this.idperiodo = idperiodo;
        this.periodo = periodo;
        this.estado = estado;
    }
    
    public PERIODO() {
        this.idperiodo = 0;
        this.periodo = "";
        this.estado = "";
    }

    public int getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(int idperiodo) {
        this.idperiodo = idperiodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
     
    
 
    
    public static boolean RegistrarPeriodo( PERIODO car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_PERIODO_INGRESA(?,?)}");
            sp.setString(1, car.getPeriodo());
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
    public static ArrayList<PERIODO> ListaPeriod() {
        try {
            String SQL = "select * from periodo";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<PERIODO> lista = new ArrayList<>();
            PERIODO car;
            while (resultado.next()) {
                car = new PERIODO();
                car.setIdperiodo(resultado.getInt(1));
                car.setPeriodo(resultado.getString(2));
                car.setEstado(resultado.getString(3));
                
                lista.add(car);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //-----------------------------------------------------------------
   public static boolean EliminaPeriodo(PERIODO car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_PERIODO_ELIMINA(?)}");
            sp.setInt(1, car.getIdperiodo());
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
    public static PERIODO getIdPeriodo(String id) throws SQLException {
       PERIODO car = new PERIODO();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_periodo where idperiodo=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdperiodo(rs.getInt(1));
                car.setPeriodo(rs.getString(2));
                car.setEstado(rs.getString(3));
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
    //MODIFICACION 
public static boolean modificaPeriodo(PERIODO car) {
        try {
            CallableStatement cs=null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_PERIODO_MODIFICA(?,?,?)}");
            ps.setInt(1,car.getIdperiodo());
             ps.setString(2, car.getPeriodo());
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

        
    
         private CallableStatement Cst;
    private ResultSet R;

    public DefaultTableModel ListapERIODO(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"PERIODO:", "ESTADO:"};
            Cst = Cn.prepareCall("CALL SP_LISTA_PERIODO();");

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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
