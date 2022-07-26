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
public class MATRICULA {
    private int idmatricula;
    private String fechamatricula;
    private int idpago;
    private int idperiodo;
    private int idusuario;
    private String nombrepago;
    private String nomperiodo;

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getNomalumno() {
        return nomalumno;
    }

    public void setNomalumno(String nomalumno) {
        this.nomalumno = nomalumno;
    }
    private String nomusuario;
    private int idalumno;
    private String nomalumno;
    

    public String getNombrepago() {
        return nombrepago;
    }

    public void setNombrepago(String nombrepago) {
        this.nombrepago = nombrepago;
    }

    public String getNomperiodo() {
        return nomperiodo;
    }

    public void setNomperiodo(String nomperiodo) {
        this.nomperiodo = nomperiodo;
    }

    public String getNomusuario() {
        return nomusuario;
    }

    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    public MATRICULA(int idmatricula, String fechamatricula, int idpago, int idperiodo, int idusuario, String nombrepago, String nomperiodo, String nomusuario, int idalumno, String nomalumno) {
        this.idmatricula = idmatricula;
        this.fechamatricula = fechamatricula;
        this.idpago = idpago;
        this.idperiodo = idperiodo;
        this.idusuario = idusuario;
        this.nombrepago = nombrepago;
        this.nomperiodo = nomperiodo;
        this.nomusuario = nomusuario;
        this.idalumno = idalumno;
        this.nomalumno = nomalumno;
    }

    public MATRICULA() {
    }


   

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public String getFechamatricula() {
        return fechamatricula;
    }

    public void setFechamatricula(String fechamatricula) {
        this.fechamatricula = fechamatricula;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public int getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(int idperiodo) {
        this.idperiodo = idperiodo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    
    
       public static ArrayList<MATRICULA> ListaMatricula() {
        try {
            String SQL = "select * from v_matricula";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<MATRICULA> lista = new ArrayList<>();
            MATRICULA e;
            while (resultado.next()) {
                e = new MATRICULA();
                e.setIdmatricula(resultado.getInt(1));
                e.setFechamatricula(resultado.getString(2));
                e.setNombrepago(resultado.getString(3));
                e.setIdalumno(resultado.getInt(4));
                e.setNomalumno(resultado.getString(5));
                e.setNomperiodo(resultado.getString(6));
                e.setNomusuario(resultado.getString(7));
                
                lista.add(e);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
     
     
     
    
 public static boolean RegistrarMatricula(MATRICULA car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_MATRICULA_INGRESA(?,?,?)}");
            sp.setInt(1, car.getIdpago());
            sp.setInt(2, car.getIdperiodo());
            sp.setInt(3, car.getIdusuario());
            if (sp.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }    
    
    
      private CallableStatement Cst;
    private ResultSet R;

    public DefaultTableModel ListaumATRICULAS(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"idmatricula:", "fechamatricula:", "fechapago:", "idalumno:", "alumno:", "periodo:","usuario:"};
            Cst = Cn.prepareCall("CALL SP_LISTAMATRICULA();");

            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[7];
                for (int i = 0; i < 7; i++) {
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
    
    public static MATRICULA getIdMATRICULA(String id) throws SQLException {
       MATRICULA er = new MATRICULA();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_matricula where idMatricula=?");
            ps.setString(1, id);
            ResultSet r = ps.executeQuery();
            if (r.next()) {
         er.setIdmatricula(r.getInt(1));
                er.setFechamatricula(r.getString(2));
                er.setNombrepago(r.getString(3));
                er.setIdalumno(r.getInt(4));
                er.setNomalumno(r.getString(5));
                er.setNomperiodo(r.getString(6));
                er.setNomusuario(r.getString(7));
                con.close();

            }
        } catch (SQLException ex) {

        }
        return er;
    }
}
