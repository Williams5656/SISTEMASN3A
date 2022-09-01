package MUEBLES.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Usuario_BD extends M_usuario_MD {

    Conect conectar = new Conect();
   
    public Usuario_BD(String codigo, String cedula_persona, String usuario, String contrasena, String codigo_rol, String estado) {
        super(codigo, cedula_persona, usuario, contrasena, codigo_rol, estado);
    }

    public Usuario_BD() {
    }

    public List<M_usuario_MD> mostrardatos() {
        try {
            List<M_usuario_MD> lista = new ArrayList<M_usuario_MD>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                M_usuario_MD m = new M_usuario_MD();
                m.setCodigo(rs.getString("codigo"));
                m.setCedula_persona(rs.getString("cdlper"));
                m.setUsuario(rs.getString("nomusuario"));
                m.setCodigo_rol(rs.getString("codrol"));
                m.setEstado(rs.getString("estado"));
                
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(M_personaMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insert() {

        String sql = "insert into usuario(codigo, cdlper, nomusuario, contrasena, codrol, estado)" + "values ('" + getCodigo() + "','" + getCedula_persona() + "','" + getUsuario() + "','" + getContrasena() + "','" + getCodigo_rol() + "','" + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "¡ Falla al insertar !");
            return false;
        }
    }

    public boolean modificar(String codigo) {

        String sql = "update usuaio set \"cdlper\"='" + getCedula_persona() + "',\"nomusuario\"='" + getUsuario() + "',\"contrasena\"='" + getContrasena() + "',\"codrol\"='" + getCodigo_rol() + "',\"estado\"='" + getEstado() + "'" + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public boolean eliminar(String codigo) {
        String sql = "delete from usuario" + " where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }
    }

    public List<M_usuario_MD> obtenerdatos(String codigo) {
        try {
            List<M_usuario_MD> lista = new ArrayList<M_usuario_MD>();
            String sql = "select * from usuario" + " where \"codigo\" LIKE '%" + codigo + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                M_usuario_MD m = new M_usuario_MD();
                m.setCodigo(rs.getString("codigo"));
                m.setCedula_persona(rs.getString("cdlper"));
                m.setUsuario(rs.getString("nomusuario"));
                m.setContrasena(rs.getString("contrasena"));
                m.setCodigo_rol(rs.getString("codrol"));
                m.setEstado(rs.getString("estado"));

                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(M_usuario_MD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public M_usuario_MD validar(String User, String Pass) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        M_usuario_MD u = new M_usuario_MD();
        String validar = "Select * From usuario\n"
                + "where usuario.nomusuario=? and usuario.contrasena=?;";
        try {
            con = conectar.getCon();

            st = con.prepareStatement(validar);
            st.setString(1, User);
            st.setString(2, Pass);
            rs = st.executeQuery();

            while (rs.next()) {

                u.setCodigo(rs.getString("codigo"));
                u.setCedula_persona(rs.getString("cdlper"));
                u.setUsuario(rs.getString("nomusuario"));
                u.setContrasena(rs.getString("contrasena"));
                u.setCodigo_rol(rs.getString("codrol"));
                u.setEstado(rs.getString("estado"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return u;
    }
    

}
