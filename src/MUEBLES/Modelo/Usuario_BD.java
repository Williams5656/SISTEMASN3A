package MUEBLES.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Usuario_BD extends M_muebles_usuarioMD{
    
    Conect conectar = new Conect();

    public Usuario_BD(String cedula, String nombre_u, String contraseña, String rol, String estado) {
        super(cedula, nombre_u, contraseña, rol, estado);
    }

    public Usuario_BD() {
    }
    
    public List<M_muebles_usuarioMD> mostrardatos() {
        try {
            List<M_muebles_usuarioMD> lista = new ArrayList<M_muebles_usuarioMD>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                M_muebles_usuarioMD m = new M_muebles_usuarioMD();
                m.setCedula(rs.getString("cedula"));
                m.setNombre_u(rs.getString("nombre"));
                m.setContraseña(rs.getString("contraseña"));
                m.setRol(rs.getString("rol"));
                m.setEstado(rs.getString("estado"));

                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(M_muebles_usuarioMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean insert() {
        String sql = "insert into usuario(cedula, nombre, contraseña, rol, estado)" + "values ('" + getCedula()+ "','" + getNombre_u()+ "','" + getContraseña()+ "','" + getRol()+ "','" + getEstado()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "¡ Falla al insertar !");
            return false;
        }
    }
    
    public boolean modificar(String cedula) {
        String sql = "update usuario set \"nombre\"='" + getNombre_u()+ "',\"contraseña\"='" + getContraseña()+ "',\"rol\"='" + getRol()+ "',\"estado\"='" + getEstado()+ "'" + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    
    public List<M_muebles_usuarioMD> obtenerdatos(String cedula) {
        try {
            List<M_muebles_usuarioMD> lista = new ArrayList<M_muebles_usuarioMD>();
            String sql = "select * from usuario" + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                M_muebles_usuarioMD m = new M_muebles_usuarioMD();
                m.setCedula(rs.getString("cedula"));
                m.setNombre_u(rs.getString("nombre"));
                m.setContraseña(rs.getString("contraseña"));
                m.setRol(rs.getString("rol"));
                m.setEstado(rs.getString("estado"));

                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(M_muebles_usuarioMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
     
    public boolean eliminar(String cedula) {
        String sql = "delete from usuario" + " where \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }
    }
    
}
