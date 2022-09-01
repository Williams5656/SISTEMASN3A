/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author VICO5
 */
public class usuarioBD extends usuarioMD{
    Conect conectar = new Conect();

    public usuarioBD() {
    }

    public usuarioBD(int codigo, String cedula, String usuario, String password, String rol, String estado) {
        super(codigo, cedula, usuario, password, rol, estado);
    }
    public List<usuarioMD> mostrardatos() {
        
        try {
            List<usuarioMD> lista = new ArrayList<usuarioMD>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                usuarioMD usuario = new usuarioMD();
                
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("contrasena"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));
                lista.add(usuario);
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(usuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean insertar() {
        String sql = "INSERT INTO usuario(codigo, cedula, usuario, contrasena, rol, estado)" + 
                "VALUES (" + 
                getCodigo() + ",'" + 
                getCedula() + "','" +  
                getUsuario() + "','" + 
                getPassword() + "','" + 
                getRol() + "','" + 
                getEstado() + "')"; 

        if (conectar.noQuery(sql) == null) {
            return true;
        } 
        else {
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }
    }
    
    public boolean modificar(int codigo){
            String sql = "update usuario set " +
                    "cedula = '" + getCedula() + "', " +
                    "usuario = '" + getUsuario() + "', " +
                    "contrasena = '" + getPassword() + "', " +
                    "rol = '" + getRol() + "', " +
                    "estado = '" + getEstado() + "' " +
                    "where codigo = " + codigo;

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "error al editar");

            return false;
        }
    }
    
    public List<usuarioMD> obtenerDatos(int codigo) {
        
        try {
            List<usuarioMD> lista = new ArrayList<usuarioMD>();
            String sql = 
                    "select * from usuario " + 
                    "where codigo = " + codigo ;
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                usuarioMD usuario = new usuarioMD();
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("contrasena"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));
                lista.add(usuario);
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(usuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean eliminar(Integer codigo){
        String nsql = "update usuario set " + 
                "cedula = '" + getCedula() + "', " +
                "usuario = '" + getUsuario() + "', " +
                "contrasena = '" + getPassword() + "', " +
                "rol = '" + getRol() + "', " +
                "estado = '" + getEstado() + "', " +
                "where codigo = " + codigo;
                
        if(conectar.noQuery(nsql) == null){
            return true;
        }
        else{
            JOptionPane.showConfirmDialog(null, "Error al elimianr");
            return false;
        }
    }
    
    
}
