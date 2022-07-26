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
public class ALUMNO {

 
    
    private int idalumno;
    private String dni;
    private String nom;
    private String apellidos;
    private String fechan;
    private String direcion;
    private String celular;
    private String email;
    private String sexo;
    private String procedencia;
    private String alergia;
    private String limitaciones;
    private String estado;
    private int idapoderado;
    private int  idgrado;
    private String diaregistro;
    private String foto;
    private String usuario;
    private String contraseña;
 private String desapoderado;
    private String desgrado;
    
    public String getDesapoderado() {
        return desapoderado;
    }

    public void setDesapoderado(String desapoderado) {
        this.desapoderado = desapoderado;
    }

    public String getDesgrado() {
        return desgrado;
    }

    public void setDesgrado(String desgrado) {
        this.desgrado = desgrado;
    }

    public CallableStatement getCst() {
        return Cst;
    }

    public void setCst(CallableStatement Cst) {
        this.Cst = Cst;
    }

    public ResultSet getR() {
        return R;
    }

    public void setR(ResultSet R) {
        this.R = R;
    }
   

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechan() {
        return fechan;
    }

    public void setFechan(String fechan) {
        this.fechan = fechan;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getLimitaciones() {
        return limitaciones;
    }

    public void setLimitaciones(String limitaciones) {
        this.limitaciones = limitaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdapoderado() {
        return idapoderado;
    }

    public void setIdapoderado(int idapoderado) {
        this.idapoderado = idapoderado;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public String getDiaregistro() {
        return diaregistro;
    }

    public void setDiaregistro(String diaregistro) {
        this.diaregistro = diaregistro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ALUMNO(int idalumno, String dni, String nom, String apellidos, String fechan, String direcion, String celular, String email, String sexo, String procedencia, String alergia, String limitaciones, String estado, int idapoderado, int idgrado, String diaregistro, String foto, String usuario, String contraseña, String desapoderado, String desgrado) {
        this.idalumno = idalumno;
        this.dni = dni;
        this.nom = nom;
        this.apellidos = apellidos;
        this.fechan = fechan;
        this.direcion = direcion;
        this.celular = celular;
        this.email = email;
        this.sexo = sexo;
        this.procedencia = procedencia;
        this.alergia = alergia;
        this.limitaciones = limitaciones;
        this.estado = estado;
        this.idapoderado = idapoderado;
        this.idgrado = idgrado;
        this.diaregistro = diaregistro;
        this.foto = foto;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.desapoderado=desapoderado;
        this.desgrado=desgrado;
    }

   


    public ALUMNO() {
        this.idalumno = 0;
        this.dni = "";
        this.foto="";
        this.nom = "";
        this.apellidos = "";
        this.fechan = "";
        this.direcion = "";
        this.celular = "";
        this.email = "";
        this.sexo = "";
        this.procedencia = "";
        this.alergia = "";
        this.limitaciones = "";
        this.estado = "";
        this.idapoderado = 0;
        this.idgrado = 0;
        this.diaregistro = "";
        this.usuario="";
        this.contraseña="";
        this.desapoderado="";
        this.desgrado="";
    }
    
    
      private CallableStatement Cst;
    private ResultSet R;

    public DefaultTableModel ListaAlumnos(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"Nombres:", "Fecha_Nacimiento:", "DNI:", "Sexo:", "Procedencia:", "Direccion:"};
            Cst = Cn.prepareCall("CALL SP_LISTARALU();");

            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[6];
                for (int i = 0; i < 6; i++) {
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
    
    
    //LISTA DE ALUMNOS POR GRADO
    
    public DefaultTableModel ListaAlumnosPorGrado( int grado, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"Nombres:", "ape:", "DNI:"};
            Cst = Cn.prepareCall("CALL sp_alumnos_grado(?);");
             Cst.setInt(1, grado);

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
 public DefaultTableModel ListaAlumnosNoMatriculados(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"Nombres:", "Fecha_Nacimiento:", "DNI:", "Sexo:", "Procedencia:", "Direccion:"};
            Cst = Cn.prepareCall("CALL SP_LISTA_ALUMNO_NO_MATRICULADOS();");

            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[6];
                for (int i = 0; i < 6; i++) {
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
    
    
    

    public DefaultTableModel ListaSeleccionaAlumno(int ve, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"idalumno:", "alumno:"};
            Cst = Cn.prepareCall("CALL sp_SELECCIONA_ALUMNO_PARA_NOTA(?);");
             Cst.setInt(1, ve);
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
    //--  ALUNOS Y CURSOS QUE LLEVA
     public DefaultTableModel ListaCursosdeAlumno(int gr, int al, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"alumno:", "idcurso:", "curso:"};
            Cst = Cn.prepareCall("CALL sp_SELECCIONA_GRADO_ALUMNO_PARANOTA(?,?);");
             Cst.setInt(1, gr);
             Cst.setInt(2, al);
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

    
    
    
    public static ArrayList<ALUMNO> ListaAlumnoNoMatriculados() {
        try {
            String SQL = "select * from alumno where estado='NO MATRICULADO' ";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<ALUMNO> lista = new ArrayList<>();
            ALUMNO a;
            while (resultado.next()) {
                a = new ALUMNO();
                a.setIdalumno(resultado.getInt(1));
                a.setDni(resultado.getString(2));
                a.setFoto(resultado.getString(3));
                a.setNom(resultado.getString(4));
                a.setApellidos(resultado.getString(5));
                a.setFechan(resultado.getString(6));
                a.setDirecion(resultado.getString(7));
                a.setCelular(resultado.getString(8));
                a.setEmail(resultado.getString(9));
                a.setSexo(resultado.getString(10));
                a.setProcedencia(resultado.getString(11));
                a.setAlergia(resultado.getString(12));
                a.setLimitaciones(resultado.getString(13));
                a.setUsuario(resultado.getString(14));
                a.setContraseña(resultado.getString(15));
                a.setIdapoderado(resultado.getInt(16));
                a.setIdgrado(resultado.getInt(17));
                a.setDiaregistro(resultado.getString(18));
                a.setEstado(resultado.getString(19));
                lista.add(a);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
     public static ArrayList<ALUMNO> ListaAlumnoMatricula() {
        try {
            String SQL = "SELECT  * FROM ALUMNO WHERE ESTADO='PAGO MATRICULA' ";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<ALUMNO> lista = new ArrayList<>();
            ALUMNO a;
            while (resultado.next()) {
                a = new ALUMNO();
                a.setIdalumno(resultado.getInt(1));
                a.setDni(resultado.getString(2));
                a.setFoto(resultado.getString(3));
                a.setNom(resultado.getString(4));
                a.setApellidos(resultado.getString(5));
                a.setFechan(resultado.getString(6));
                a.setDirecion(resultado.getString(7));
                a.setCelular(resultado.getString(8));
                a.setEmail(resultado.getString(9));
                a.setSexo(resultado.getString(10));
                a.setProcedencia(resultado.getString(11));
                a.setAlergia(resultado.getString(12));
                a.setLimitaciones(resultado.getString(13));
                a.setUsuario(resultado.getString(14));
                a.setContraseña(resultado.getString(15));
                a.setIdapoderado(resultado.getInt(16));
                a.setIdgrado(resultado.getInt(17));
                a.setDiaregistro(resultado.getString(18));
                a.setEstado(resultado.getString(19));
                lista.add(a);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    public static ArrayList<ALUMNO> ListaAlumno() {
        try {
            String SQL = "select * from alumno";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<ALUMNO> lista = new ArrayList<>();
            ALUMNO a;
            while (resultado.next()) {
                a = new ALUMNO();
                a.setIdalumno(resultado.getInt(1));
                a.setDni(resultado.getString(2));
                a.setFoto(resultado.getString(3));
                a.setNom(resultado.getString(4));
                a.setApellidos(resultado.getString(5));
                a.setFechan(resultado.getString(6));
                a.setDirecion(resultado.getString(7));
                a.setCelular(resultado.getString(8));
                a.setEmail(resultado.getString(9));
                a.setSexo(resultado.getString(10));
                a.setProcedencia(resultado.getString(11));
                a.setAlergia(resultado.getString(12));
                a.setLimitaciones(resultado.getString(13));
                a.setUsuario(resultado.getString(14));
                a.setContraseña(resultado.getString(15));
                a.setIdapoderado(resultado.getInt(16));
                a.setIdgrado(resultado.getInt(17));
                a.setDiaregistro(resultado.getString(18));
                a.setEstado(resultado.getString(19));
                lista.add(a);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
            
     public static boolean RegistrarAlumno( ALUMNO car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_ALUMNO_INGRESA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            sp.setString(1, car.getDni());
            sp.setString(2, car.getFoto());
             sp.setString(3, car.getNom());
            sp.setString(4, car.getApellidos());
             sp.setString(5, car.getFechan());
            sp.setString(6, car.getDirecion());
             sp.setString(7, car.getCelular());
            sp.setString(8, car.getEmail());
             sp.setString(9, car.getSexo());
            sp.setString(10, car.getProcedencia());
             sp.setString(11, car.getAlergia());
             sp.setString(12, car.getLimitaciones());
            sp.setString(13, car.getUsuario());
             sp.setString(14, car.getContraseña()); 
             sp.setInt(15, car.getIdapoderado());
             sp.setInt(16, car.getIdgrado());
            if (sp.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    } 
     
     
    //-----------------------------------------------------------------
   public static boolean EliminaAlumno(ALUMNO car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_ALUMNO_ELIMINA(?)}");
            sp.setInt(1, car.getIdalumno());
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
    public static ALUMNO getIdALUMNOIds(String id) throws SQLException {
       ALUMNO car = new ALUMNO();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_alumno_ids where idalumno=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdalumno(rs.getInt(1));
                car.setDni(rs.getString(2));
                car.setFoto(rs.getString(3));
                car.setNom(rs.getString(4));
                car.setApellidos(rs.getString(5));
                car.setFechan(rs.getString(6));
                car.setDirecion(rs.getString(7));
                car.setCelular(rs.getString(8));
                car.setEmail(rs.getString(9));
                car.setSexo(rs.getString(10));
                car.setProcedencia(rs.getString(11));
                car.setAlergia(rs.getString(12));
                car.setLimitaciones(rs.getString(13));
                car.setUsuario(rs.getString(14));
                car.setContraseña(rs.getString(15));
                car.setIdapoderado(rs.getInt(16));
                car.setIdgrado(rs.getInt(17));
                 car.setEstado(rs.getString(18));
                car.setDiaregistro(rs.getString(19));
               
                
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }

   
   
//VISTA DE APODERADO
    public static ALUMNO getIdALUMNO(String id) throws SQLException {
       ALUMNO car = new ALUMNO();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_alumno where idalumno=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdalumno(rs.getInt(1));
                car.setDni(rs.getString(2));
                car.setFoto(rs.getString(3));
                car.setNom(rs.getString(4));
                car.setApellidos(rs.getString(5));
                car.setFechan(rs.getString(6));
                car.setDirecion(rs.getString(7));
                car.setCelular(rs.getString(8));
                car.setEmail(rs.getString(9));
                car.setSexo(rs.getString(10));
                car.setProcedencia(rs.getString(11));
                car.setAlergia(rs.getString(12));
                car.setLimitaciones(rs.getString(13));
                car.setUsuario(rs.getString(14));
                car.setContraseña(rs.getString(15));
                car.setDesapoderado(rs.getString(16));
                car.setDesgrado(rs.getString(17));
                car.setDiaregistro(rs.getString(18));
                car.setEstado(rs.getString(19));
                
               
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }

    //MODIFICACION 
public static boolean modificaAlumno(ALUMNO q) {
        try {
            CallableStatement cs=null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_ALUMNO_MODIFICA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1,q.getIdalumno());
             ps.setString(2, q.getDni());
            ps.setString(3, q.getFoto());
             ps.setString(4, q.getNom());
            ps.setString(5, q.getApellidos());
             ps.setString(6, q.getFechan());
            ps.setString(7, q.getDirecion());
             ps.setString(8, q.getCelular());
            ps.setString(9, q.getEmail());
             ps.setString(10, q.getSexo());
            ps.setString(11, q.getProcedencia());
             ps.setString(12, q.getAlergia());
              ps.setString(13, q.getLimitaciones());
             ps.setString(14, q.getUsuario());
            ps.setString(15, q.getContraseña());
             ps.setInt(16, q.getIdapoderado());
             ps.setInt(17, q.getIdgrado());
             ps.setString(18, q.getEstado());
            if (ps.executeUpdate()>0) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {

        }
        return false;
    }

     
         public static ArrayList<ALUMNO> ListaAlumnoEstudiando() {
        try {
            String SQL = "SELECT  * FROM ALUMNO WHERE ESTADO='MATRICULADO' ";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<ALUMNO> lista = new ArrayList<>();
            ALUMNO a;
            while (resultado.next()) {
                a = new ALUMNO();
                a.setIdalumno(resultado.getInt(1));
                a.setDni(resultado.getString(2));
                a.setFoto(resultado.getString(3));
                a.setNom(resultado.getString(4));
                a.setApellidos(resultado.getString(5));
                a.setFechan(resultado.getString(6));
                a.setDirecion(resultado.getString(7));
                a.setCelular(resultado.getString(8));
                a.setEmail(resultado.getString(9));
                a.setSexo(resultado.getString(10));
                a.setProcedencia(resultado.getString(11));
                a.setAlergia(resultado.getString(12));
                a.setLimitaciones(resultado.getString(13));
                a.setUsuario(resultado.getString(14));
                a.setContraseña(resultado.getString(15));
                a.setIdapoderado(resultado.getInt(16));
                a.setIdgrado(resultado.getInt(17));
                a.setDiaregistro(resultado.getString(18));
                a.setEstado(resultado.getString(19));
                lista.add(a);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
         
         
           //--  ALUNOS Y CURSOS QUE LLEVA del profesor
     public DefaultTableModel ListaCursosdeAlumnoProfesor(int gr, int al,int idd, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"alumno:", "idcurso:", "curso:"};
            Cst = Cn.prepareCall("CALL sp_ALUMNO_GRADO_DOCENTE(?,?,?);");
             Cst.setInt(1, gr);
             Cst.setInt(2, al);
              Cst.setInt(3, idd);
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
}
