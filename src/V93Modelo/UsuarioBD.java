package V93Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioBD extends UsuarioMb {
 
    Conectar conectar = new Conectar();

    public UsuarioBD() {
    }
  
    public UsuarioBD(String cedula, String nombre, String correo, String clave, String rol, String estado) {
        super(cedula, nombre, correo, clave, rol, estado);
    }

    public List<UsuarioMb> mostrardatos() {
        try {
            List<UsuarioMb> listausuario = new ArrayList<UsuarioMb>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMb usua = new UsuarioMb();
                usua.setCedula(rs.getString("cedula"));
                usua.setNombre(rs.getString("nombre"));
                usua.setCorreo(rs.getString("correo"));
                usua.setClave(rs.getString("clave"));
                usua.setRol(rs.getString("rol"));
                usua.setEstado(rs.getString("estado"));

                listausuario.add(usua);
            }
            rs.close();
            return listausuario;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "insert into usuario (cedula, nombre, correo, clave, rol, estado)  VALUES ('" + getCedula() + "','" + getNombre() + "','" + getCorreo() +"','" + getClave() + "','" + getRol() + "','" + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String cedula) {
        String sql = "update usuario set \"nombre\"='" + getNombre() + "',\"correo\"='" + getCorreo() + "',\"clave\"='" + getClave() + "',\"rol\"='" + getRol() + "',\"estado\"='" + getEstado() + "'"
                + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<UsuarioMb> obtenerdatos(String cedula) {
        try {
            List<UsuarioMb> listausuario = new ArrayList<UsuarioMb>();
            String sql = "select * from usuario" + "  where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMb usua = new UsuarioMb();
                usua.setCedula(rs.getString("cedula"));
                usua.setNombre(rs.getString("nombre"));
                usua.setCorreo(rs.getString("correo"));
                usua.setClave(rs.getString("clave"));
                usua.setRol(rs.getString("rol"));
                usua.setEstado(rs.getString("estado"));

                listausuario.add(usua);
            }
            rs.close();
            return listausuario;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String cedula) {
        String nsql = "delete from usuario where \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }

}
