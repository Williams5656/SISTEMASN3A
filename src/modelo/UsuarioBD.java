package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                User.setCodUsuario(rs.getString("CODIGO"));
                User.setCedula(rs.getString("CEDULA"));
                User.setUsuario(rs.getString("USUARIO"));
                User.setClave(rs.getString("CLAVE"));
                User.setRol(rs.getString("ROL"));
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

    public boolean insertar() {
        String sql = "INSERT INTO usuario(codigo, cedula, usuario, clave, rol, estado)" + "VALUES ('" + getCodUsuario()+ "','" + getCedula()+ "','" + getUsuario()+ "','" + getClave()+ "','" + getRol()+ "','" + getEstado()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codUsuario) {
        String sql = "update usuario set \"cedula\"='" + getCedula()+ "',\"usuario\"='" + getUsuario()+ "',\"clave\"='" + getClave()+ "',\"rol\"='" + getRol()+ "',\"estado\"='" + getEstado()+ "'"
                + "where \"codigo\"='" + codUsuario + "'";
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
            String sql = "select * from usuario where \"codigo\"='" + codUsuario + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
              UsuarioMD User = new UsuarioMD();
                User.setCodUsuario(rs.getString("CODIGO"));
                User.setCedula(rs.getString("CEDULA"));
                User.setUsuario(rs.getString("USUARIO"));
                User.setClave(rs.getString("CLAVE"));
                User.setRol(rs.getString("ROL"));
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
        String nsql = "delete from usuario where \"codigo\"='" + codUsuario + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
