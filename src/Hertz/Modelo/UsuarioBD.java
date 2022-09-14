
package Hertz.Modelo;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UsuarioBD extends UsuarioMD{
    Conect conectar = new Conect();

    public UsuarioBD() {
    }

    public UsuarioBD(int codigo, String cedula, String usuario, String password, String rol, String estado) {
        super(codigo, cedula, usuario, password, rol, estado);
    }
    public List<UsuarioMD> mostrardatos() {
        
        try {
            List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD usuario = new UsuarioMD();
                
                usuario.setCodigo(rs.getInt("codigo"));
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
    }
    
    public boolean insertar() {
        String sql = "INSERT INTO usuario(codigo, cedula, usuario, password, rol, estado)" + 
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
    }//Fin del insertar
    
    public boolean modificar(int codigo){
            String sql = "update usuario set " +
                    "cedula = '" + getCedula() + "', " +
                    "usuario = '" + getUsuario() + "', " +
                    "password = '" + getPassword() + "', " +
                    "rol = '" + getRol() + "', " +
                    "estado = '" + getEstado() + "' " +
                    "where codigo = " + codigo;

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "error al editar");

            return false;
        }
    }//Fin de modificar
    
    public List<UsuarioMD> obtenerDatos(int codigo) {
        
        try {
            List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
            String sql = 
                    "select * from usuario " + 
                    "where codigo = " + codigo ;
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD usuario = new UsuarioMD();
                usuario.setCodigo(rs.getInt("codigo"));
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
    }//Fin de obteer datos
    
    public List<UsuarioMD> buscarDatos(String cedula) {
        
        try {
            List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
            String sql = 
                    "select * from usuario " + 
                    "where cedula ILIKE '%" + cedula + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD usuario = new UsuarioMD();
                usuario.setCodigo(rs.getInt("codigo"));
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
    }//Fin de buscar datos
    
    public DefaultComboBoxModel rol(){
        DefaultComboBoxModel listaRol = new DefaultComboBoxModel();
        listaRol.addElement("Seleccionar");
        ResultSet rs = conectar.query("Select * from rol order by nombre");
        try{
            while (rs.next()){
                listaRol.addElement(rs.getString("nombre"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return listaRol;
    }//Fin del metodo rol
    
    public boolean eliminar(Integer codigo){
        String nsql = "update usuario set " +
                    "cedula = '" + getCedula() + "', " +
                    "usuario = '" + getUsuario() + "', " +
                    "password = '" + getPassword() + "', " +
                    "rol = '" + getRol() + "', " +
                    "estado = 'Inactivo'" +
                    "where codigo = " + codigo;
                
        if(conectar.noQuery(nsql) == null){
            return true;
        }
        else{
            JOptionPane.showConfirmDialog(null, "Error al elimianr");
            return false;
        }
    }//Fin de eliminar
    
}