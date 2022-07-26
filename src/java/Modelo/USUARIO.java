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
public class USUARIO {
    
      private int idusuario;
    private String dni;
    private String foto;
    private String nombres;
    private String apellidos;
    private String genero;
    private String fnacimiento;
    private String email;
    private String telefono;
    private String celular;
    private String direccion;
     private int diaIngreso;
    private String usuario;
    private String clave;
    private String estado;  
    private int idcargo;
    private String descargo;

    public String getDescargo() {
        return descargo;
    }

    public void setDescargo(String descargo) {
        this.descargo = descargo;
    }

    public String getDescar() {
        return descar;
    }

    public void setDescar(String descar) {
        this.descar = descar;
    }
    private String descar;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(String fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public int getDiaIngreso() {
        return diaIngreso;
    }

    public void setDiaIngreso(int diaIngreso) {
        this.diaIngreso = diaIngreso;
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

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public USUARIO(int idusuario, String dni, String foto, String nombres, String apellidos, String genero, String fnacimiento, String email, String telefono, String celular, String direccion, int diaIngreso, String usuario, String clave, String estado, int idcargo, String descar) {
        this.idusuario = idusuario;
        this.dni = dni;
        this.foto = foto;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fnacimiento = fnacimiento;
        this.email = email;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.diaIngreso = diaIngreso;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.idcargo = idcargo;
        this.descar=descar;
       
    }
     public USUARIO() {
        this.idusuario = 0;
        this.dni = "";
        this.foto = "";
        this.nombres = "";
        this.apellidos = "";
        this.genero = "";
        this.fnacimiento = "";
        this.email = "";
        this.telefono = "";
        this.celular = "";
        this.direccion = "";
        this.diaIngreso = 0;
        this.usuario = "";
        this.clave = "";
        this.estado = "";
        this.idcargo = 0;
        this.descar="";
    }
    
     
      private CallableStatement Cst;
    private ResultSet R;

    public DefaultTableModel ListauSUARIOS(Connection Cn) {
        try {
            DefaultTableModel c;
            String[] Titulos = {"Nombres:", "DNI:", "Fecha_Nacimiento:", "Genero:", "Celular:", "Direccion:"};
            Cst = Cn.prepareCall("CALL SP_LISTAuSUARIOS();");

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

    
    public static boolean RegistrarUsuario( USUARIO car) {
        try {   
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_USUARIO_INGRESA(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            sp.setString(1, car.getDni());
            sp.setString(2, car.getFoto());
             sp.setString(3, car.getNombres());
            sp.setString(4, car.getApellidos());
             sp.setString(5, car.getGenero());
            sp.setString(6, car.getFnacimiento());
             sp.setString(7, car.getEmail());
            sp.setString(8, car.getTelefono());
            sp.setString(9, car.getCelular());
             sp.setString(10, car.getDireccion());
            sp.setString(11, car.getUsuario());
            sp.setString(12, car.getEstado());
             sp.setInt(13, car.getIdcargo());
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
    public static ArrayList<USUARIO> ListaUsuario() {
        try {
            String SQL = "select * from usuario";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareCall(SQL);
            ResultSet resultado = st.executeQuery();
            ArrayList<USUARIO> lista = new ArrayList<>();
            USUARIO car;
            while (resultado.next()) {
                car = new USUARIO();
                car.setIdusuario(resultado.getInt(1));
                car.setDni(resultado.getString(2));
                car.setFoto(resultado.getString(3));
                car.setNombres(resultado.getString(4));
                car.setApellidos(resultado.getString(5));
                car.setGenero(resultado.getString(6));
                car.setFnacimiento(resultado.getString(7));
                car.setEmail(resultado.getString(8));
                car.setTelefono(resultado.getString(9));
                car.setCelular(resultado.getString(10 ));
                car.setDireccion(resultado.getString(11));
                car.setDiaIngreso(resultado.getInt(12));
                car.setUsuario(resultado.getString(13));
                car.setClave(resultado.getString(14));
                car.setEstado(resultado.getString(15));
                car.setIdcargo(resultado.getInt(16));
                lista.add(car);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //-----------------------------------------------------------------
   public static boolean EliminaUsuario(USUARIO car) {
        try {
            CallableStatement cs = null;
            Connection con = Conexion.conectar();
            CallableStatement sp = con.prepareCall("{call sp_USUARIO_ELIMINA(?)}");
            sp.setInt(1, car.getIdusuario());
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
    public static USUARIO getIdUsuario(String id) throws SQLException {
       USUARIO car = new USUARIO();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_usuario where idusuario=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
         car.setIdusuario(rs.getInt(1));
                car.setDni(rs.getString(2));
                car.setFoto(rs.getString(3));
                car.setNombres(rs.getString(4));
                car.setApellidos(rs.getString(5));
                car.setGenero(rs.getString(6));
                car.setFnacimiento(rs.getString(7));
                car.setEmail(rs.getString(8));
                car.setTelefono(rs.getString(9));
                car.setCelular(rs.getString(10));
                car.setDireccion(rs.getString(11));
                car.setDiaIngreso(rs.getInt(12));
                car.setUsuario(rs.getString(13));
                car.setClave(rs.getString(14));
                car.setEstado(rs.getString(15));
                car.setDescar(rs.getString(16));
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
     public static USUARIO getIdUsuarioid(String id) throws SQLException {
       USUARIO car = new USUARIO();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select * from v_usuario_id where idusuario=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
         car.setIdusuario(rs.getInt(1));
                car.setDni(rs.getString(2));
                car.setFoto(rs.getString(3));
                car.setNombres(rs.getString(4));
                car.setApellidos(rs.getString(5));
                car.setGenero(rs.getString(6));
                car.setFnacimiento(rs.getString(7));
                car.setEmail(rs.getString(8));
                car.setTelefono(rs.getString(9));
                car.setCelular(rs.getString(10));
                car.setDireccion(rs.getString(11));
                car.setDiaIngreso(rs.getInt(12));
                car.setUsuario(rs.getString(13));
                car.setClave(rs.getString(14));
                car.setEstado(rs.getString(15));
                car.setIdcargo(rs.getInt(16));
                con.close();

            }
        } catch (SQLException ex) {

        }
        return car;
    }
    //MODIFICACION 
public static boolean modificaUsuario(USUARIO car) {
        try {
            CallableStatement cs=null;
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("{call sp_USUARIO_MODIFICA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1,car.getIdusuario());
             ps.setString(2, car.getDni());
            ps.setString(3, car.getFoto());
             ps.setString(4, car.getNombres());
            ps.setString(5, car.getApellidos());
             ps.setString(6, car.getGenero());
            ps.setString(7, car.getFnacimiento());
             ps.setString(8, car.getEmail());
            ps.setString(9, car.getTelefono());
            ps.setString(10, car.getCelular());
             ps.setString(11, car.getDireccion());
            ps.setString(12, car.getUsuario());
             ps.setString(13, car.getClave());
              ps.setString(14, car.getEstado());
             ps.setInt(15, car.getIdcargo());
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
