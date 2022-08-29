
package Papeleria_Bella.modelo;

import Papeleria_Bella.vista.*;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.postgresql.util.Base64;


public class DatosBD extends DatosMD{
    
    public static Vdatos vistad;

    public DatosBD() {
    }

    public DatosBD(String codigo, String ruc, String nombrec, String razons, String matrizp, String celular) {
        super(codigo, ruc, nombrec, razons, matrizp, celular);
    }
    
    Conexion conectar = new Conexion();
    
    public List<DatosMD> mostrardatos() {
        try {
            List<DatosMD> listad = new ArrayList<DatosMD>();
            String sql = "select * from datos_papeleria";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                DatosMD u = new DatosMD();
                u.setCodigo(rs.getString("codigo"));
                u.setRuc(rs.getString("ruc"));
                u.setNombrec(rs.getString("nombrecomercial"));
                u.setRazons(rs.getString("razon"));
                u.setMatrizp(rs.getString("matriz"));
                u.setCelular(rs.getString("celular"));

                listad.add(u);
            }
            rs.close();
            return listad;
        } catch (SQLException e) {
            Logger.getLogger(DatosBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean insertar() {

        String sql = "INSERT INTO datos_papeleria(codigo, ruc, nombrecomercial, razon, matriz, celular) VALUES ('" + getCodigo() + "','" + getRuc()+ "','" + getNombrec()+ "','" + getRazons()+ "','" + getMatrizp()+ "','" + getCelular()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String codigo) {

        String sql = "update datos_papeleria set \"ruc\"='" + getRuc()+ "',\"nombrecomercial\"='" + getNombrec()+ "',\"razon\"='" + getRazons()+ "',\"matriz\"='" + getMatrizp()+ "',\"celular\"='" + getCelular()+ "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<DatosMD> obtenerdatos(String codigo) {

        try {
            List<DatosMD> listad = new ArrayList<DatosMD>();
            String sql = "select * from datos_papeleria " + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                DatosMD u = new DatosMD();
                u.setCodigo(rs.getString("codigo"));
                u.setRuc(rs.getString("ruc"));
                u.setNombrec(rs.getString("nombrecomercial"));
                u.setRazons(rs.getString("razon"));
                u.setMatrizp(rs.getString("matriz"));
                u.setCelular(rs.getString("celular"));

                listad.add(u);

            }
            rs.close();
            return listad;
        } catch (SQLException e) {
            Logger.getLogger(DatosBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codigo) {
        String sql = "delete from datos_papeleria where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("Error al eliminar");
            return false;
        }
    }
    public List<DatosMD> buscardatos(String ruc) {
        DatosMD u = new DatosMD();
        try {
            List<DatosMD> listad = new ArrayList<DatosMD>();
            String sql = "select * from datos_papeleria where \"ruc\"='" + ruc + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {

                u.setRuc(rs.getString("ruc"));
                u.setNombrec(rs.getString("nombrecomercial"));
                u.setRazons(rs.getString("razon"));
                u.setMatrizp(rs.getString("matriz"));
                u.setCelular(rs.getString("celular"));
                
                
                listad.add(u);
            }
            rs.close();
            return listad;
        } catch (SQLException e) {
            Logger.getLogger(DatosMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
