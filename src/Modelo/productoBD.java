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
public class productoBD extends productoMD {
 Conect conectar = new Conect();

    public productoBD() {
    }

    public productoBD(int codigo, String nombrep, String presentacion, String lab, String cantidad, String pvp, String fechai, String fechasal, String desc, Image foto) {
        super(codigo, nombrep, presentacion, lab, cantidad, pvp, fechai, fechasal, desc, foto);
    }

 
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    private Image getImage(byte[] bytes, boolean isThumbnail) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        if (isThumbnail) {
            param.setSourceSubsampling(4, 4, 0, 0);
        }
        return reader.read(0, param);
    }

    public List<productoMD> mostrardatos() {

        try {
            List<productoMD> lista = new ArrayList<productoMD>();
            String sql = "select * from producto";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {

                productoMD produ = new productoMD();
                produ.setCodigo(rs.getInt("codigo"));
                produ.setNombrep(rs.getString("nombres"));
                produ.setPresentacion(rs.getString("presentacion"));
                produ.setLab(rs.getString("laboratorio"));
                produ.setCantidad(rs.getString("cantidad"));
                produ.setPvp(rs.getString("precio_venta"));
                produ.setFechai(rs.getString("fecha_inicio"));
                produ.setFechasal(rs.getString("fecha_vencimiento"));
                produ.setDesc(rs.getString("descripcion"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        produ.setFoto(getImage(is, false));
                    } catch (Exception e) {
                        produ.setFoto(null);
                        Logger.getLogger(productoBD.class.getName()).log(Level.SEVERE, null, e);
                    }
                } else {
                    produ.setFoto(null);
                }

                lista.add(produ);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(productoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }


    public boolean insertar() {

        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(productoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO producto(codigo, nombres, presentacion, laboratorio, cantidad, precio_venta, fecha_inicio, fecha_vencimiento, descripcion, foto)"
                + "VALUES ('"
                + getCodigo() + "','"
                + getNombrep().toUpperCase() + "','"
                + getPresentacion() + "','"
                + getLab() + "','"
                + getCantidad() + "','"
                + getPvp() + "','"
                + getFechai() + "','"
                + getFechasal() + "','"
                + getDesc() + "','"
                + ef + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "ERROR");
            return false;
        }
    }

    public boolean modificar(int codigo) {

        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(productoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "update producto set "
                + "nombres = '" + getNombrep().toUpperCase() + "', "
                + "presentacion = '" + getPresentacion().toUpperCase() + "', "
                + "laboratorio = '" + getLab().toLowerCase() + "', "
                + "cantidad = '" + getCantidad() + "', "
                + "precio_venta = '" + getPvp() + "', "
                + "fecha_inicio = '" + getFechai() + "', "
                + "fecha_vencimiento = '" + getFechasal() + "', "
                + "decripcion = '" + getDesc() + "', "
                + "foto = '" + ef + "' "
                + "where codigo = '" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }
    }
    
      public List<productoMD> obtenerDatos(int codigo) {

        try {
            List<productoMD> lista = new ArrayList<productoMD>();
            String sql
                    = "select * from producto "
                    + "where codigo ILIKE '%" + codigo + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                productoMD producto = new productoMD();

                
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombrep(rs.getString("nombres"));
                producto.setPresentacion(rs.getString("presentacion"));
                producto.setLab(rs.getString("laboratorio"));
                producto.setCantidad(rs.getString("cantidad"));
                producto.setPvp(rs.getString("precio_venta"));
                producto.setFechai(rs.getString("fecha_inicio"));
                producto.setFechasal(rs.getString("fecha_vencimiento"));
                producto.setDesc(rs.getString("descripcion"));

                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        producto.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        producto.setFoto(null);
                        Logger.getLogger(productoBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    producto.setFoto(null);
                }

                lista.add(producto);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(productoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

//    public List<productoMD> obtenerDatos(String codigo) {
         public productoMD obtenerDatosPorNombres(String nombres) {

        try {
//            List<productoMD> lista = new ArrayList<productoMD>();
            String sql
                    = "select * from producto "
                    + "where nombres ILIKE '%" + nombres + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {

                productoMD producto = new productoMD();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombrep(rs.getString("nombres"));
                producto.setPresentacion(rs.getString("presentacion"));
                producto.setLab(rs.getString("laboratorio"));
                producto.setCantidad(rs.getString("cantidad"));
                producto.setPvp(rs.getString("precio_venta"));
                producto.setFechai(rs.getString("fecha_incio"));
                producto.setFechasal(rs.getString("fecha_vencimiento"));
                producto.setDesc(rs.getString("descripcion"));

               byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        producto.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        producto.setFoto(null);
                        Logger.getLogger(productoBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    producto.setFoto(null);
                }

                return producto;
            }
            rs.close();
            return null;
        } catch (SQLException e) {
            Logger.getLogger(productoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
   

    public boolean eliminar(int codigo) {
        String nsql = "Delete from producto where cedula = '" + codigo + "'";
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
                    = "select max(codigo) codigo_maximo from producto ";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                lista.add(rs.getInt("codigo_maximo"));
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(productoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    

}
