
package V93Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBD extends LoginMb {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conectar cn = new Conectar();

    public LoginBD (String cedula, String pass) {
       
        LoginMb log = new LoginMb();
        String sql = "SELECT * FROM usuario WHERE correo = ? AND pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                log.setCedula(rs.getString("cedula"));
                log.setNombre(rs.getString("nombre"));
                log.setCorreo(rs.getString("correo"));
                log.setPass(rs.getString("pass"));
                log.setRol(rs.getString("rol"));

            }

        } catch (SQLException e) {
            System.out.println(e.toString());
                
        }
        return ;

    }
    
    public boolean Registrar(LoginMb reg){
        String sql = "INSERT INTO usuario(Nombre,Correo,Pass,rol) VALUES (?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo());
            ps.setString(3, reg.getPass());
            ps.setString(4, reg.getRol());
            rs = ps.executeQuery();
        
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;  
        }  return false;  
    } 
    

}
