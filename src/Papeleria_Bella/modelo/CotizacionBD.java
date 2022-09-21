
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

public class CotizacionBD extends CotizacionMD{
    public static Vcotizacion vistacot;

    public CotizacionBD() {
    }

    public CotizacionBD(String codigo, String cedula, String codigoproductos, String nombreproductos, int cantidad, int valorunitario, String iva, int total) {
        super(codigo, cedula, codigoproductos, nombreproductos, cantidad, valorunitario, iva, total);
    }
    
    Conexion conectar = new Conexion();
    
    public List<CotizacionMD> mostrardatos() {
        try {
            List<CotizacionMD> listau = new ArrayList<CotizacionMD>();
            String sql = "select * from cotizacion";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                CotizacionMD u = new CotizacionMD();
                u.setCodigo(rs.getString("codigo"));
                u.setCedula(rs.getString("cedula"));
                u.setCodigoproductos(rs.getString("codigoproductos"));
                u.setNombreproductos(rs.getString("nombreproductos"));
                u.setCantidad(rs.getInt("cantidad"));
                u.setValorunitario(rs.getInt("valorunitario"));
                u.setIva(rs.getString("iva"));
                u.setTotal(rs.getInt("total"));

                listau.add(u);
            }
            rs.close();
            return listau;
        } catch (SQLException e) {
            Logger.getLogger(CotizacionBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {

        String sql = "INSERT INTO cotizacion(codigo, cedula, codigoproductos, nombreproductos, cantidad, valorunitario, iva, total) VALUES ('" + getCodigo()+ "','" + getCedula() + "','" + getCodigoproductos()+ "','" + getNombreproductos()+ "','" + getCantidad()+ "','" + getValorunitario()+ "','" + getIva()+ "','" + getTotal()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String codigo) {

        String sql = "update cotizacion set \"cedula\"='" + getCedula()+ "',\"codigoproductos\"='" + getCodigoproductos()+ "',\"nombreproducto\"='" + getNombreproductos()+ "',\"cantidad\"='" + getCantidad()+ "',\"valorunitario\"='" + getValorunitario()+ "'"+ "',\"iva\"='" + getIva()+ "'"+ "',\"total\"='" + getTotal()+ "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<CotizacionMD> obtenerdatos(String codigo) {

        try {
            List<CotizacionMD> lista = new ArrayList<CotizacionMD>();
            String sql = "select * from cotizacion " + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                CotizacionMD u = new CotizacionMD();
                u.setCodigo(rs.getString("codigo"));
                u.setCedula(rs.getString("cedula"));
                u.setCodigoproductos(rs.getString("codigoproductos"));
                u.setNombreproductos(rs.getString("nombreproductos"));
                u.setCantidad(rs.getInt("cantidad"));
                u.setValorunitario(rs.getInt("valorunitario"));
                u.setIva(rs.getString("iva"));
                u.setTotal(rs.getInt("total"));

                lista.add(u);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(CotizacionBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codigo) {
        String sql = "delete from cotizacion where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("Error al eliminar");
            return false;
        }
    }
    
    
    
}
