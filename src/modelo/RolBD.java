package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolBD extends Mrol{
     Conectar conectar = new Conectar();
     
    public List<Mrol> mostrardatos() {
        try {
            List<Mrol> lista = new ArrayList<Mrol>();
            String sql = "select * from rol where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                Mrol r = new Mrol();
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
    public boolean insertar() {
        String sql = "INSERT INTO rol(codigo,nombre,descripcion,estado)" + "VALUES ('" + getCodigo() + "','" + getNombre() + "','" + getDescripcion()+ "','" +getEstado()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }
    public boolean modificar(String codigo) {
        String sql = "update rol set \"nombre\"='" + getNombre() + "',\"descripcion\"='" + getDescripcion()+"',\"estado\"='" + getEstado()+ "'"
                + "where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("ERROR AL MOMENTO DE EDITAR");
            System.out.println("INTENTE OTRA VEZ");

            return false;
        }
    }
    public List<Mrol> obtenerdatos(String codigo) {
        try {
            List<Mrol> lista = new ArrayList<Mrol>();
            String sql = "select * from rol where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                Mrol r = new Mrol();
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
    public boolean eliminar(String codigo) {
        String nsql = "delete from rol where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;

        } else {
            System.out.println("ERROR");
            System.out.println("NO SE PUDO ELIMINAR");
            return false;
        }
    }

}
