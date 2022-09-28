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
public class proveedorBD extends proveedorMD {

    Conect conectar = new Conect();

    public proveedorBD(String codigo, String laboratorio, String ruc, String telefono, String encargado, String paginaweb, String direccion, String correo) {
        super(codigo, laboratorio, ruc, telefono, encargado, paginaweb, direccion, correo);
    }


    public proveedorBD() {
    }

    public List<proveedorMD> mostrardatos() {

        try {
            List<proveedorMD> lista = new ArrayList<proveedorMD>();
            String sql = "select * from proveedor";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                
                proveedorMD pv = new proveedorMD();
                pv.setCodigo(rs.getString("codigo"));
                pv.setLaboratorio(rs.getString("laboratorio"));
                pv.setRuc(rs.getString("ruc"));
                pv.setTelefono(rs.getString("telefono"));
                pv.setEncargado(rs.getString("encargado"));
                pv.setPaginaweb(rs.getString("pagina_web"));
                pv.setDireccion(rs.getString("direccion"));
                pv.setCorreo(rs.getString("correo"));

                lista.add(pv);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(proveedorBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO proveedor(codigo, laboratorio, ruc, telefono, encargado, pagina_web, direccion, correo)"
                + "VALUES ("
                + getCodigo() + ",'"
                + getLaboratorio() + "','"
                + getRuc() + "','"
                + getTelefono() + "','"
                + getEncargado() + "','"
                + getPaginaweb() + "','"
                + getDireccion() + "','"
                + getCorreo() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }
    }

    public boolean modificar(int codigo) {
        String sql = "update proveedor set "
                + "laboratorio = '" + getLaboratorio() + "', "
                + "ruc = '" + getRuc() + "', "
                + "telefono = '" + getTelefono() + "', "
                + "encargado = '" + getEncargado() + "', "
                + "pagina_web= '" + getPaginaweb() + "', "
                + "direccion = '" + getDireccion() + "', "
                + "correo = '" + getCorreo() + "' "
                + "where codigo = " + codigo;

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "error al editar");

            return false;
        }
    }

    public List<proveedorMD> obtenerDatos(int codigo) {

        try {
            List<proveedorMD> lista = new ArrayList<proveedorMD>();
            String sql
                    = "select * from proveedor "
                    + "where codigo = " + codigo;
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                proveedorMD pv = new proveedorMD();

                pv.setCodigo(rs.getString("codigo"));
                pv.setLaboratorio(rs.getString("laboratorio"));
                pv.setRuc(rs.getString("ruc"));
                pv.setTelefono(rs.getString("telefono"));
                pv.setEncargado(rs.getString("encargado"));
                pv.setPaginaweb(rs.getString("pagina_web"));
                pv.setDireccion(rs.getString("direccion"));
                pv.setCorreo(rs.getString("correo"));

                lista.add(pv);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(proveedorBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(Integer codigo) {
        String nsql = "Delete from proveedor where codigo = " + codigo + "";
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
                    = "select max(codigo) codigo_maximo from proveedor ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                lista.add(rs.getInt("codigo_maximo"));
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(proveedorBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<proveedorMD> obtenerDatosPornombre(String ruc) {

        try {
            List<proveedorMD> lista = new ArrayList<proveedorMD>();
            String sql
                     = "select * from proveedor "
                    + "where ruc = '" + ruc + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                proveedorMD pv = new proveedorMD();

                pv.setCodigo(rs.getString("codigo"));
                pv.setLaboratorio(rs.getString("laboratorio"));
                pv.setRuc(rs.getString("ruc"));
                pv.setTelefono(rs.getString("telefono"));
                pv.setEncargado(rs.getString("encargado"));
                pv.setPaginaweb(rs.getString("pagina_web"));
                pv.setDireccion(rs.getString("direccion"));
                pv.setCorreo(rs.getString("correo"));

                lista.add(pv);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(proveedorBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public List<String> obtenerlaboratorios() {


        try {
            List<String> lista = new ArrayList<String>();
            String sql
                    = "select laboratorio from proveedor ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                String laboratorio = rs.getString("laboratorio");
               
                lista.add(laboratorio);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(proveedorBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
}
