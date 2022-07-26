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
public class NOTAS {
    private int idnotas;
    private int idalumno;
    private int idcurso;
   private int idtrimestre;
   private float nota;
   private String observacion;
   private String nomalu;
   private String nomcurso;
   private String nomtrimestre;

    public int getIdnotas() {
        return idnotas;
    }

    public void setIdnotas(int idnotas) {
        this.idnotas = idnotas;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdtrimestre() {
        return idtrimestre;
    }

    public void setIdtrimestre(int idtrimestre) {
        this.idtrimestre = idtrimestre;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNomalu() {
        return nomalu;
    }

    public void setNomalu(String nomalu) {
        this.nomalu = nomalu;
    }

    public String getNomcurso() {
        return nomcurso;
    }

    public void setNomcurso(String nomcurso) {
        this.nomcurso = nomcurso;
    }

    public String getNomtrimestre() {
        return nomtrimestre;
    }

    public void setNomtrimestre(String nomtrimestre) {
        this.nomtrimestre = nomtrimestre;
    }

    public NOTAS(int idnotas, int idalumno, int idcurso, int idtrimestre, float nota, String observacion, String nomalu, String nomcurso, String nomtrimestre) {
        this.idnotas = idnotas;
        this.idalumno = idalumno;
        this.idcurso = idcurso;
        this.idtrimestre = idtrimestre;
        this.nota = nota;
        this.observacion = observacion;
        this.nomalu = nomalu;
        this.nomcurso = nomcurso;
        this.nomtrimestre = nomtrimestre;
    }

    public NOTAS() {
    }
   
      
    public static boolean RegistrarNotas(NOTAS car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_REGISTRO_INGRESA(?,?,?,?,?)}");
            sp.setInt(1, car. getIdalumno());
            sp.setInt(2, car.getIdcurso());
            sp.setInt(3, car.getIdtrimestre());
            sp.setFloat(4, car.getNota());
            sp.setString(5, car.getObservacion());
           
            if (sp.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }    
    
    public static ArrayList<NOTAS> ListaNotas() {
        try {
            String SQL = "SELECT * FROM v_registro";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<NOTAS> lista = new ArrayList<>();
            NOTAS car;
            while (resultado.next()) {
                car = new NOTAS();
                 car.setIdnotas(resultado.getInt(1));
                car.setNomalu(resultado.getString(2));
                car.setNomcurso(resultado.getString(3));
                car.setNomtrimestre(resultado.getString(4));
                car.setNota(resultado.getFloat(5));
                car.setObservacion(resultado.getString(6));
                lista.add(car);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
  
    public static NOTAS getIdNotasModificado(String id) throws SQLException {
       NOTAS    car = new NOTAS();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM registro WHERE idRegistro=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdnotas(rs.getInt(1));
                car.setIdalumno(rs.getInt(2));
                car.setIdcurso(rs.getInt(3));
                car.setIdtrimestre(rs.getInt(4));
                car.setNota(rs.getFloat(5));
                car.setObservacion(rs.getString(6));
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
     public static NOTAS getIdNotasListado(String id) throws SQLException {
       NOTAS    car = new NOTAS();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM v_registro WHERE idRegistro=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdnotas(rs.getInt(1));
                car.setNomalu(rs.getString(2));
                car.setNomcurso(rs.getString(3));
                car.setNomtrimestre(rs.getString(4));
                car.setNota(rs.getFloat(5));
                car.setObservacion(rs.getString(6));
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
public static boolean modificaNotas(NOTAS car) {
        try {
            CallableStatement cs=null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_REGISTRO_MODIFICA(?,?,?,?,?,?)}");
            ps.setInt(1,car.getIdnotas());
            ps.setInt(2, car.getIdalumno());
            ps.setInt(3, car.getIdcurso());
            ps.setInt(4,car.getIdtrimestre());
            ps.setFloat(5, car.getNota());
            ps.setString(6, car.getObservacion());
           
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

    public DefaultTableModel ListaNotasAlumno(String ven, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"Id:", "alumno:", "nombrecurso:","grado:", "descripcion:", "nota:", "observacion:"};
            Cst = Cn.prepareCall("CALL sp_LISTA_NOTA_ALUMNO(?);");
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
    
    // lista de  alumnos que tienen notas , lista para profesor
    
    public DefaultTableModel ListaNotasAlumnoProfesor(int iddocente, int idcurso, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"Id:", "alumno:","grado:", "nombrecurso:", "descripcion:", "nota:", "observacion:", "docente:"};
            Cst = Cn.prepareCall("CALL sp_listanotasprofesor(?,?);");
            Cst.setInt(1, iddocente);
            Cst.setInt(2, idcurso);
            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[8];
                for (int i = 0; i < 8; i++) {
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
    
    //--- LISTA DE ALUMNOS POR GRADO Y DOCENTE
    public DefaultTableModel ListaNotasAlumnoPorcursoDocente(int idd, int idg, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = { "alumno:", "grado:", "curso:"};
            Cst = Cn.prepareCall("CALL sp_LISTA_NOTAS_PROFE_SELECCIONA_GRADO_DOCENTE(?,?);");
            Cst.setInt(1, idd);
            Cst.setInt(2, idg);
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



///-----------------------------------------
    public DefaultTableModel ListaNotasAlumnoProfesorx2(int iddocente, int idcurso, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"Id:", "alumno:","grado:", "nombrecurso:", "descripcion:","periodo:", "nota:", "observacion:", "docente:"};
            Cst = Cn.prepareCall("CALL sp_listanotasprofesor(?,?);");
            Cst.setInt(1, iddocente);
            Cst.setInt(2, idcurso);
            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[9];
                for (int i = 0; i < 9; i++) {
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
    
    
    
    
    
///---------------------ALUMNO SELECCIONA CURSO QUE LLEVA
    public DefaultTableModel ListaCursosdelalumno(int ida, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"grado:", "id:","curso:"};
            Cst = Cn.prepareCall("CALL sp_ALUMNO_SELECCIONA_CURSO(?);");
            Cst.setInt(1, ida);
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
    
    
    //--------------------NOTAS DE LOS ALUMNOS POR CURSO
    public DefaultTableModel ListaNotasporCurso(int ida, int idc, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"nombre:", "idgrado:","grado:","idcurso:","nombrecurso:", "descripcion:","obser:", "nota:", "peri:" };
            Cst = Cn.prepareCall("CALL sp_NOTAS_ALUMNO(?,?);");
            Cst.setInt(1, ida);
            Cst.setInt(2, idc);
            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[9];
                for (int i = 0; i <9; i++) {
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
    
    // DOCENTES DEL ALUMNO
    
     public DefaultTableModel DocentesAlumno(int ida, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"nombre:", "idd:","docente:"};
            Cst = Cn.prepareCall("CALL sp_DOCENTE_DEL_ALUMNO(?);");
            Cst.setInt(1, ida);
            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[3];
                for (int i = 0; i <3; i++) {
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
    
     //------------ID DE GRADO
     public DefaultTableModel Idgrado(int ida, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"id:", "grado:"};
            Cst = Cn.prepareCall("CALL sp_IDGRADO(?);");
            Cst.setInt(1, ida);
            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[2];
                for (int i = 0; i <2; i++) {
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
     
     
     
     //-------
      public DefaultTableModel REUNIO(int idg, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"id:", "docente:", "grado:", "fecha:", "descripcion:", "filer:"};
            Cst = Cn.prepareCall("CALL sp_REUNIONES_APO(?);");
            Cst.setInt(1, idg);
            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[6];
                for (int i = 0; i <6; i++) {
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
    


