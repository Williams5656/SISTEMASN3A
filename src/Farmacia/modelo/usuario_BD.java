/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VICO5
 */
public class usuario_BD extends usuario_MD{
    Conect conectar = new Conect();

    public usuario_BD() {
    }

    public usuario_BD(String cedulau, String nombreu, String contraseña, String correou, String rol) {
        super(cedulau, nombreu, contraseña, correou, rol);
    }

    
   
 
    public List<usuario_MD> mostrardatos() {
        try {
            List<usuario_MD> listausuario = new ArrayList<usuario_MD>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                usuario_MD usua = new usuario_MD();
                usua.setCedulau(rs.getString("cedula"));
                usua.setNombreu(rs.getString("nombre"));
                usua.setCorreou(rs.getString("correo"));
                usua.setContraseña(rs.getString("contraseña"));
                usua.setRol(rs.getString("rol"));
                

                listausuario.add(usua);
            }
            rs.close();
            return listausuario;
        } catch (SQLException e) {
            Logger.getLogger(usuario_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "insert into usuario (cedula, nombre, correo, contraseña, rol)  VALUES ('" + getCedulau() + "','" + getNombreu() + "','" + getCorreou() +"','" + getContraseña()+ "','" + getRol() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String cedula) {
        String sql = "update usuario set \"nombre\"='" + getNombreu() + "',\"correo\"='" + getCorreou() + "',\"clave\"='" + getContraseña()+ "',\"rol\"='" + getRol() + "'"
                + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<usuario_MD> obtenerdatos(String cedula) {
        try {
            List<usuario_MD> listausuario = new ArrayList<usuario_MD>();
            String sql = "select * from usuario" + "  where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                usuario_MD usua = new usuario_MD();
                usua.setCedulau(rs.getString("cedula"));
                usua.setNombreu(rs.getString("nombre"));
                usua.setCorreou(rs.getString("correo"));
                usua.setContraseña(rs.getString("clave"));
                usua.setRol(rs.getString("rol"));
                

                listausuario.add(usua);
            }
            rs.close();
            return listausuario;
        } catch (SQLException e) {
            Logger.getLogger(usuario_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String cedula) {
        String nsql = "delete from usuario where \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }
    
}
