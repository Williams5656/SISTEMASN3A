package modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UsuarioBD extends UsuarioMD {

    Conectar conectar = new Conectar();

    public List<UsuarioMD> mostrardatos() {
        try {
            List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
            String sql = "select * from usuario ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD User = new UsuarioMD();
                User.setCodUsuario(rs.getString("CODUSR"));
                User.setCedula(rs.getString("CEDULA"));
                User.setUsuario(rs.getString("USUARIO"));
                User.setClave(rs.getString("CLAVE"));
                User.setRol(rs.getString("CODROL"));
                User.setEstado(rs.getString("ESTADO"));
                lista.add(User);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public DefaultComboBoxModel NombreROL() {
        DefaultComboBoxModel listaroles = new DefaultComboBoxModel();
        ResultSet rs = conectar.query("Select * from roles order by nombre");
        try {
            while (rs.next()) {
                listaroles.addElement(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listaroles;
    }

    public boolean insertar() {
        String sql = "INSERT INTO usuario(codusr, cedula, usuario, clave, codrol, estado)" + "VALUES ('" + getCodUsuario() + "','" + getCedula() + "','" + getUsuario() + "','" + getClave() + "','" + getRol() + "','" + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codUsuario) {
        String sql = "update usuario set \"cedula\"='" + getCedula() + "',\"usuario\"='" + getUsuario() + "',\"clave\"='" + getClave() + "',\"codrol\"='" + getRol() + "',\"estado\"='" + getEstado() + "'"
                + "where \"codusr\"='" + codUsuario + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE EDITAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<UsuarioMD> obtenerdatos(String codUsuario) {
        try {
            List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
            String sql = "select * from usuario where \"codusr\"='" + codUsuario + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD User = new UsuarioMD();
                User.setCodUsuario(rs.getString("CODUSR"));
                User.setCedula(rs.getString("CEDULA"));
                User.setUsuario(rs.getString("USUARIO"));
                User.setClave(rs.getString("CLAVE"));
                User.setRol(rs.getString("CODROL"));
                User.setEstado(rs.getString("ESTADO"));
                lista.add(User);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
     public List<UsuarioMD> buscardatos(String codUsuario) {
        try {
            List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
            String sql = "select * from usuario where \"codusr\" ILIKE '%" + codUsuario + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD User = new UsuarioMD();
                User.setCodUsuario(rs.getString("CODUSR"));
                User.setCedula(rs.getString("CEDULA"));
                User.setUsuario(rs.getString("USUARIO"));
                User.setClave(rs.getString("CLAVE"));
                User.setRol(rs.getString("CODROL"));
                User.setEstado(rs.getString("ESTADO"));
                lista.add(User);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codUsuario) {
        String nsql = "delete from usuario where \"codusr\"='" + codUsuario + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public UsuarioMD validar(String User, String Pass) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        UsuarioMD UserVal = new UsuarioMD();
        String validar = "Select * From usuario\n"
                + "where usuario.usuario=? and usuario.clave=?;";
        try {
            con = conectar.getCon();

            st = con.prepareStatement(validar);
            st.setString(1, User);
            st.setString(2, Pass);
            rs = st.executeQuery();

            while (rs.next()) {

                UserVal.setCodUsuario(rs.getString("CODUSR"));
                UserVal.setCedula(rs.getString("CEDULA"));
                UserVal.setUsuario(rs.getString("USUARIO"));
                UserVal.setClave(rs.getString("CLAVE"));
                UserVal.setRol(rs.getString("CODROL"));
                UserVal.setEstado(rs.getString("ESTADO"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return UserVal;
    }

}
