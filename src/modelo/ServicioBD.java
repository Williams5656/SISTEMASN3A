package modelo;

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

public class ServicioBD extends ServicioMD {

    Conectar conectar = new Conectar();

    public DefaultComboBoxModel Consultorio() {
        DefaultComboBoxModel listamodelocliente = new DefaultComboBoxModel();
        ResultSet rs = conectar.query("Select * from consultorio order by nombre");
        try {
            while (rs.next()) {
                listamodelocliente.addElement(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listamodelocliente;
    }

    public DefaultComboBoxModel TipoJuicio() {
        DefaultComboBoxModel listamodelocliente = new DefaultComboBoxModel();
        ResultSet rs = conectar.query("Select * from registrojuicio order by nombre");
        try {
            while (rs.next()) {
                listamodelocliente.addElement(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listamodelocliente;
    }

    public List<ServicioMD> mostrardatos() {
        try {
            List<ServicioMD> lista = new ArrayList<ServicioMD>();
            String sql = "select * from servicio ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ServicioMD User = new ServicioMD();
                User.setCodigo(rs.getString("CODIGO"));
                User.setCed_Cliente(rs.getString("CLIENTE"));
                User.setTipo(rs.getString("TIPO"));
                User.setFecha(rs.getString("FECHA"));
                User.setConsultorio(rs.getString("CONSULTORIO"));
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
        String sql = "INSERT INTO servicio(codigo, cliente, tipo, fecha, consultorio, estado)" + "VALUES ('" + getCodigo()+ "','" + getCed_Cliente()+ "','" + getTipo()+ "','" + getFecha()+ "','" + getConsultorio()+ "','" + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String CODIGO) {
        String sql = "update servicio set \"cliente\"='" + getCed_Cliente()+ "',\"tipo\"='" + getTipo()+ "',\"fecha\"='" + getFecha()+ "',\"consultorio\"='" + getConsultorio()+ "',\"estado\"='" + getEstado() + "'"
                + "where \"codigo\"='" + CODIGO + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE EDITAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<ServicioMD> obtenerdatos(String CODIGO) {
        try {
            List<ServicioMD> lista = new ArrayList<ServicioMD>();
            String sql = "select * from servicio where \"CODIGO\"='" + CODIGO + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ServicioMD User = new ServicioMD();
                User.setCodigo(rs.getString("CODIGO"));
                User.setCed_Cliente(rs.getString("CLIENTE"));
                User.setTipo(rs.getString("TIPO"));
                User.setFecha(rs.getString("FECHA"));
                User.setConsultorio(rs.getString("CONSULTORIO"));
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

    public List<ServicioMD> buscardatos(String CODIGO) {
        try {
            List<ServicioMD> lista = new ArrayList<ServicioMD>();
            String sql = "select * from servicio where \"codigo\" ILIKE '%" + CODIGO + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ServicioMD User = new ServicioMD();
                User.setCodigo(rs.getString("CODIGO"));
                User.setCed_Cliente(rs.getString("CLIENTE"));
                User.setTipo(rs.getString("TIPO"));
                User.setFecha(rs.getString("FECHA"));
                User.setConsultorio(rs.getString("CONSULTORIO"));
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

    public boolean eliminar(String CODIGO) {
        String nsql = "delete from servicio where \"codigo\"='" + CODIGO + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MOMENTO DE ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "INTENTE OTRA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
