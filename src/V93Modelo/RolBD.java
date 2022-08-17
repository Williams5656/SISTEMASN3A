package V93Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolBD extends RolMb {

    Conectar conectar = new Conectar();

    public RolBD() {
    }

    public RolBD(String codigo, String nombre, String descripcion,String estado) {
        super(codigo, nombre, descripcion, estado);
    }

    public List<RolMb> mostrardatos() {
        try {
            List<RolMb> lista = new ArrayList<RolMb>();
            String sql = "select * from rol";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RolMb rol = new RolMb();
                rol.setCodigo(rs.getString("codigo"));
                rol.setNombre(rs.getString("cargo"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setEstado(rs.getString("estado"));

                lista.add(rol);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "insert into rol (codigo, cargo, descripcion, estado)  VALUES ('" + getCodigo() + "','" + getNombre() + "','" + getDescripcion() +"','" + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String cedula) {
        String sql = "update rol set \"cargo\"='" + getNombre() + "',\"descripcion\"='" + getDescripcion() + "',\"estado\"='" + getEstado() + "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
   
    public List<RolMb> obtenerdatos(String codigo) {
        try {
            List<RolMb> lista = new ArrayList<RolMb>();
            String sql = "select * from rol " + " where \"codigo\" ILIKE '%" + codigo + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                RolMb rol = new RolMb();
                rol.setCodigo(rs.getString("codigo"));
                rol.setNombre(rs.getString("cargo"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setEstado(rs.getString("estado"));

                lista.add(rol);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean eliminar(String codigo) {
 String sql = "update rol set \"estado\"='" + "INACTIVO" + "'"
                + " where \"codigo\"='" + codigo + "'";
       
 
// String nsql = "delete from rol where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }
 
}
