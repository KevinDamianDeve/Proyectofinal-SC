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
public class DOCENTE {
    private int iddodocente;
    private String foto;
    private int dni;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String  telefono_fijo;
    private String celular;
    private String fecha_n;
    private String titulo;
    private String estado;
    private String diaReg;
    private String usuario;
    private String contra;
    private String correo;

    public DOCENTE() {
    }

    public DOCENTE(int iddodocente, String foto, int dni, String nombres, String apellidos, String direccion, String telefono_fijo, String celular, String fecha_n, String titulo, String estado, String diaReg, String usuario, String contra, String correo) {
        this.iddodocente = iddodocente;
        this.foto = foto;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono_fijo = telefono_fijo;
        this.celular = celular;
        this.fecha_n = fecha_n;
        this.titulo = titulo;
        this.estado = estado;
        this.diaReg = diaReg;
        this.usuario = usuario;
        this.contra = contra;
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
  

    public int getIddodocente() {
        return iddodocente;
    }

    public void setIddodocente(int iddodocente) {
        this.iddodocente = iddodocente;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(String telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFecha_n() {
        return fecha_n;
    }

    public void setFecha_n(String fecha_n) {
        this.fecha_n = fecha_n;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDiaReg() {
        return diaReg;
    }

    public void setDiaReg(String diaReg) {
        this.diaReg = diaReg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public static boolean RegistrarDocente(DOCENTE car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_DOCENTE_INGRESA(?,?,?,?,?,?,?,?,?,?,?,?)}");
            sp.setString(1, car.getFoto());
            sp.setInt(2, car.getDni());            
             sp.setString(3, car.getNombres());
            sp.setString(4, car.getApellidos());
             sp.setString(5, car.getDireccion());
            sp.setString(6, car.getTelefono_fijo());
             sp.setString(7, car.getCelular());
            sp.setString(8, car.getFecha_n());
            sp.setString(9, car.getCorreo()); 
            sp.setString(10, car.getTitulo());
             sp.setString(11, car.getUsuario());
            sp.setString(12, car.getContra());
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
    public static ArrayList<DOCENTE> ListaDocente() {
        try {
            String SQL = "select * from docente";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<DOCENTE> lista = new ArrayList<>();
            DOCENTE car;
            while (resultado.next()) {
                car = new DOCENTE();
                car.setIddodocente(resultado.getInt(1));
                car.setFoto(resultado.getString(2));
                car.setDni(resultado.getInt(3));
                car.setNombres(resultado.getString(4));
                car.setApellidos(resultado.getString(5));
                car.setDireccion(resultado.getString(6));
                car.setTelefono_fijo(resultado.getString(7));
                car.setCelular(resultado.getString(8));
                car.setFecha_n(resultado.getString(9));
                car.setCorreo(resultado.getString(10));
                car.setTitulo(resultado.getString(11));
                car.setEstado(resultado.getString(12));
                car.setDiaReg(resultado.getString(13));
                car.setUsuario(resultado.getString(14));
                car.setContra(resultado.getString(15));
                lista.add(car);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //-----------------------------------------------------------------
   public static boolean EliminaDocente(DOCENTE car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_DOCENTE_ELIMINA(?)}");
            sp.setInt(1, car.getIddodocente());
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
     public static DOCENTE getIdDocente(String id) throws SQLException {
       DOCENTE car = new DOCENTE();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_docente where idDocente=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIddodocente(rs.getInt(1));
                car.setFoto(rs.getString(2));
                car.setDni(rs.getInt(3));
                car.setNombres(rs.getString(4));
                car.setApellidos(rs.getString(5));
                car.setDireccion(rs.getString(6));
                car.setTelefono_fijo(rs.getString(7));
                car.setCelular(rs.getString(8));
                car.setFecha_n(rs.getString(9));
                car.setCorreo(rs.getString(10));
                car.setTitulo(rs.getString(11));
                car.setEstado(rs.getString(12));
                car.setDiaReg(rs.getString(13));
                car.setUsuario(rs.getString(14));
                car.setContra(rs.getString(15));
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
    //MODIFICACION 
public static boolean modificaDocente(DOCENTE car) {
        try {
            CallableStatement cs=null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_DOCENTE_MODIFICA(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1,car.getIddodocente());
             ps.setString(2, car.getFoto());
            ps.setInt(3, car.getDni());
             ps.setString(4, car.getNombres());
            ps.setString(5, car.getApellidos());
             ps.setString(6, car.getDireccion());
            ps.setString(7, car.getTelefono_fijo());
             ps.setString(8, car.getCelular());
            ps.setString(9, car.getFecha_n());
            ps.setString(10, car.getCorreo());
             ps.setString(11, car.getTitulo());
            ps.setString(12, car.getEstado());
             ps.setString(13, car.getUsuario());
              ps.setString(14, car.getContra());
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

    public DefaultTableModel ListaDocentes(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"Nombres:", "DNI:", "Fecha_Nacimiento:", "direccion:", "Celular:", "correo:"};
            Cst = Cn.prepareCall("CALL sp_LISTA_DOCENTE();");

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
    


    public DefaultTableModel ListaCursosdelDocente(int iddocente, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = { "id:", "grado:","idcurso:", "curso:"};
            Cst = Cn.prepareCall("CALL sp_Cursos_del_Docente(?);");
             Cst.setInt(1, iddocente);
            Cn.setAutoCommit(false);
            R = Cst.executeQuery();
            c = new DefaultTableModel(null, Titulos);
            while (R.next()) {
                Object dato[] = new Object[4];
                for (int i = 0; i < 4; i++) {
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
