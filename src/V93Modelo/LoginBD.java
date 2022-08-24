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

  public LoginBD validar(String User, String Pass) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        LoginBD UserVal = new LoginBD ();
        String validar = "Select * From usuario\n"
                + "where usuario.usuario=? and usuario.clave=?;";
        try {
            con = conecta.getCon();

            st = con.prepareStatement(validar);
            st.setString(1, User);
            st.setString(2, Pass);
            rs = st.executeQuery();

            while (rs.next()) {

                UserVal.setCedula(rs.getString("cedula"));
                UserVal.setNombre(rs.getString("nombre"));
                UserVal.setCorreo(rs.getString("correo"));
                UserVal.setClave(rs.getString("clave"));
                UserVal.setRol(rs.getString("rol"));
               

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return UserVal;
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
