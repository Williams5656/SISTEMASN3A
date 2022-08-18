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
public class persona_BD extends persona_MD {

    Conect conectar = new Conect();

    public persona_BD() {
    }

    public persona_BD(String cedula, String nombre_apellido, String direccion, String telefono, String correo, String fecha_nacimiento, String buscar, Image foto) {
        super(cedula, nombre_apellido, direccion, telefono, correo, fecha_nacimiento, buscar, foto);
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

    public List<persona_MD> mostrardatos() {

        try {
            List<persona_MD> lista = new ArrayList<persona_MD>();
            String sql = "select * from persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {

                persona_MD persona = new persona_MD();
                persona.setCedula(rs.getString("cedula"));
                persona.setNombre_apellido(rs.getString("apellido_nombre"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setTelefono(rs.getString("celular_telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setFecha_nacimiento(rs.getString("fecha_nacimiento"));

                byte[] is;
                is = rs.getBytes("imagen");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("imagen").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        persona.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        persona.setFoto(null);
                        Logger.getLogger(persona_BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    persona.setFoto(null);
                }

                lista.add(persona);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(persona_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }//Fin mostrar datos

    public boolean insertar() {

        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(persona_BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO persona(cedula, apellido_nombre, direccion, celular_telefono, correo, fecha_nacimiento, imagen)"
                + "VALUES ('"
                + getCedula() + "','"
                + getNombre_apellido().toUpperCase() + "','"
                + getDireccion().toUpperCase() + "','"
                + getTelefono() + "','"
                + getCorreo().toLowerCase() + "','"
                + getFecha_nacimiento() + "','"
                + ef + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "ERROR");
            return false;
        }
    }//Fin de insertar

    public boolean modificar(String cedula) {

        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(persona_BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "update persona set "
                + "nombre = '" + getNombre_apellido().toUpperCase() + "', "
                + "direccion = '" + getDireccion().toUpperCase() + "', "
                + "celular = '" + getTelefono() + "', "
                + "email = '" + getCorreo().toLowerCase() + "', "
                + "fechaNac = '" + getFecha_nacimiento() + "', "
                + "imagen = '" + ef + "' "
                + "where cedula = '" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }
    }//Fin del modificar

    public List<persona_BD> obtenerDatos(String cedula) {

        try {
            List<persona_BD> lista = new ArrayList<persona_BD>();
            String sql
                    = "select * from persona "
                    + "where cedula = '" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                persona_BD persona = new persona_BD();

                persona.setCedula(rs.getString("cedula"));
                persona.setNombre_apellido(rs.getString("apellido_nombre"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setTelefono(rs.getString("celular_telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setFecha_nacimiento(rs.getString("fecha_nacimiento"));

                byte[] is;
                is = rs.getBytes("imagen");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("imagen").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        persona.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        persona.setFoto(null);
                        Logger.getLogger(persona_BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    persona.setFoto(null);
                }

                lista.add(persona);
            }

            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(persona_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }//Fin de obtener datos

    public boolean eliminar(String cedula) {
        String nsql = "Delete from persona where cedula = '" + cedula + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            JOptionPane.showConfirmDialog(null, "Error al eliminar");
            return false;
        }
    }

}
