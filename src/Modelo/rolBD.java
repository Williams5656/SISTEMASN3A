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
public class rolBD extends rolMD {

    Conect conectar = new Conect();

    public rolBD(int codigo, String nombre, String descripcion, String estado) {
        super(codigo, nombre, descripcion, estado);
    }

    public rolBD() {
    }

    public List<rolMD> mostrardatos() {

        try {
            List<rolMD> lista = new ArrayList<rolMD>();
            String sql = "select * from rol";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                rolMD rol = new rolMD();

                rol.setCodigo(rs.getInt("codigo"));
                rol.setNombre(rs.getString("nombre"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setEstado(rs.getString("estado"));
                lista.add(rol);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(rolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
public boolean insertar() {
        String sql = "INSERT INTO rol(codigo, nombre, descripcion, estado)" + 
                "VALUES (" + 
                getCodigo() + ",'" + 
                getNombre() + "','" + 
                getDescripcion() + "','" +
                getEstado() + "')"; 

        if (conectar.noQuery(sql) == null) {
            return true;
        } 
        else {
            System.out.println("Error");
            return false;
        }
    }
    
    public boolean modificar(Integer codigo){
            String sql = "update rol set " +
                    "nombre = '" + getNombre() + "', " +
                    "descripcion = '" + getDescripcion() + "', " +
                    "estado = '" + getEstado() + "' " +
                    "where codigo = " + codigo;

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }
    }
    public List<rolMD> obtenerDatos(Integer codigo) {
        
        try {
            List<rolMD> lista = new ArrayList<rolMD>();
            String sql = 
                    "select * from rol " + 
                    "where codigo = " + codigo ;
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                rolMD rol = new rolMD();
                rol.setCodigo(rs.getInt("codigo"));
                rol.setNombre(rs.getString("nombre"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setEstado(rs.getString("estado"));
                lista.add(rol);
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(rolBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean eliminar(Integer codigo){
        String nsql = "update rol set " + 
                "nombre = '" + getNombre() + "', " +
                "descripcion = '" + getDescripcion() + "', " +
                "estado = 'Inactivo' " +
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
