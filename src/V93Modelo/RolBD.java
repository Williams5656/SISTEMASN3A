package V93Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolBD extends RolMb {

    Conectar conecta = new Conectar();

    public RolBD() {
    }

    public RolBD(String codigo, String nombre, String descripcion,String estado) {
        super(codigo, nombre, descripcion, estado);
    }

    public List<RolMb> mostrardatos() {
        try {
            List<RolMb> listarol = new ArrayList<RolMb>();
            String sql = "select * from rol";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                RolMb r = new RolMb();
                r.setCodigo(rs.getString("codigo"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setEstado(rs.getString("estado"));

                listarol.add(r);
            }
            rs.close();
            return listarol;
        } catch (SQLException e) {
            Logger.getLogger(RolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO rol (codigo,nombre,descripcion)" + "VALUES ('" + getCodigo() + "','" + getNombre() + "','" + getDescripcion() + "')";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public List<RolMb> obtenerdatos(String codigo) {
        try {
            List<RolMb> lista = new ArrayList<RolMb>();
            String sql = "select * from rol " + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                RolMb m = new RolMb();
                m.setCodigo(rs.getString("codigo"));
                m.setNombre(rs.getString("nombre"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setEstado(rs.getString("estado"));
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean modificar(String codigo) {
        String sql = "update rol set \"nombre\"='" + getNombre() + "',\"descripcion\"='" + getDescripcion() + "'where \"codigo\"='" + codigo + "'";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public boolean eliminar(String codigo) {
        String sql = "delete FROM rol where\"codigo\"='" + codigo + "'";
        if (conecta.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }

}
