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
public class rol_BD extends rol_MD {

    Conect conectar = new Conect();

    public rol_BD(int codigo, String nombre, String descripcion, String estado) {
        super(codigo, nombre, descripcion, estado);
    }

    public rol_BD() {
    }

    public List<rol_MD> mostrardatos() {

        try {
            List<rol_MD> lista = new ArrayList<rol_MD>();
            String sql = "select * from rol";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                rol_MD rol = new rol_MD();

                rol.setCodigo(rs.getInt("codigo"));
                rol.setNombre(rs.getString("nombre"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setEstado(rs.getString("estado"));

                lista.add(rol);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(rol_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO rol(codigo, nombre, descripcion, estado)"
                + "VALUES ("
                + getCodigo() + ",'"
                + getNombre() + "','"
                + getDescripcion() + "','"
                + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }
    }

    public boolean modificar(int codigo) {
        String sql = "update rol set "
                + "nombre = '" + getNombre()+ "', "
                + "descripcion = '" + getDescripcion()+ "', "
                + "estado = '" + getEstado() + "' "
                + "where codigo = " + codigo;

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "error al editar");

            return false;
        }
    }

    public List<rol_MD> obtenerDatos(int codigo) {

        try {
            List<rol_MD> lista = new ArrayList<rol_MD>();
            String sql
                    = "select * from rol "
                    + "where codigo = " + codigo;
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                rol_MD rol = new rol_MD();

                rol.setCodigo(rs.getInt("codigo"));
                rol.setNombre(rs.getString("nombre"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setEstado(rs.getString("estado"));
                lista.add(rol);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(rol_MD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(Integer codigo) {
        String nsql = "Delete from rol where codigo = " + codigo + "";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            JOptionPane.showConfirmDialog(null, "Error al eliminar");
            return false;
        }

    }

    public List<Integer> obtenerCodigoActual() {

        try {
            List<Integer> lista = new ArrayList<Integer>();
            String sql
                    = "select max(codigo) codigo_maximo from rol ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                lista.add(rs.getInt("codigo_maximo"));
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(rol_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<rol_MD> obtenerDatosPorNombre(String nombre) {

        try {
            List<rol_MD> lista = new ArrayList<rol_MD>();
            String sql
                    = "select * from rol "
                    + "where nombre LIKE '%" + nombre + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                rol_MD rol = new rol_MD();

                rol.setCodigo(rs.getInt("codigo"));
                rol.setNombre(rs.getString("nombre"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setEstado(rs.getString("estado"));
                lista.add(rol);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(rol_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

//    public rol_MD obtenerUsuario(String nombre) {
//        try {
//            String sql
//                    = "select * from rol "
//                    + "where nombre = '" + nombre+ "'";
//            ResultSet rs = conectar.query(sql);
//            if (rs.next()) {
//               rol_MD rol = new rol_MD();
//
//                rol.setCodigo(rs.getInt("codigo"));
//                rol.setNombre(rs.getString("nombre"));
//                rol.setDescripcion(rs.getString("descripcion"));
//                rol.setEstado(rs.getString("estado"));
//                return rol;
//            }
//            rs.close();
//            return null;
//        } catch (SQLException e) {
//            Logger.getLogger(rol_BD.class.getName()).log(Level.SEVERE, null, e);
//            return null;
//        }
//    }
     public List<String> obtenerroles() {

        try {
            List<String> lista = new ArrayList<String>();
            String sql
                    = "select nombre from rol ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
               
                lista.add(nombre);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(rol_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

}
