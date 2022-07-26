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
public class PAGO {
    private int idpago;
    private String fechapago;
    private int idalumno;
    private float monto;
    private String estado;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public PAGO(int idpago, String fechapago,int idalumno, float monto, String estado, String nombre) {
        this.idpago = idpago;
        this.fechapago = fechapago;
        this.idalumno=0;
        this.monto = monto;
        this.estado = estado;
        this.nombre=nombre;
    }
     public PAGO() {
        this.idpago = 0;
        this.fechapago = "";
        this.monto = 0;
        this.estado = "";
        this.nombre="";
    }


    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public String getFechapago() {
        return fechapago;
    }

    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
      private CallableStatement Cst;
    private ResultSet R;

    public DefaultTableModel ListapAGOS(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"FECHA:", "NOMBRES:","MONTO:"};
            Cst = Cn.prepareCall("CALL sp_LISTAPAGOS();");

            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[3];
                for (int i = 0; i < 3; i++) {
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
    
       public static ArrayList<PAGO> ListaPago() {
        try {
            String SQL = "select * from v_pago";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<PAGO> lista = new ArrayList<>();
            PAGO e;
            while (resultado.next()) {
                e = new PAGO();
                e.setIdpago(resultado.getInt(1));
                e.setFechapago(resultado.getString(2));
                e.setNombre(resultado.getString(3));
                e.setMonto(resultado.getFloat(4));
                e.setEstado(resultado.getString(5));
                
                lista.add(e);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
     
        public static ArrayList<PAGO> ListaPagoPeroNoMatriculados() {
        try {
            String SQL = "select * from v_alumno_pagomatricula";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<PAGO> lista = new ArrayList<>();
            PAGO e;
            while (resultado.next()) {
                e = new PAGO();
                e.setIdpago(resultado.getInt(1));
                e.setFechapago(resultado.getString(2));
                e.setNombre(resultado.getString(3));
                e.setMonto(resultado.getFloat(4));
                e.setEstado(resultado.getString(5));
                
                lista.add(e);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
     
     
    
 public static boolean RegistrarPago( PAGO car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_PAGO_INGRESAR(?,?)}");
            sp.setInt(1, car.getIdalumno());
            sp.setFloat(2, car.getMonto());
            if (sp.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }    
 
   public static PAGO getIdPago(String id) throws SQLException {
       PAGO car = new PAGO();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_pago where idpago=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
         car.setIdpago(rs.getInt(1));
                car.setFechapago(rs.getString(2));
                car.setNombre(rs.getString(3));
               car.setMonto(rs.getFloat(4));
               car.setEstado(rs.getString(5));
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }

    
}
