/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.io.Serializable;
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
 * @author Cristhian Infante
 */
public class Apoderado implements Serializable{
    private int idApoderado;
    private String dni;
    private String foto;
    private String nombre;
    private String apellidos;
    private String genero;
    private String fechanacimiento;
    private String email;
    private String celular;
    private String direccion;
    private String usuario;
    private String clave;
    private String estado;
    private String diaRegistar;
    private String parentesco;
    private String nivelacademico;
    private String oficio;

    public Apoderado() {
         this.idApoderado = 0;
        this.dni = "";
        this.foto = "";
        this.nombre = "";
        this.apellidos = "";
        this.genero = "";
        this.fechanacimiento = "";
        this.email = "";
        this.celular = "";
        this.direccion = "";
        this.usuario = "";
        this.clave = "";
        this.estado = "";
        this.diaRegistar = "";
        this.parentesco = "";
        this.nivelacademico = "";
        this.oficio = "";
    }

    public Apoderado(int idApoderado, String dni, String foto, String nombre, String apellidos, String genero, String fechanacimiento, String email, String celular, String direccion, String usuario, String clave, String estado, String diaRegistar, String parentesco, String nivelacademico, String oficio) {
        this.idApoderado = idApoderado;
        this.dni = dni;
        this.foto = foto;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.celular = celular;
        this.direccion = direccion;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.diaRegistar = diaRegistar;
        this.parentesco = parentesco;
        this.nivelacademico = nivelacademico;
        this.oficio = oficio;
    }

    public int getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(int idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDiaRegistar() {
        return diaRegistar;
    }

    public void setDiaRegistar(String diaRegistar) {
        this.diaRegistar = diaRegistar;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getNivelacademico() {
        return nivelacademico;
    }

    public void setNivelacademico(String nivelacademico) {
        this.nivelacademico = nivelacademico;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
    
      private CallableStatement Cst;
    private ResultSet R;

    public DefaultTableModel ListaApoderados(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"Nombres:", "DNI:", "Fecha_Nacimiento:", "Genero:", "Celular:", "Parentesco:"};
            Cst = Cn.prepareCall("CALL sp_listaapoderados();");

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

    public static boolean RegistrarApoderado(Apoderado car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_APODERADO_INGRESA(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            sp.setString(1, car.getDni());
            sp.setString(2, car.getFoto());
            sp.setString(3, car.getNombre());
            sp.setString(4, car.getApellidos());
            sp.setString(5, car.getGenero());
            sp.setString(6, car.getFechanacimiento());
            sp.setString(7, car.getEmail());
            sp.setString(8, car.getCelular());
            sp.setString(9, car.getDireccion());
            sp.setString(10, car.getUsuario());
            sp.setString(11, car.getClave());
            sp.setString(12, car.getParentesco());
            sp.setString(13, car.getNivelacademico());
            sp.setString(14, car.getOficio());
            if (sp.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    public static ArrayList<Apoderado> ListaApoderado() {
        try {
            String SQL = "select * from apoderado";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<Apoderado> lista = new ArrayList<>();
            Apoderado e;
            while (resultado.next()) {
                e = new Apoderado();
                e.setIdApoderado(resultado.getInt(1));
                e.setDni(resultado.getString(2));
                e.setFoto(resultado.getString(3));
                e.setNombre(resultado.getString(4));
                e.setApellidos(resultado.getString(5));
                e.setGenero(resultado.getString(6));
                e.setFechanacimiento(resultado.getString(7));
                e.setEmail(resultado.getString(8));
                e.setCelular(resultado.getString(9));
                e.setDireccion(resultado.getString(10));
                e.setUsuario(resultado.getString(11));
                e.setClave(resultado.getString(12));
                e.setEstado(resultado.getString(13));
                e.setDiaRegistar(resultado.getString(14));
                e.setParentesco(resultado.getString(15));
                e.setNivelacademico(resultado.getString(16));
                e.setOficio(resultado.getString(17));
                lista.add(e);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static Apoderado getIdAPODERADO(String id) throws SQLException {
        Apoderado car = new Apoderado();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_apoderado where idapoderado=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdApoderado(rs.getInt(1));
                car.setDni(rs.getString(2));
                car.setFoto(rs.getString(3));
                car.setNombre(rs.getString(4));
                car.setApellidos(rs.getString(5));
                car.setGenero(rs.getString(6));
                car.setFechanacimiento(rs.getString(7));
                car.setEmail(rs.getString(8));
                car.setCelular(rs.getString(9));
                car.setDireccion(rs.getString(10));
                car.setUsuario(rs.getString(11));
                car.setClave(rs.getString(12));
                car.setEstado(rs.getString(13));
                car.setDiaRegistar(rs.getString(14));
                car.setParentesco(rs.getString(15));
                car.setNivelacademico(rs.getString(16));
                car.setOficio(rs.getString(17));
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
    //MODIFICACION 

    public static boolean modificaApoderado(Apoderado q) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_APODERADO_MODIFICA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, q.getIdApoderado());
            ps.setString(2, q.getDni());
            ps.setString(3, q.getFoto());
            ps.setString(4, q.getNombre());
            ps.setString(5, q.getApellidos());
            ps.setString(6, q.getGenero());
            ps.setString(7, q.getFechanacimiento());
            ps.setString(8, q.getEmail());
            ps.setString(9, q.getCelular());
            ps.setString(10, q.getDireccion());
            ps.setString(11, q.getUsuario());
            ps.setString(12, q.getClave());
            ps.setString(13, q.getEstado());
            ps.setString(14, q.getParentesco());
            ps.setString(15, q.getNivelacademico());
            ps.setString(16, q.getOficio());
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {

        }
        return false;
    }
//VISTA DE APODERADO

    public static Apoderado getIdApoderado(String id) throws SQLException {
        Apoderado car = new Apoderado();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_apoderado where idapoderado=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setIdApoderado(rs.getInt(1));
                car.setDni(rs.getString(2));
                car.setFoto(rs.getString(3));
                car.setNombre(rs.getString(4));
                car.setApellidos(rs.getString(5));
                car.setGenero(rs.getString(6));
                car.setFechanacimiento(rs.getString(7));
                car.setEmail(rs.getString(8));
                car.setCelular(rs.getString(9));
                car.setDireccion(rs.getString(10));
                car.setUsuario(rs.getString(11));
                car.setClave(rs.getString(12));
                car.setEstado(rs.getString(13));
                car.setDiaRegistar(rs.getString(14));
                car.setParentesco(rs.getString(15));
                car.setNivelacademico(rs.getString(16));
                car.setOficio(rs.getString(17));
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
      public static boolean EliminaApoderado(Apoderado car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_APODERADO_ELIMINA(?)}");
            sp.setInt(1, car.getIdApoderado());
            if (sp.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

       public DefaultTableModel DocentesAlumno(int idap, Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"id:", "nom:"};
            Cst = Cn.prepareCall("CALL sp_ALUMNOS_POR_APODERADO(?);");
            Cst.setInt(1, idap);
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
}
