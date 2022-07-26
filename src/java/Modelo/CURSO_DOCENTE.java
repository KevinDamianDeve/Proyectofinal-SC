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
public class CURSO_DOCENTE {
    private int idcursodocente;
    private int idcurso;
    private int iddocente;
    private int idgrado;
    private String descurso;
    private String desdocente;
    private String desgrado;

    public CURSO_DOCENTE(int idcursodocente, int idcurso, int iddocente, int idgrado, String descurso, String desdocente, String desgrado) {
        this.idcursodocente = idcursodocente;
        this.idcurso = idcurso;
        this.iddocente = iddocente;
        this.idgrado = idgrado;
        this.descurso = descurso;
        this.desdocente = desdocente;
        this.desgrado = desgrado;
    }

    public CURSO_DOCENTE() {
    }

    public int getIdcursodocente() {
        return idcursodocente;
    }

    public void setIdcursodocente(int idcursodocente) {
        this.idcursodocente = idcursodocente;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public String getDescurso() {
        return descurso;
    }

    public void setDescurso(String descurso) {
        this.descurso = descurso;
    }

    public String getDesdocente() {
        return desdocente;
    }

    public void setDesdocente(String desdocente) {
        this.desdocente = desdocente;
    }

    public String getDesgrado() {
        return desgrado;
    }

    public void setDesgrado(String desgrado) {
        this.desgrado = desgrado;
    }
     private CallableStatement Cst;
    private ResultSet R;

    public DefaultTableModel ListaGrado(String ven, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"Id:", "idCurso:", "CURSO:", "DOCENTE:", "idDocente:", "idGrado:","Grado:"};
            Cst = Cn.prepareCall("CALL sp_DETALLES_GRADO(?);");
            Cst.setString(1, ven);
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
   

      
    public static boolean RegistrarCursoDocente(CURSO_DOCENTE car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_DOCENTE_CURSO_INGRESA(?,?,?)}");
            sp.setInt(1, car. getIdgrado());
            sp.setInt(2, car.getIdcurso());
            sp.setInt(3, car.getIddocente());
           
            if (sp.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }    
    
    public static ArrayList<CURSO_DOCENTE> ListaCargoDocente() {
        try {
            String SQL = "SELECT * FROM v_curso_docente";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<CURSO_DOCENTE> lista = new ArrayList<>();
            CURSO_DOCENTE car;
            while (resultado.next()) {
                car = new CURSO_DOCENTE();
                 car.setIdcursodocente(resultado.getInt(1));
                car.setIdcurso(resultado.getInt(2));
                car.setDescurso(resultado.getString(3));
                car.setDesdocente(resultado.getString(4));
                car.setIddocente(resultado.getInt(5));
                car.setIdgrado(resultado.getInt(6));
                car.setDesgrado(resultado.getString(7));
                lista.add(car);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
   public static boolean EliminaCursoDocente (CURSO_DOCENTE car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_DOCENTE_CURSO_ELIMINA(?)}");
            sp.setInt(1, car.getIdcursodocente());
            if (sp.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    public static CURSO_DOCENTE getIdCursoDocente(String id) throws SQLException {
       CURSO_DOCENTE    car = new CURSO_DOCENTE();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM v_curso_docente WHERE id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdcursodocente(rs.getInt(1));
                car.setIdcurso(rs.getInt(2));
                car.setDescurso(rs.getString(3));
                car.setDesdocente(rs.getString(4));
                car.setIddocente(rs.getInt(5));
                car.setIdgrado(rs.getInt(6));
                car.setDesgrado(rs.getString(7));
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
   
}

