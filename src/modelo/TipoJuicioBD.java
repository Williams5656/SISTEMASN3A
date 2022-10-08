package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TipoJuicioBD extends TipoJuicioMD {

    Conectar conectar = new Conectar();

    public List<TipoJuicioMD> mostrardatos() {
        try {
            List<TipoJuicioMD> lista = new ArrayList<TipoJuicioMD>();
            String sql = "select * from registrojuicio ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                TipoJuicioMD r = new TipoJuicioMD();
                r.setCodigo(rs.getString("CODIGO"));
                r.setNombre(rs.getString("NOMBRE"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                r.setPrecio(Double.parseDouble(rs.getString("PRECIO")));
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
        String sql = "INSERT INTO registrojuicio(codigo, nombre, descripcion, precio)" + "VALUES ('" + getCodigo() + "','" + getNombre() + "','" + getDescripcion() + "','" + getPrecio() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codigo) {
        String sql = "update registrojuicio set \"nombre\"='" + getNombre() + "',\"descripcion\"='" + getDescripcion() + "',\"precio\"='" + getPrecio() + "'"
                + "where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE EDITAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<TipoJuicioMD> obtenerdatos(String nombre) {
        try {
            List<TipoJuicioMD> lista = new ArrayList<TipoJuicioMD>();
            String sql = "select * from registrojuicio where \"nombre\"='" + nombre + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                TipoJuicioMD r = new TipoJuicioMD();
                r.setCodigo(rs.getString("CODIGO"));
                r.setNombre(rs.getString("NOMBRE"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                r.setPrecio(Double.parseDouble(rs.getString("PRECIO")));
                lista.add(r);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<TipoJuicioMD> buscardatosporcodigo(String nombre) {
        try {
            List<TipoJuicioMD> lista = new ArrayList<TipoJuicioMD>();
            String sql = "select * from registrojuicio where \"codigo\" ILIKE '%" + nombre + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                TipoJuicioMD r = new TipoJuicioMD();
                r.setCodigo(rs.getString("CODIGO"));
                r.setNombre(rs.getString("NOMBRE"));
                r.setDescripcion(rs.getString("DESCRIPCION"));
                r.setPrecio(Double.parseDouble(rs.getString("PRECIO")));
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
        String nsql = "delete from registrojuicio where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
