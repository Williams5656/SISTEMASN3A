package V93Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginBD extends LoginMb {
   
 Conectar conecta = new Conectar();
 
 public LoginBD() {
    }



  /*  public boolean Registrar(LoginMb reg) {
        String sql = "INSERT INTO usuario(Nombre,Correo,Pass,rol) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo());
            ps.setString(3, reg.getPass());
            ps.setString(4, reg.getRol());
            rs = ps.executeQuery();

        } catch (SQLException e) {
           System.out.println(e.toString());
            return false;
        }
        return false;
    }*/

}
