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
public class ProveedorBD extends ProveedorMD{
    Conect conectar = new Conect();

    public ProveedorBD() {
    }

    public ProveedorBD(String codigoP, String nombreP, String telefonoP, String direccionP) {
        super(codigoP, nombreP, telefonoP, direccionP);
    }
    
     public List<ProveedorMD> mostrardatos() {
        List<ProveedorMD> lista = new ArrayList<ProveedorMD>();
        try {
            String sql = "select * from proveedor";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ProveedorMD m = new ProveedorMD();
                m.setCodigoP(rs.getString("codigoP"));
                m.setNombreP(rs.getString("nombreP"));            
                m.setTelefonoP(rs.getString("telefonoP"));
                m.setDireccionP(rs.getString("direccionP"));
                
               
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String nsql = "INSERT INTO proveedor(codigoP,nombreP,telefonoP,direccionP)"
                + "VALUES ('" + getCodigoP()+ "','" + getNombreP()+ "','" +getTelefonoP()+ "','" +getDireccionP()+"')";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codigoP) {

        String nsql = "UPDATE proveedor set \"nombreP\"='" + getNombreP()+ "',telefonoP ='" + getTelefonoP()+"',direccionP ='" + getDireccionP()+ "'\n"
                + " WHERE \"codigoP\"='" + codigoP + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;

        }
    }

    public boolean Eliminar(String codigoP) {
        String nsql = " delete from proveedor where codigoP = '" + codigoP + "';";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error eliminar");
            return false;
        }
    }

    public List<ProveedorMD> obtenerDatos(String codigoP) {
        List<ProveedorMD> lista = new ArrayList<ProveedorMD>();
        try {
            String sql = "select * from proveedor" + " where \"codigoP\"='" + codigoP + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ProveedorMD m = new ProveedorMD();
                m.setCodigoP(rs.getString("codigoP"));
                m.setNombreP(rs.getString("nombreP"));            
                m.setTelefonoP(rs.getString("telefonoP"));
                m.setDireccionP(rs.getString("direccionP"));
               
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(ProveedorBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}


    
