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

public class VentasBD extends VentasMD {

    public static Vventas vistav;
    Conexion conectar = new Conexion();

    public VentasBD() {
    }

    public VentasBD(int IdVentas, String numfactura, String cedulacliente, String FechaVenta, Double Monto, String Estado) {
        super(IdVentas, numfactura, cedulacliente, FechaVenta, Monto, Estado);
    }

    public String NroSerieVentas() {
        PreparedStatement st;
        Statement stm;
        ResultSet rs;
        Connection con;

        String serie = "";
        String NroSerie = "Select max(numfactura) from ventas";

        try {
            con = conectar.getCon();
            st = con.prepareStatement(NroSerie);
            rs = st.executeQuery();
            while (rs.next()) {
                serie = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return serie;

    }

    
//    public List<VentasMD> mostrardatos() {
//        try {
//            List<VentasMD> listau = new ArrayList<VentasMD>();
//            String sql = "select * from ventas";
//            ResultSet rs = conectar.query(sql);
//            while (rs.next()) {
//                VentasMD u = new VentasMD();
//                u.setNumfactura(rs.getString("numero"));
//                u.setCedula(rs.getString("cedula"));
//                u.setCodigo(rs.getString("codigoproductos"));
//                u.setNombreproducto(rs.getString("nombreproducto"));
//                u.setCantidad(rs.getInt("cantidad"));
//                u.setValoru(rs.getString("valorunitario"));
//                u.setIva(rs.getString("iva"));
//                u.setTotal(rs.getString("total"));
//
//                listau.add(u);
//            }
//            rs.close();
//            return listau;
//        } catch (SQLException e) {
//            Logger.getLogger(VentasBD.class.getName()).log(Level.SEVERE, null, e);
//            return null;
//        }
//    }
//
//    public boolean insertar() {
//
//        String sql = "INSERT INTO ventas(numero, cedula, codigoproductos, nombreproducto, cantidad, valorunitario, iva, total) VALUES ('" + getNumfactura() + "','" + getCedula() + "','" + getCodigo() + "','" + getNombreproducto() + "','" + getCantidad() + "','" + getValoru() + "','" + getIva() + "','" + getTotal() + "')";
//
//        if (conectar.noQuery(sql) == null) {
//            return true;
//        } else {
//
//            System.out.println("Error");
//            return false;
//        }
//
//    }
//
//    public boolean modificar(String numero) {
//
//        String sql = "update ventas set \"cedula\"='" + getCedula() + "',\"codigoproductos\"='" + getCodigo() + "',\"nombreproducto\"='" + getNombreproducto() + "',\"cantidad\"='" + getCantidad() + "',\"valorunitario\"='" + getValoru() + "'" + "',\"iva\"='" + getIva() + "'" + "',\"total\"='" + getTotal() + "'"
//                + " where \"numero\"='" + numero + "'";
//
//        if (conectar.noQuery(sql) == null) {
//            return true;
//        } else {
//            System.out.println("error al editar");
//
//            return false;
//        }
//
//    }
//
//    public List<VentasMD> obtenerdatos(String numero) {
//
//        try {
//            List<VentasMD> lista = new ArrayList<VentasMD>();
//            String sql = "select * from ventas " + " where \"numero\"='" + numero + "'";
//            ResultSet rs = conectar.query(sql);
//            while (rs.next()) {
//                VentasMD u = new VentasMD();
//                u.setNumfactura(rs.getString("numero"));
//                u.setCedula(rs.getString("cedula"));
//                u.setCodigo(rs.getString("codigoproductos"));
//                u.setNombreproducto(rs.getString("nombreproducto"));
//                u.setCantidad(rs.getInt("cantidad"));
//                u.setValoru(rs.getString("valorunitario"));
//                u.setIva(rs.getString("iva"));
//                u.setTotal(rs.getString("total"));
//
//                lista.add(u);
//
//            }
//            rs.close();
//            return lista;
//        } catch (SQLException e) {
//            Logger.getLogger(VentasBD.class.getName()).log(Level.SEVERE, null, e);
//            return null;
//        }
//    }
//
//    public boolean eliminar(String numero) {
//        String sql = "delete from ventas where \"numero\"='" + numero + "'";
//        if (conectar.noQuery(sql) == null) {
//            return true;
//
//        } else {
//            System.out.println("Error al eliminar");
//            return false;
//        }
//    }
//
//    public List<VentasMD> buscardatos(String numero) {
//        try {
//            List<VentasMD> lista = new ArrayList<VentasMD>();
//            String sql = "select * from ventas where \"numero\" ILIKE '%" + numero + "%'";
//            ResultSet rs = conectar.query(sql);
//            while (rs.next()) {
//
//                VentasMD u = new VentasMD();
//                u.setNumfactura(rs.getString("numero"));
//                u.setCedula(rs.getString("cedula"));
//                u.setCodigo(rs.getString("codigoproductos"));
//                u.setNombreproducto(rs.getString("nombreproducto"));
//                u.setCantidad(rs.getInt("cantidad"));
//                u.setValoru(rs.getString("valorunitario"));
//                u.setIva(rs.getString("iva"));
//                u.setTotal(rs.getString("total"));
//
//                lista.add(u);
//            }
//            rs.close();
//            return lista;
//        } catch (SQLException e) {
//            Logger.getLogger(VentasBD.class.getName()).log(Level.SEVERE, null, e);
//            return null;
//        }
//    }
}
