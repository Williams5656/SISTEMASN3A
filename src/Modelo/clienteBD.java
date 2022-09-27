/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;
import org.postgresql.util.Base64;

/**
 *
 * @author VICO5
 */
public class clienteBD extends clienteMD {

    Conect conectar = new Conect();

    public clienteBD() {
    }

    public clienteBD(int codigo, String cedula, String nombre, String telefono, String alergias, String enfermedades, String direccion) {
        super(codigo, cedula, nombre, telefono, alergias, enfermedades, direccion);
    }

    public List<clienteMD> mostrardatos() {

        try {
            List<clienteMD> lista = new ArrayList<clienteMD>();
            String sql = "select * from cliente";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                clienteMD cliente = new clienteMD();

                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setCedula(rs.getString("cedula"));
                cliente.setNombre(rs.getString("nombres"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setAlergias(rs.getString("alergias"));
                cliente.setEnfermedades(rs.getString("enfermedades"));
                cliente.setDireccion(rs.getString("direccion"));
                lista.add(cliente);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(clienteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO cliente(codigo, cedula, nombres, telefono, alergias, enfermedades, direccion)"
                + "VALUES ("
                + getCodigo() + ",'"
                + getCedula() + "','"
                + getNombre() + "','"
                + getTelefono() + "','"
                + getAlergias() + "','"
                + getEnfermedades() + "','"
                + getDireccion() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }
    }

    public boolean modificar(int codigo) {
        String sql = "update cliente set "
                + "cedula = '" + getCedula() + "', "
                
                + "nombres = '" + getNombre() + "', "
                
                + "telefono = '" + getTelefono() + "', "
                
                + "alergias = '" + getAlergias() + "', "
                
                + " enfermedades = '" + getEnfermedades() + "', "
                
                + "direccion = '" + getDireccion() + "' "
                
                + "where codigo = " + codigo;

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "error al editar");

            return false;
        }
    }

    public List<clienteMD> obtenerDatos(int codigo) {

        try {
            List<clienteMD> lista = new ArrayList<clienteMD>();
            String sql
                    = "select * from cliente "
                    + "where codigo = " + codigo;
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                clienteMD cliente = new clienteMD();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setCedula(rs.getString("cedula"));
                cliente.setNombre(rs.getString("nombres"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setAlergias(rs.getString("alergias"));
                cliente.setEnfermedades(rs.getString("enfermedades"));
                cliente.setDireccion(rs.getString("direccion"));
                lista.add(cliente);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(clienteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(Integer codigo) {
        String nsql = "Delete from cliente where codigo = " + codigo + "";
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
                    = "select max(codigo) codigo_maximo from cliente ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                lista.add(rs.getInt("codigo_maximo"));
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(clienteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<clienteMD> obtenerDatosPorNombre(String nombre) {

        try {
            List<clienteMD> lista = new ArrayList<clienteMD>();
            String sql
                    = "select * from cliente "
                    + "where nombres LIKE '%" + nombre + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                 clienteMD cliente = new clienteMD();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setCedula(rs.getString("cedula"));
                cliente.setNombre(rs.getString("nombres"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setAlergias(rs.getString("alergias"));
                cliente.setEnfermedades(rs.getString("enfermedades"));
                cliente.setDireccion(rs.getString("direccion"));
                lista.add(cliente);
            }
     
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(clienteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public clienteMD obtenerUsuario(String nombrecliente) {
        try {
            String sql
                    = "select * from cliente " + nombrecliente + "'";
            ResultSet rs = conectar.query(sql);
            if (rs.next()) {
                 clienteMD cliente = new clienteMD();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setCedula(rs.getString("cedula"));
                cliente.setNombre(rs.getString("nombres"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setAlergias(rs.getString("alergias"));
                cliente.setEnfermedades(rs.getString("enfermedades"));
                cliente.setDireccion(rs.getString("direccion"));
                
                return cliente;
                
            }
            rs.close();
            return null;
        } catch (SQLException e) {
            Logger.getLogger(usuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
