
package Hertz.Modelo;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioBD extends UsuarioMD{
    Conect conectar = new Conect();

    public UsuarioBD() {
    }

    public UsuarioBD(String cedula, String usuario, String password, String rol, String estado) {
        super(cedula, usuario, password, rol, estado);
    }
    
    public List<UsuarioMD> mostrardatos() {
        
        try {
            List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                
                UsuarioMD usuario = new UsuarioMD();
                usuario.setCedula(rs.getString("cedula"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));
                lista.add(usuario);
                
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }//Fin mostrar datos
    
    public boolean insertar() {
        String sql = "INSERT INTO usuario(cedula, usuario, password, rol, estado)" + 
                "VALUES ('" + 
                getCedula() + "','" + 
                getUsuario() + "','" + 
                getPassword() + "','" + 
                getRol() + "','" + 
                getEstado()+ "')"; 

        if (conectar.noQuery(sql) == null) {
            return true;
        } 
        else {
            
            JOptionPane.showMessageDialog(null, "ERROR");
            return false;
        }
    }//Fin de insertar
    
    public List<UsuarioMD> obtenerDatos(String cedula) {
        
        try {
            List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
            String sql = 
                    "select * from usuario " + 
                    "where cedula = '" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD usuario = new UsuarioMD();
                usuario.setCedula(rs.getString("cedula"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));
                lista.add(usuario);
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }//Fin de obtener datos
    
}