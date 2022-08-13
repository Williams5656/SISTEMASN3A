
package Papeleria_Bella.modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioBD extends UsuarioMD{

    Conect conectar = new Conect();
    public UsuarioBD() {
    }

    public UsuarioBD(String codigo, String usuario, String contraseña, String rol, String estado) {
        super(codigo, usuario, contraseña, rol, estado);
    }
    

    
    
    public List<UsuarioMD> mostrardatos() {
        try {
            List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD u = new UsuarioMD();
                u.setCodigo(rs.getString("codigo"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));
                
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean insertar() {
        String sql = "INSERT INTO usuario(codigo,usuario,contraseña,rol,estado)" + "VALUES ('" + getCodigo()+ "','" + getUsuario()+ "','" + getContraseña()+ "','" + getRol()+ "','" + getEstado()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
}
