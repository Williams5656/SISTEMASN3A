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
public class FarmaceuticoBD extends FarmaceuticoMD {

    Conect conectar = new Conect();

    public FarmaceuticoBD() {
    }

    public FarmaceuticoBD(String codigo, String nombre, String apellido, String telefono, String direccion) {
        super(codigo, nombre, apellido, telefono, direccion);
    }

    public List<FarmaceuticoMD> mostrardatos() {
        List<FarmaceuticoMD> lista = new ArrayList<FarmaceuticoMD>();
        try {
            String sql = "select * from farmaceutico";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                FarmaceuticoMD m = new FarmaceuticoMD();
                m.setCodigo(rs.getString("codigo"));
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("apellido"));
                m.setTelefono(rs.getString("telefono"));
                m.setDireccion(rs.getString("direccion"));
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(FarmaceuticoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String nsql = "INSERT INTO farmaceutico(codigo, nombre, apellido, telefono, direccion)"
                + "VALUES ('" + getCodigo() + "','" + getNombre() + "','" + getApellido() + "','" + getTelefono() + "','" + getDireccion() + "')";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codigo) {

        String nsql = "UPDATE farmaceutico set \"nombre\"='" + getNombre() + "',apellido ='" + getApellido() + "',telefono ='" + getTelefono() + "',direccion ='" + getDireccion() + "'\n"
                + " WHERE \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;

        }
    }

    public boolean Eliminar(String codigo) {
        String nsql = " delete from farmaceutico where codigo = '" + codigo + "';";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error eliminar");
            return false;
        }
    }

    public List<FarmaceuticoMD> obtenerDatos(String codigo) {
        List<FarmaceuticoMD> lista = new ArrayList<FarmaceuticoMD>();
        try {
            String sql = "select * from farmaceutico" + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                FarmaceuticoMD m = new FarmaceuticoMD();
                m.setCodigo(rs.getString("codigo"));
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("apellido"));
                m.setTelefono(rs.getString("telefono"));
                m.setDireccion(rs.getString("direccion"));
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(FarmaceuticoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
