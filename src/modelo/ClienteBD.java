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
                cl.setCodigo(rs.getString("CODIGO"));
                cl.setCedula(rs.getString("CEDULA"));
                cl.setEstado(rs.getString("ESTADO"));
                cl.setProfesion(rs.getString("PROFESION"));
                cl.setTrabajo(rs.getString("TRABAJO"));
                lista.add(cl);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar()  {
        String sql = "INSERT INTO cliente(codigo, cedula,estado,profesion,trabajo)" + "VALUES ('" + getCodigo() + "','" + getCedula() + "','" + getEstado() + "','" + getProfesion()+ "','" + getTrabajo()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codigo) {
        String sql = "update cliente set \"cedula\"='" + getCedula() + "',\"estado\"='" + getEstado() + "',\"profesion\"='" + getProfesion()+ "',\"trabajo\"='" + getTrabajo()+ "'"
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
                cl.setCodigo(rs.getString("CODIGO"));
                cl.setCedula(rs.getString("CEDULA"));
                cl.setEstado(rs.getString("ESTADO"));
                cl.setProfesion(rs.getString("PROFESION"));
                cl.setTrabajo(rs.getString("TRABAJO"));
                lista.add(cl);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<ClienteMD> buscardatos(String cedula) {
        try {
            List<ClienteMD> lista = new ArrayList<ClienteMD>();
            String sql = "select * from cliente where \"cedula\" ILIKE '%" + cedula + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ClienteMD cl = new ClienteMD();
                cl.setCodigo(rs.getString("CODIGO"));
                cl.setCedula(rs.getString("CEDULA"));
                cl.setEstado(rs.getString("ESTADO"));
                cl.setProfesion(rs.getString("PROFESION"));
                cl.setTrabajo(rs.getString("TRABAJO"));
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
