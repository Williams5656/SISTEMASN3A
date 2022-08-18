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

    public UsuarioBD(String codigo, String cedula, String nombre_usuario, String clave, String codigo_rol, String estado, String correo) {
        super(codigo, cedula, nombre_usuario, clave, codigo_rol, estado, correo);
    }

    public List<UsuarioMb> mostrardatos() {
        try {
            List<UsuarioMb> listausuario = new ArrayList<UsuarioMb>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMb usua = new UsuarioMb();
                usua.setCodigo(rs.getString("codigo"));
                usua.setCedula(rs.getString("cedula"));
                usua.setNombre_usuario(rs.getString("usuario"));
                usua.setClave(rs.getString("clave"));
                usua.setCodigo_rol(rs.getString("rol"));
                usua.setEstado(rs.getString("estado"));
                usua.setCorreo(rs.getString("correo"));

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
        String sql = "insert into usuario (codigo, cedula, usuario, clave, rol, estado, correo)  VALUES ('" + getCodigo() + "','" + getCedula() + "','" + getNombre_usuario() + "','" + getClave() + "','" + getCodigo_rol() + "','" + getEstado() + "','" + getCorreo() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String codigo) {
        String sql = "update usuario set \"cedula\"='" + getCedula() + "',\"usuario\"='" + getNombre_usuario() + "',\"clave\"='" + getClave() + "',\"rol\"='" + getCodigo_rol() + "',\"estado\"='" + getEstado() + "',\"correo\"='" + getCorreo() + "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<UsuarioMb> obtenerdatos(String codigo) {
        try {
            List<UsuarioMb> listausuario = new ArrayList<UsuarioMb>();
            String sql = "select * from usuario" + "  where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMb usua = new UsuarioMb();
                usua.setCodigo(rs.getString("codigo"));
                usua.setCedula(rs.getString("cedula"));
                usua.setNombre_usuario(rs.getString("usuario"));
                usua.setClave(rs.getString("clave"));
                usua.setCodigo_rol(rs.getString("rol"));
                usua.setEstado(rs.getString("estado"));
                usua.setCorreo(rs.getString("correo"));

                listausuario.add(usua);
            }
            rs.close();
            return listausuario;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codigo) {
        // String nsql = "delete from usuario where \"codigo\"='" + codigo + "'";
       String sql = "update usuario set \"estado\"='" + "INACTIVO" + "'"
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
 