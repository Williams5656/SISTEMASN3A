/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A
 */
public class UsuarioBD extends UsuarioMD{
    Conect conectar = new Conect();

    public UsuarioBD() {
    }

    public UsuarioBD(String cedula, String nombres, String fechaNacimiento, String rol, String nombreU, String clave, String estado) {
        super(cedula, nombres, fechaNacimiento, rol, nombreU, clave, estado);
    }

 public List<UsuarioMD> mostrardatos() {
        List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
        try {
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD m = new UsuarioMD();
                m.setCedula(rs.getString("cedula"));
                m.setNombres(rs.getString("nombres"));
                m.setFechaNacimiento(rs.getString("fechaNacimiento"));
                m.setRol(rs.getString("rol"));
                m.setNombreU(rs.getString("nombreU"));
                m.setClave(rs.getString("clave"));
                m.setEstado(rs.getString("estado"));
                
               
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String nsql = "INSERT INTO usuario(cedula, nombres, fechaNacimiento, rol, nombreU, clave, estado)"
                + "VALUES ('" + getCedula()+ "','" + getNombres()+ "','" + getFechaNacimiento()+ "','" +getRol()+ "','" + getNombreU()+ "','"+ getClave()+ "','" +getEstado()+"')";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String cedula) {

        String nsql = "UPDATE usuario set \"nombres\"='" + getNombres()+ "',fechaNacimiento ='" + getFechaNacimiento()+ "',rol ='" + getRol()+ "',nombreU ='"+ getNombreU()+ "',clave ='"  + getClave()+"',estado ='" + getEstado()+ "'\n"
                + " WHERE \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;

        }
    }

    public boolean Eliminar(String cedula) {
        String nsql = " delete from usuario where cedula = '" + cedula + "';";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error eliminar");
            return false;
        }
    }

    public List<UsuarioMD> obtenerDatos(String cedula) {
        List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
        try {
            String sql = "select * from usuario" + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD m = new UsuarioMD();
                m.setCedula(rs.getString("cedula"));
                m.setNombres(rs.getString("nombres"));
                m.setFechaNacimiento(rs.getString("fechaNacimiento"));
                m.setRol(rs.getString("rol"));
                m.setNombreU(rs.getString("nombreU"));
                m.setClave(rs.getString("clave"));
                m.setEstado(rs.getString("estado"));
               
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
