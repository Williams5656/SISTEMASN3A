package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RolBD extends RolMD {

    Conectar conectar = new Conectar();

    public List<RolMD> mostrardatos() {
        try {
            List<RolMD> lista = new ArrayList<RolMD>();
            String sql = "select * from roles ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RolMD r = new RolMD();
                r.setCodigo(rs.getString("CODROL"));
                r.setNombre(rs.getString("NOMBRE"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                r.setEstado(rs.getString("ESTADO"));
                lista.add(r);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO roles(codrol,nombre,descripcion,estado)" + "VALUES ('" + getCodigo() + "','" + getNombre() + "','" + getDescripcion() + "','" + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codigo) {
        String sql = "update roles set \"nombre\"='" + getNombre() + "',\"descripcion\"='" + getDescripcion() + "',\"estado\"='" + getEstado() + "'"
                + "where \"codrol\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE EDITAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<RolMD> obtenerdatos(String codigo) {
        try {
            List<RolMD> lista = new ArrayList<RolMD>();
            String sql = "select * from roles where \"codrol\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RolMD r = new RolMD();
                r.setCodigo(rs.getString("CODROL"));
                r.setNombre(rs.getString("NOMBRE"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                r.setEstado(rs.getString("ESTADO"));
                lista.add(r);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<RolMD> buscardatospornombre(String codigo) {
        try {
            List<RolMD> lista = new ArrayList<RolMD>();
            String sql = "select * from roles where \"nombre\" ILIKE '%" + codigo + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RolMD r = new RolMD();
                r.setCodigo(rs.getString("CODROL"));
                r.setNombre(rs.getString("NOMBRE"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                r.setEstado(rs.getString("ESTADO"));
                lista.add(r);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public List<RolMD> buscardatosporcodigo(String codigo) {
        try {
            List<RolMD> lista = new ArrayList<RolMD>();
            String sql = "select * from roles where \"codrol\" ILIKE '%" + codigo + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RolMD r = new RolMD();
                r.setCodigo(rs.getString("CODROL"));
                r.setNombre(rs.getString("NOMBRE"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                r.setEstado(rs.getString("ESTADO"));
                lista.add(r);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codigo) {
        String nsql = "delete from roles where \"codrol\"='" + codigo + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
