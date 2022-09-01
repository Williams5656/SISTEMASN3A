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
public class clienteBD extends clienteMD{
    
    Conect conectar = new Conect();

    public clienteBD() {
    }

    public clienteBD(String id_producto, String nombre_pro, String descripcion_pro, Image foto) {
        super(id_producto, nombre_pro, descripcion_pro, foto);
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

    public List<clienteMD> mostrardatos() {

        try {
            List<clienteMD> lista = new ArrayList<clienteMD>();
            String sql = "select * from cliente";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {

                clienteMD cliente = new clienteMD();
                cliente.setId_producto(rs.getString("id_producto"));
                cliente.setNombre_pro(rs.getString("nombre_pro"));
                cliente.setDescripcion_pro(rs.getString("descripcion_pro"));
               

                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                       cliente.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        cliente.setFoto(null);
                        Logger.getLogger(personaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    cliente.setFoto(null);
                }

                lista.add(cliente);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(personaBD.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(personaBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO cliente(id_producto, nombre_pro, descripcion_pro, foto)"
                + "VALUES ('"
                + getId_producto()+ "','"
                + getNombre_pro().toUpperCase() + "','"
                + getDescripcion_pro().toUpperCase() + "','"
                + ef + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "ERROR");
            return false;
        }
    }

    public boolean modificar(String id_producto) {

        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(personaBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "update cliente set "
                + "nombre_pro = '" + getNombre_pro().toUpperCase() + "', "
                + "descripcion_pro = '" + getDescripcion_pro().toUpperCase() + "', "
                + "foto = '" + ef + "' "
                + "where id_producto = '" + id_producto + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }
    }

    public List<clienteMD> obtenerDatos(String id_producto) {
        List<clienteMD> lista = new ArrayList<clienteMD>();
        try {
            
            String sql
                    = "select * from cliente "
                    + "where cedula ILIKE '%" + id_producto + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
               clienteMD cliente = new clienteMD();

                cliente.setId_producto(rs.getString("id_producto"));
                cliente.setNombre_pro(rs.getString("nombre_pro"));
                cliente.setDescripcion_pro(rs.getString("descripcion_pro"));
               
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        cliente.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        cliente.setFoto(null);
                        Logger.getLogger(personaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    cliente.setFoto(null);
                }

                lista.add(cliente);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(personaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String id_producto) {
        String nsql = "Delete from cliente where id_producto= '" + id_producto+ "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            JOptionPane.showConfirmDialog(null, "Error al eliminar");
            return false;
        }
    }
    
}
