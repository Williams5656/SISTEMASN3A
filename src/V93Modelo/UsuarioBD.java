
package V93Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioBD extends UsuarioMb {

    Conectar conecta = new Conectar();

    public UsuarioBD() {
    }

    public UsuarioBD(String cedula, String nombre,String correo, String pass, String rol, String estado) {
        super(cedula,nombre,correo,pass,rol,estado);
    }

    public List<UsuarioMb> mostrardatos() {
        try {
            List<UsuarioMb> listausuario = new ArrayList<UsuarioMb>();
            String sql = "select * from usuario";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                UsuarioMb u = new UsuarioMb();
                u.setCedula(rs.getString("cedula"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setPass(rs.getString("pass"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));

                listausuario.add(u);
            }
            rs.close();
            return listausuario;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO usuario (cedula,nombre,pass,rol,estado)" + "VALUES ('" + getCedula() + "','" + getNombre() +"','" + getCorreo()+ "','" + getPass() + "','" +getRol()+"','"+ getEstado() + "')";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public List<UsuarioMb> obtenerdatos(String cedula) {
        try {
            List<UsuarioMb> lista = new ArrayList<UsuarioMb>();
            String sql = "select * from usuario " + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                UsuarioMb m = new UsuarioMb();
                m.setCedula(rs.getString("cedula"));
                m.setNombre(rs.getString("nombre"));
                m.setCorreo(rs.getString("Correo"));
                m.setPass(rs.getString("pass"));
                m.setRol(rs.getString("rol"));
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

    public boolean modificar(String cedula) {
        String sql = "update usuario set \"nombre\"='" + getNombre() +"',\"correo\"='" + getCorreo()+ "',\"pass\"='" + getPass() + "',\"rol\"='" + getRol() +"',\"estado\"='" + getEstado()+ "'where \"cedula\"='" + cedula + "'";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public boolean eliminar(String cedula) {
        String sql = "delete FROM usuario where\"cedula\"='" + cedula + "'";
        if (conecta.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }

}