package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteBD extends ClienteMD {

    Conectar conectar = new Conectar();

    public List<ClienteMD> mostrardatos() {
        try {
            List<ClienteMD> lista = new ArrayList<ClienteMD>();
            String sql = "select * from cliente ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ClienteMD cl = new ClienteMD();
                cl.setCodigo(rs.getString("COIGO"));
                cl.setCedula(rs.getString("CEDULA"));
                cl.setNombres(rs.getString("NOMBRES"));
                cl.setEstado(rs.getString("TELEFONO"));
                cl.setEstado(rs.getString("ESTADO"));
                lista.add(cl);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO cliente(codigo, cedula, nombres, telefono, estado)" + "VALUES ('" + getCodigo() + "','" + getCedula() + "','" + getNombres() + "','" + getTelefono() + "','" + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codigo) {
        String sql = "update cliente set \"cedula\"='" + getCedula() + "',\"nombres\"='" + getNombres() + "',\"telefono\"='" + getTelefono() + "',\"estado\"='" + getEstado() + "'"
                + "where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE EDITAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<ClienteMD> obtenerdatos(String codigo) {
        try {
            List<ClienteMD> lista = new ArrayList<ClienteMD>();
            String sql = "select * from cliente where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ClienteMD cl = new ClienteMD();
                cl.setCodigo(rs.getString("COIGO"));
                cl.setCedula(rs.getString("CEDULA"));
                cl.setNombres(rs.getString("NOMBRES"));
                cl.setEstado(rs.getString("TELEFONO"));
                cl.setEstado(rs.getString("ESTADO"));
                lista.add(cl);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<ClienteMD> buscardatosporcodigo(String codigo) {
        try {
            List<ClienteMD> lista = new ArrayList<ClienteMD>();
            String sql = "select * from cliente where \"codigo\" ILIKE '%" + codigo + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ClienteMD cl = new ClienteMD();
                cl.setCodigo(rs.getString("COIGO"));
                cl.setCedula(rs.getString("CEDULA"));
                cl.setNombres(rs.getString("NOMBRES"));
                cl.setEstado(rs.getString("TELEFONO"));
                cl.setEstado(rs.getString("ESTADO"));
                lista.add(cl);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codigo) {
        String nsql = "delete from cliente where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
