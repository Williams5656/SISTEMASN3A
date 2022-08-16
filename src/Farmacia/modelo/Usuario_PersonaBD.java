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
public class Usuario_PersonaBD extends Usuario_PersonaMD{
    Conect conectar = new Conect();

    public Usuario_PersonaBD() {
    }

    public Usuario_PersonaBD(String cedula, String nombres, String fechaNacimiento, String rol, String nombreU, String clave, String estado,Image foto) {
        super(cedula, nombres, fechaNacimiento, rol, nombreU, clave, estado,foto);
    }
    //codigo para imagen base de datos
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
    

 public List<Usuario_PersonaMD> mostrardatos() {
        List<Usuario_PersonaMD> lista = new ArrayList<Usuario_PersonaMD>();
        try {
            String sql = "select * from usuario_persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                Usuario_PersonaMD m = new Usuario_PersonaMD();
                m.setCedula(rs.getString("cedula"));
                m.setNombres(rs.getString("nombres"));
                m.setFechaNacimiento(rs.getString("fechaNacimiento"));
                m.setRol(rs.getString("rol"));
                m.setNombreU(rs.getString("nombreU"));
                m.setClave(rs.getString("clave"));
                m.setEstado(rs.getString("estado"));     
                //AHORA ESTE SIRVE PARA INSERTAR LA FOTO EN LA BD
                byte []is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                       is = Base64.decode(is, 0, rs.getBytes("imagen").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        m.setFoto(null);
                        Logger.getLogger(FarmaceuticoBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto(null);
                }
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(Usuario_PersonaBD.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(Usuario_PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nsql = "INSERT INTO usuario_persona(cedula, nombres, fechaNacimiento, rol, nombreU, clave, estado,foto)"
                + "VALUES ('" + getCedula()+ "','" + getNombres()+ "','" + getFechaNacimiento()+ "','" +getRol()+ "','" + getNombreU()+ "','"+ getClave()+ "','" +getEstado()+"','"+ getFoto()+ "')";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String cedula) {

        String nsql = "UPDATE usuario_persona set \"nombres\"='" + getNombres()+ "',fechaNacimiento ='" + getFechaNacimiento()+ "',rol ='" + getRol()+ "',nombreU ='"+ getNombreU()+ "',clave ='"  + getClave()+"',estado ='" + getEstado()+ "'\n"
                + " WHERE \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;

        }
    }

    public boolean Eliminar(String cedula) {
        String nsql = " delete from usuario_persona where cedula = '" + cedula + "';";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error eliminar");
            return false;
        }
    }

    public List<Usuario_PersonaMD> obtenerDatos(String cedula) {
        List<Usuario_PersonaMD> lista = new ArrayList<Usuario_PersonaMD>();
        try {
            String sql = "select * from usuario_persona" + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                Usuario_PersonaMD m = new Usuario_PersonaMD();
                m.setCedula(rs.getString("cedula"));
                m.setNombres(rs.getString("nombres"));
                m.setFechaNacimiento(rs.getString("fechaNacimiento"));
                m.setRol(rs.getString("rol"));
                m.setNombreU(rs.getString("nombreU"));
                m.setClave(rs.getString("clave"));
                m.setEstado(rs.getString("estado"));
               is = rs.getBytes("foto");
                if (is != null) {
                    try {
                       is = Base64.decode(is, 0, rs.getBytes("imagen").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        m.setFoto(null);
                        Logger.getLogger(FarmaceuticoBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto(null);
                }
                lista.add(m);
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (Exception e) {
            Logger.getLogger(Usuario_PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean desactivar(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean activar(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
