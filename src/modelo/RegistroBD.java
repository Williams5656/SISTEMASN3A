package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegistroBD extends RegistroMD {

    Conectar conectar = new Conectar();

    public List<RegistroMD> mostrardatos() {
        try {
            List<RegistroMD> lista = new ArrayList<RegistroMD>();
            String sql = "select * from registrojuicio ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RegistroMD reg=new RegistroMD();
                reg.setCedula_cliente(rs.getString("cod_cliente"));
                reg.setN_juicio(rs.getString("nro_juicio"));
                reg.setTipo_juicio(rs.getString("tipo_juicio"));
                lista.add(reg);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RegistroBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO registrojuicio(cod_cliente, nro_juicio, tipo_juicio)" + "VALUES ('" + getCedula_cliente()+ "','" + getN_juicio()+ "','" + getTipo_juicio()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codigo_cliente) {
        String sql = "update registrojuicio set \"nro_juicio\"='" + getN_juicio()+ "',\"tipo_juicio\"='" + getTipo_juicio()+ "'"
                + "where \"cod_cliente\"='" + codigo_cliente + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE EDITAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<RegistroMD> obtenerdatos(String codigo_cliente) {
        try {
            List<RegistroMD> lista = new ArrayList<RegistroMD>();
            String sql = "select * from registrojuicio where \"cod_cliente\"='" + codigo_cliente + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
               RegistroMD reg=new RegistroMD();
                reg.setCedula_cliente(rs.getString("cod_cliente"));
                reg.setN_juicio(rs.getString("nro_juicio"));
                reg.setTipo_juicio(rs.getString("tipo_juicio"));
                lista.add(reg);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<RegistroMD> buscardatosporcedula(String codigo_cliente) {
        try {
            List<RegistroMD> lista = new ArrayList<RegistroMD>();
            String sql = "select * from registrojuicio where \"cod_cliente\" ILIKE '%" + codigo_cliente + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RegistroMD reg=new RegistroMD();
                reg.setCedula_cliente(rs.getString("cod_cliente"));
                reg.setN_juicio(rs.getString("nro_juicio"));
                reg.setTipo_juicio(rs.getString("tipo_juicio"));
                lista.add(reg);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

 

    public boolean eliminar(String codigo_cliente) {
        String nsql = "delete from registrojuicio where \"cod_cliente\"='" + codigo_cliente + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
