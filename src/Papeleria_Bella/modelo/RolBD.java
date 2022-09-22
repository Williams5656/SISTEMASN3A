
package Papeleria_Bella.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RolBD extends RolMD{
    Conexion conectar = new Conexion();

    public RolBD() {
    }

    public RolBD(String codigo, String nombre, String descripcion, String estado) {
        super(codigo, nombre, descripcion, estado);
    }
    
    public List<RolMD> mostrardatos() {
        try {
            List<RolMD> listau = new ArrayList<RolMD>();
            String sql = "select * from rol";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RolMD u = new RolMD();
                u.setCodigo(rs.getString("codigo"));
                u.setNombre(rs.getString("nombre"));
                u.setDescripcion(rs.getString("descripcion"));
                u.setEstado(rs.getString("estado"));
    
                listau.add(u);
            }
            rs.close();
            return listau;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean insertar() {
        String sql = "INSERT INTO rol(codigo, nombre, descripcion, estado) VALUES ('" + getCodigo()+ "','" + getNombre() + "','" + getDescripcion()+ "','" + getEstado()+ "')";

         if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
    
    public boolean modificar(String codigo) {
        String sql = "update rol set \"nombre\"='" + getNombre() + "',\"descripcion\"='" + getDescripcion()+ "',\"estado\"='" + getEstado()+ "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }
    }
    
    public List<RolMD> obtenerdatos(String codigo) {
        
        try {
            List<RolMD> lista = new ArrayList<RolMD>();
            String sql = "select * from rol " + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RolMD u = new RolMD();
                u.setCodigo(rs.getString("codigo"));
                u.setNombre(rs.getString("nombre"));
                u.setDescripcion(rs.getString("descripcion"));
                u.setEstado(rs.getString("estado"));
                 
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public List<RolMD> buscardatospornombre(String nombre) {
        try {
            List<RolMD> lista = new ArrayList<RolMD>();
            String sql = "select * from rol where \"nombre\" ILIKE '%" + nombre + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RolMD r = new RolMD();
                r.setCodigo(rs.getString("codigo"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setEstado(rs.getString("estado"));
                lista.add(r);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean eliminar (String codigo){
        String sql = "delete from rol where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql)==null) {
            return true;
            
        }else{
            System.out.println("Error al eliminar");
            return false;
        }
    }
    public List<RolMD> buscardatos(String nombre) {
        try {
            List<RolMD> lista = new ArrayList<RolMD>();
            String sql = "select * from rol where \"nombre\" ILIKE '%" + nombre + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RolMD r = new RolMD();
                r.setCodigo(rs.getString("codigo"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setEstado(rs.getString("estado"));
                lista.add(r);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
