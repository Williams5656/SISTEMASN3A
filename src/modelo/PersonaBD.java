package modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.postgresql.util.Base64;
import vista.*;

public class PersonaBD extends PersonaMD {

    Conectar conectar = new Conectar();
    public static V_Persona Vistapersona;
    String ef = null;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public List<PersonaMD> mostrardatos() {
        try {
            List<PersonaMD> listapersona = new ArrayList<>();
            String sql = "select * from persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PersonaMD m = new PersonaMD();
                m.setCedula(rs.getString("CEDULA"));
                m.setNombres(rs.getString("NOMBRES"));
                m.setApellidos(rs.getString("APELLIDOS"));
                m.setUsuario(rs.getString("USUARIO"));
                m.setClave(rs.getString("CLAVE"));
                m.setTelefono(rs.getString("TELEFONO"));
                m.setCorreo(rs.getString("CORREO_ELECTRONICO"));
                m.setRol(rs.getString("ROL"));
                m.setFoto_perfil((Image) rs.getObject("NOMBRES"));
                listapersona.add(m);
            }
            rs.close();
            return listapersona;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO persona(cedula, nombres, apellidos, usuario, clave, telefono, correo_electronico, rol, \"foto \")" + "VALUES ('" + getCedula() + "','" + getNombres() + "','" + getApellidos() + "','" + getUsuario() + "','" + getClave() + "','" + getTelefono() + "','" + getCorreo() + "','" + getRol() + "','" + getFoto_perfil() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }

    }

    public boolean modificar(String cedula) {
        String sql = "update persona set \"nombres\"='" + getNombres() + "',\"apellidos\"='" + getApellidos() + "',\"usuario\"='" + getUsuario() + "',\"clave\"='" + getClave() + "',\"telefono\"='" + getTelefono() + "',\"correo_electronico\"='" + getCorreo() + "',\"rol\"='" + getRol() + "',\"\"foto \"\"='" + getFoto_perfil() + "'"
                + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");

            return false;
        }
    }

    public List<PersonaMD> obtenerdatos(String cedula) {
        try {
            List<PersonaMD> listapersona = new ArrayList<>();
            String sql = "select * from persona" + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PersonaMD m = new PersonaMD();
                m.setCedula(rs.getString("CEDULA"));
                m.setNombres(rs.getString("NOMBRES"));
                m.setApellidos(rs.getString("APELLIDOS"));
                m.setUsuario(rs.getString("USUARIO"));
                m.setClave(rs.getString("CLAVE"));
                m.setTelefono(rs.getString("TELEFONO"));
                m.setCorreo(rs.getString("CORREO_ELECTRONICO"));
                m.setRol(rs.getString("ROL"));
                m.setFoto_perfil((Image) rs.getObject("NOMBRES"));
                listapersona.add(m);
            }
            rs.close();
            return listapersona;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean Eliminar(String cedula) {
        String sql = "Delete from persona "
                + "where \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al Eliminar");
            return false;
        }
    }

    public PersonaMD validar(String User, String Pass) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        PersonaMD m = new PersonaMD();
        String validar = "Select * From persona\n"
                + "where persona.usuario=? and persona.clave=?;";
        try {
            con = conectar.getCon();
            st = con.prepareStatement(validar);
            st.setString(1, User);
            st.setString(2, Pass);
            rs = st.executeQuery();
            while (rs.next()) {
                m.setCedula(rs.getString("CEDULA"));
                m.setNombres(rs.getString("NOMBRES"));
                m.setApellidos(rs.getString("APELLIDOS"));
                m.setUsuario(rs.getString("USUARIO"));
                m.setClave(rs.getString("CLAVE"));
                m.setTelefono(rs.getString("TELEFONO"));
                m.setCorreo(rs.getString("CORREO_ELECTRONICO"));
                m.setRol(rs.getString("ROL"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return m;
    }

}
