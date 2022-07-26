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
public class REUNIONES {
    private int idreunion;
    private int iddocente;
    private String desdocente;
    private int idgrado;
    private String desgrado;
    private String fecha;
    private String descripcion;
    private String archivo;

    public REUNIONES(int idreunion, int iddocente, String desdocente, int idgrado, String desgrado, String fecha, String descripcion, String archivo) {
        this.idreunion = idreunion;
        this.iddocente = iddocente;
        this.desdocente = desdocente;
        this.idgrado = idgrado;
        this.desgrado = desgrado;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    public REUNIONES() {
    }

    public int getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(int idreunion) {
        this.idreunion = idreunion;
    }

    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    public String getDesdocente() {
        return desdocente;
    }

    public void setDesdocente(String desdocente) {
        this.desdocente = desdocente;
    }

 

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public String getDesgrado() {
        return desgrado;
    }

    public void setDesgrado(String desgrado) {
        this.desgrado = desgrado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    
    
    
    public static boolean RegistraReunion( REUNIONES car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_REUNION_REGISTRA(?,?,?,?)}");
            sp.setInt(1, car.getIddocente());
            sp.setInt(2, car.getIdgrado());
            sp.setString(3, car.getDescripcion());
            sp.setString(4, car.getArchivo());
           
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
    public static ArrayList<REUNIONES> ListaReuniones() {
        try {
            String SQL = "select * from v_reuniones";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<REUNIONES> lista = new ArrayList<>();
            REUNIONES car;
            while (resultado.next()) {
                car = new REUNIONES();
                car.setIdreunion(resultado.getInt(1));
                car.setDesdocente(resultado.getString(2));
                car.setDesgrado(resultado.getString(3));
                car.setFecha(resultado.getString(4));
                car.setDescripcion(resultado.getString(5));
                car.setArchivo(resultado.getString(6));
                
                lista.add(car);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //-----------------------------------------------------------------
   public static boolean EliminaReunion(REUNIONES car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_REUNION_ELIMINA(?)}");
            sp.setInt(1, car.getIdreunion());
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
    public static REUNIONES getCodreunion(String id) throws SQLException {
       REUNIONES car = new REUNIONES();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_reuniones where idreuniones=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdreunion(rs.getInt(1));
                car.setIddocente(rs.getInt(2));
                car.setDesdocente(rs.getString(3));
                car.setDesgrado(rs.getString(4));
                car.setFecha(rs.getString(5));
                car.setDescripcion(rs.getString(6));
                car.setArchivo(rs.getString(7));
                
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
    
    
    //--VISTA PARA MODIFICAR
        public static REUNIONES getCodreunionParaEditar(String id) throws SQLException {
       REUNIONES car = new REUNIONES();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from reuniones where idreuniones=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdreunion(rs.getInt(1));
                car.setIddocente(rs.getInt(2));
                car.setIdgrado(rs.getInt(3));
                car.setFecha(rs.getString(4));
                car.setDescripcion(rs.getString(5));
                car.setArchivo(rs.getString(6));
                
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
    //MODIFICACION 
public static boolean modificaReunion(REUNIONES car) {
        try {
            CallableStatement cs=null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_REUNION_MODIFICA(?,?,?,?,?)}");
            ps.setInt(1,car.getIdreunion());
             ps.setInt(2, car.getIddocente());
             ps.setInt(3, car.getIdgrado());
             ps.setString(4,car.getDescripcion());
             ps.setString(5, car.getArchivo());
                   
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
   //-------
      public DefaultTableModel REUNIOESPORDOCENTE(int doce, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"id:", "iddo:", "docente:", "grado:", "fecha:", "descripcion:", "filer:"};
            Cst = Cn.prepareCall("CALL sp_REUNIONESPORDOCENTE(?);");
            Cst.setInt(1, doce);
            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[7];
                for (int i = 0; i <7; i++) {
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
