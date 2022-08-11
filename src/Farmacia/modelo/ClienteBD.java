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
public class ClienteBD extends ClienteMD {
     Conect conectar = new Conect();

    public ClienteBD() {
    }

    public ClienteBD(String codigoC, String nombreC, String apellidoC, String telefonoC, String direccionC) {
        super(codigoC, nombreC, apellidoC, telefonoC, direccionC);
    }
 public List<ClienteMD> mostrardatos() {
        List<ClienteMD> lista = new ArrayList<ClienteMD>();
        try {
            String sql = "select * from cliente";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ClienteMD m = new ClienteMD();
                m.setCodigoC(rs.getString("codigoC"));
                m.setNombreC(rs.getString("nombreC"));
                m.setApellidoC(rs.getString("apellidoC"));
                m.setTelefonoC(rs.getString("telefonoC"));
                m.setDireccionC(rs.getString("direccionC"));
               
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
        String nsql = "INSERT INTO cliente(codigoC,nombreC,apellidoC,telefonoC,direccionC)"
                + "VALUES ('" + getCodigoC()+ "','" + getNombreC()+ "','" + getApellidoC()+ "','" +getTelefonoC()+ "','" +getDireccionC()+"')";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codigo) {

        String nsql = "UPDATE cliente set \"nombreC\"='" + getNombreC()+ "',apellidoC ='" + getApellidoC()+ "',telefonoC ='" + getTelefonoC()+"',direccionC ='" + getDireccionC()+ "'\n"
                + " WHERE \"codigoC\"='" + codigo + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;

        }
    }

    public boolean Eliminar(String codigo) {
        String nsql = " delete from cliente where codigoC = '" + codigo + "';";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error eliminar");
            return false;
        }
    }

    public List<ClienteMD> obtenerDatos(String codigo) {
        List<ClienteMD> lista = new ArrayList<ClienteMD>();
        try {
            String sql = "select * from cliente" + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ClienteMD m = new ClienteMD();
                m.setCodigoC(rs.getString("codigoC"));
                m.setNombreC(rs.getString("nombreC"));
                m.setApellidoC(rs.getString("apellidoC"));
                m.setTelefonoC(rs.getString("telefonoC"));
                m.setDireccionC(rs.getString("direccionC"));
               
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}

