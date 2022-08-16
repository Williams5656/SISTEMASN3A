/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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
import org.postgresql.util.Base64;

/**
 *
 * @author A
 */
public class FarmaceuticoBD extends FarmaceuticoMD {

    Conect conectar = new Conect();

    public FarmaceuticoBD() {
    }

    public FarmaceuticoBD(String codigo, String nombre, String apellido, String telefono, String direccion) {
        super(codigo, nombre, apellido, telefono, direccion);
    }
//codigo para imagen base de datos
//    public static BufferedImage toBufferedImage(Image img) {
//        if (img instanceof BufferedImage) {
//            return (BufferedImage) img;
//        }
//
//        // Create a buffered image with transparency
//        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//
//        // Draw the image on to the buffered image
//        Graphics2D bGr = bimage.createGraphics();
//        bGr.drawImage(img, 0, 0, null);
//        bGr.dispose();
//
//        // Return the buffered image
//        return bimage;
//    }
//    private Image getImage(byte[] bytes, boolean isThumbnail) throws IOException {
//        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//        Iterator readers = ImageIO.getImageReadersByFormatName("png");
//        ImageReader reader = (ImageReader) readers.next();
//        Object source = bis; // File or InputStream
//        ImageInputStream iis = ImageIO.createImageInputStream(source);
//        reader.setInput(iis, true);
//        ImageReadParam param = reader.getDefaultReadParam();
//        if (isThumbnail) {
//            param.setSourceSubsampling(4, 4, 0, 0);
//        }
//        return reader.read(0, param);
//    }
//    

    public List<FarmaceuticoMD> mostrardatos() {
        List<FarmaceuticoMD> lista = new ArrayList<FarmaceuticoMD>();
        try {
            String sql = "select * from farmaceutico";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                FarmaceuticoMD m = new FarmaceuticoMD();
                m.setCodigo(rs.getString("codigo"));
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("apellido"));
                m.setTelefono(rs.getString("telefono"));
                m.setDireccion(rs.getString("direccion"));
//                  //AHORA ESTE SIRVE PARA INSERTAR LA FOTO EN LA BD
//                byte []is;
//                is = rs.getBytes("foto");
//                if (is != null) {
//                    try {
//                       is = Base64.decode(is, 0, rs.getBytes("imagen").length);
////                    BufferedImage bi=Base64.decode( ImageIO.read(is));
//                        m.setFoto(getImage(is, false));
//                    } catch (Exception ex) {
//                        m.setFoto(null);
//                        Logger.getLogger(FarmaceuticoBD.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                } else {
//                    m.setFoto(null);
//                }
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(FarmaceuticoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String nsql = "INSERT INTO farmaceutico(codigo, nombre, apellido, telefono, direccion)"
                + "VALUES ('" + getCodigo() + "','" + getNombre() + "','" + getApellido() + "','" + getTelefono() + "','" + getDireccion() + "')";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String codigo) {

        String nsql = "UPDATE farmaceutico set \"nombre\"='" + getNombre() + "',apellido ='" + getApellido() + "',telefono ='" + getTelefono() + "',direccion ='" + getDireccion() + "'\n"
                + " WHERE \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;

        }
    }

    public boolean Eliminar(String codigo) {
        String nsql = " delete from farmaceutico where codigo = '" + codigo + "';";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error eliminar");
            return false;
        }
    }

    public List<FarmaceuticoMD> obtenerDatos(String codigo) {
        List<FarmaceuticoMD> lista = new ArrayList<FarmaceuticoMD>();
        try {
            String sql = "select * from farmaceutico" + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                FarmaceuticoMD m = new FarmaceuticoMD();
                m.setCodigo(rs.getString("codigo"));
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("apellido"));
                m.setTelefono(rs.getString("telefono"));
                m.setDireccion(rs.getString("direccion"));
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(FarmaceuticoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
