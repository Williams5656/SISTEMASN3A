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
public class roles_BD extends roles_MD {

    Conect conectar = new Conect();

    public roles_BD() {
    }

    public roles_BD(String codigo, String descripcion, String estado, String nombres) {
        super(codigo, descripcion, estado, nombres);
    }

    public List<roles_MD> mostrardatos() {
        try {
            List<roles_MD> lista = new ArrayList<roles_MD>();
            String sql = "select * from roles";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                roles_MD rol = new roles_MD();
                rol.setCodigo(rs.getString("codigo"));
                rol.setNombres(rs.getString("nombres"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setEstado(rs.getString("estado"));

                lista.add(rol);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(roles_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "insert into roles (codigo, nombres, descripcion, estado)  VALUES ('" + getCodigo() + "','" + getNombres() + "','" + getDescripcion() + "','" + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String codigo) {
        String sql = "update roles set \"nombres\"='" + getNombres() + "',\"descripcion\"='" + getDescripcion() + "',\"estado\"='" + getEstado() + "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<roles_MD> obtenerdatos(String codigo) {
        try {
            List<roles_MD> lista = new ArrayList<roles_MD>();
            String sql = "select * from roles " + " where \"codigo\" ILIKE '%" + codigo + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                roles_MD rol = new roles_MD();
                rol.setCodigo(rs.getString("codigo"));
                rol.setNombres(rs.getString("nombres"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setEstado(rs.getString("estado"));

                lista.add(rol);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(roles_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codigo) {
        String sql = "update roles set \"estado\"='" + "INACTIVO" + "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }

}
