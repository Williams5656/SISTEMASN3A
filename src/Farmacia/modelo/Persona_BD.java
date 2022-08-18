/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.modelo;

import Farmacia.vista.*;
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
import org.postgresql.util.Base64;

/**
 *
 * @author VICO5
 */
public class Persona_BD extends Persona_MD {

    Conect conectar = new Conect();
    public static Vista_Persona Vistapersona;
    String ef = null;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public Persona_BD() {
    }

    public Persona_BD(String cedula, String nombre_apellido, String fechaNacimiento, String correo, String telefono, Image foto) {
        super(cedula, nombre_apellido, fechaNacimiento, correo, telefono, foto);
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

    public List<Persona_MD> mostrardatos() {
        try {
            List<Persona_MD> listapersona = new ArrayList<>();
            String sql = "select * from persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                Persona_MD m = new Persona_MD();
                m.setCedula(rs.getString("cedula"));
                m.setNombre_apellido(rs.getString("nombre_apellido"));
                m.setCorreo(rs.getString("correo"));
                m.setTelefono(rs.getString("telefono"));
                byte[] is;
                is = rs.getBytes("FOTO");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("FOTO").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto(getImage(is, false));
                    } catch (IOException | SQLException ex) {
                        m.setFoto(null);
                        Logger.getLogger(Persona_BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto(null);
                }
                listapersona.add(m);
            }
            rs.close();
            return listapersona;
        } catch (SQLException e) {
            Logger.getLogger(Persona_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String f = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            f = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(Persona_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "INSERT INTO persona(cedula, nombre_apellido, correo, telefono, foto)" + "VALUES ('" + getCedula() + "','" + getNombre_apellido() + "','" + getCorreo() + "','" + getTelefono() + "','" + f + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }

    }

    public boolean modificar(String cedula) {
        String f = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            f = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(Persona_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "update persona set \"nombre_apellido\"='" + getNombre_apellido() + "',\"correo\"='" + getCorreo() + "',\"telefono\"='" + getTelefono() + "',\"foto\"='" + f + "'"
                + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");

            return false;
        }
    }

    public List<Persona_MD> obtenerdatos(String cedula) {
        try {
            List<Persona_MD> listapersona = new ArrayList<>();
            String sql = "select * from persona" + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                Persona_MD m = new Persona_MD();
                m.setCedula(rs.getString("cedula"));
                m.setNombre_apellido(rs.getString("nombre_apellido"));
                m.setCorreo(rs.getString("correo"));
                m.setTelefono(rs.getString("telefono"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto(getImage(is, false));
                    } catch (IOException | SQLException ex) {
                        m.setFoto(null);
                        Logger.getLogger(Persona_BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto(null);
                }
                listapersona.add(m);
            }
            rs.close();
            return listapersona;
        } catch (SQLException e) {
            Logger.getLogger(Persona_BD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean Eliminar(String cedula) {
        String sql = "Delete from persona "
                + "where \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al Eliminar");
            return false;
        }
    }

    public Persona_MD validar(String User, String Pass) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        Persona_MD m = new Persona_MD();
        String validar = "Select * From persona\n"
                + "where persona.usuario=? and persona.clave=?;";
        try {
            con = conectar.getCon();
            st = con.prepareStatement(validar);
            st.setString(1, User);
            st.setString(2, Pass);
            rs = st.executeQuery();
            while (rs.next()) {
                m.setCedula(rs.getString("cedula"));
                m.setNombre_apellido(rs.getString("nombre_apellido"));
                m.setCorreo(rs.getString("correo"));
                m.setTelefono(rs.getString("telefono"));
                byte[] is;
                is = rs.getBytes("FOTO");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("FOTO").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto(getImage(is, false));
                    } catch (IOException | SQLException ex) {
                        m.setFoto(null);
                        Logger.getLogger(Persona_BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto(null);
                }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return m;
    }

}
