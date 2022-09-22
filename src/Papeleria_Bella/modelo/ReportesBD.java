
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


public class ReportesBD extends ReportesMD {
    public static Vreportes vistarep;

    public ReportesBD() {
    }

    public ReportesBD(String codigo, String nombreprod, String cantidadprod, int ingreso, int egreso) {
        super(codigo, nombreprod, cantidadprod, ingreso, egreso);
    }
    
    Conexion conectar = new Conexion();
    
    public List<ReportesMD> mostrardatos() {
        try {
            List<ReportesMD> listau = new ArrayList<ReportesMD>();
            String sql = "select * from reportes";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ReportesMD u = new ReportesMD();
                u.setCodigo(rs.getString("codigo"));
                u.setNombreprod(rs.getString("nombreproducto"));
                u.setCantidadprod(rs.getString("numeroproductos"));
                u.setIngreso(rs.getInt("ingreso"));
                u.setEgreso(rs.getInt("egreso"));

                listau.add(u);
            }
            rs.close();
            return listau;
        } catch (SQLException e) {
            Logger.getLogger(ReportesBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {

        String sql = "INSERT INTO reportes(codigo, nombreproducto, numeroproductos, ingreso, egreso) VALUES ('" + getCodigo()+ "','" + getNombreprod()+ "','" + getCantidadprod()+ "','" + getIngreso()+ "','" + getEgreso()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String codigo) {

        String sql = "update reportes set \"nombreproducto\"='" + getNombreprod()+ "',\"numeroproductos\"='" + getCantidadprod()+ "',\"ingreso\"='" + getIngreso()+ "',\"egreso\"='" + getEgreso()+ "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<ReportesMD> obtenerdatos(String codigo) {

        try {
            List<ReportesMD> lista = new ArrayList<ReportesMD>();
            String sql = "select * from reportes " + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ReportesMD u = new ReportesMD();
                u.setCodigo(rs.getString("codigo"));
                u.setNombreprod(rs.getString("nombreproducto"));
                u.setCantidadprod(rs.getString("numeroproductos"));
                u.setIngreso(rs.getInt("ingreso"));
                u.setEgreso(rs.getInt("egreso"));

                lista.add(u);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(ReportesBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codigo) {
        String sql = "delete from reportes where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("Error al eliminar");
            return false;
        }
    }
}
