package V93Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioBD extends UsuarioMb {

    Conectar conectar = new Conectar();

    public UsuarioBD() {
    }

    public UsuarioBD(String codigo, String cedula, String nombre_usuario, String clave, String codigo_rol, String estado, String correo) {
        super(codigo, cedula, nombre_usuario, clave, codigo_rol, estado, correo);
    }

    public List<UsuarioMb> mostrardatos() {
        try {
            List<UsuarioMb> listausuario = new ArrayList<UsuarioMb>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMb usua = new UsuarioMb();
                usua.setCodigo(rs.getString("codigo"));
                usua.setCedula(rs.getString("cedula"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setCorreo(rs.getString("correo"));
                usua.setClave(rs.getString("clave"));
                usua.setCodigo_rol(rs.getString("rol"));
                usua.setEstado(rs.getString("estado"));

                listausuario.add(usua);
            }
            rs.close();
            return listausuario;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "insert into usuario (codigo, cedula, usuario, correo, clave, rol, estado)  VALUES ('" + getCodigo() + "','" + getCedula() + "','" + getUsuario() + "','" + getClave() + "','" + getCodigo_rol() + "','" + getEstado() + "','" + getCorreo() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public UsuarioMb validar(String User, String Pass) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        UsuarioMb usua = new UsuarioMb();
        String validar = "Select * From usuario\n"
                + "where usuario.usuario=? and usuario.clave=?;";
        try {
            con = conectar.getCon();

            st = con.prepareStatement(validar);
            st.setString(1, User);
            st.setString(2, Pass);
            rs = st.executeQuery();

            while (rs.next()) {

                usua.setCodigo(rs.getString("codigo"));
                usua.setCedula(rs.getString("cedula"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setCorreo(rs.getString("correo"));
                usua.setClave(rs.getString("clave"));
                usua.setCodigo_rol(rs.getString("rol"));
                usua.setEstado(rs.getString("estado"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return usua;
    }

    public boolean modificar(String codigo) {
        String sql = "update usuario set \"cedula\"='" + getCedula() + "',\"usuario\"='" + getUsuario() + "',\"correo\"='" + getCorreo() + "',\"clave\"='" + getClave() + "',\"rol\"='" + getCodigo_rol() + "',\"estado\"='" + getEstado() + "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<UsuarioMb> obtenerdatos(String codigo) {
        try {
            List<UsuarioMb> listausuario = new ArrayList<UsuarioMb>();
            String sql = "select * from usuario" + "  where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMb usua = new UsuarioMb();
                usua.setCodigo(rs.getString("codigo"));
                usua.setCedula(rs.getString("cedula"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setCorreo(rs.getString("correo"));
                usua.setClave(rs.getString("clave"));
                usua.setCodigo_rol(rs.getString("rol"));
                usua.setEstado(rs.getString("estado"));

                listausuario.add(usua);
            }
            rs.close();
            return listausuario;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codigo) {
        String sql = "delete from usuario where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }
}
