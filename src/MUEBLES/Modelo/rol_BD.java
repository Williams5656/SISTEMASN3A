package MUEBLES.Modelo;

import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.postgresql.util.Base64;

public class rol_BD extends M_rolMD{

    Conect conectar = new Conect();
    
    public rol_BD(int codigo, String nombre, String descripcion, String estado) {
        super(codigo, nombre, descripcion, estado);
    }

    public rol_BD() {
    }
    
    
    public List<M_rolMD> mostrardatos() {
        try {
            List<M_rolMD> lista = new ArrayList<M_rolMD>();
            String sql = "select * from rol";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                M_rolMD m = new M_rolMD();
                m.setCodigo(Integer.parseInt(rs.getString("codigo")));
                m.setNombre(rs.getString("nombre"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setEstado(rs.getString("estado"));
                
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(M_personaMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean insert() {

        String sql = "insert into rol(codigo, nombre, descripcion, estado)" + "values ('" + getCodigo()+ "','" + getNombre() + "','" + getDescripcion()+ "','" + getEstado()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "¡ Falla al insertar !");
            return false;
        }
    }
    
    public boolean modificar(String codigo) {

        String sql = "update rol set \"nombre\"='" + getNombre()+ "',\"descripcion\"='" + getDescripcion()+ "',\"estado\"='" + getEstado()+ "'" + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    
    public boolean eliminar(String codigo) {
        String sql = "delete from rol" + " where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }
    }
    
    public List<M_rolMD> obtenerdatos(String codigo) {
        try {
            List<M_rolMD> lista = new ArrayList<M_rolMD>();
            String sql = "select * from rol" + " where \"codigo\" LIKE '%" + codigo + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                M_rolMD m = new M_rolMD();
                m.setCodigo(Integer.parseInt(rs.getString("codigo")));
                m.setNombre(rs.getString("nombre"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setEstado(rs.getString("estado"));

                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(M_personaMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
