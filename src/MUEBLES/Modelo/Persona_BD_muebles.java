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
import javax.swing.JOptionPane;
import org.postgresql.util.Base64;

public class Persona_BD_muebles extends M_personaMD{
    Conect conectar = new Conect();

    public Persona_BD_muebles(String cedula, String nombre, String apellido, String direccion, String celular, String nacionalidad, String fechana, Image foto) {
        super(cedula, nombre, apellido, direccion, celular, nacionalidad, fechana, foto);
    }

    public Persona_BD_muebles() {
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
    
    public List<M_personaMD> mostrardatos() {
        try {
            List<M_personaMD> lista = new ArrayList<M_personaMD>();
            String sql = "select * from persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                M_personaMD m = new M_personaMD();
                m.setCedula(rs.getString("cedula"));
                m.setNombre(rs.getString("nombres"));
                m.setApellido(rs.getString("apellidos"));
                m.setDireccion(rs.getString("direccion"));
                m.setCelular(rs.getString("celular"));
                m.setNacionalidad(rs.getString("nacionalidad"));
                m.setFechana(rs.getString("fnacimiento"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        m.setFoto(null);
                        Logger.getLogger(Persona_BD_muebles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto(null);
                }
                

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
        
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(Persona_BD_muebles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "insert into persona(cedula, nombres, apellidos, direccion, celular, nacionalidad, fnacimiento, imagen)" + "values ('" + getCedula()+ "','" + getNombre() + "','" + getApellido()+ "','" + getDireccion()+ "','" + getCelular()+ "','" + getNacionalidad()+ "','" + getFechana()+ "','" + ef+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "¡ Falla al insertar !");
            return false;
        }
    }
    
    public boolean modificar(String cedula) {
        String sql = "update usuario persona \"nombres\"='" + getNombre()+ "',\"apellidos\"='" + getApellido()+ "',\"direccion\"='" + getDireccion()+ "',\"celular\"='" + getCelular()+ "',\"nacionalidad\"='" + getNacionalidad()+ "',\"fnacimiento\"='" + getFechana()+ "'" + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    
    public boolean eliminar(String cedula) {
        String sql = "delete from persona" + " where \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }
    }
    
    public List<M_personaMD> obtenerdatos(String cedula) {
        try {
            List<M_personaMD> lista = new ArrayList<M_personaMD>();
            String sql = "select * from persona" + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                M_personaMD m = new M_personaMD();
                m.setCedula(rs.getString("cedula"));
                m.setNombre(rs.getString("nombres"));
                m.setApellido(rs.getString("apellidos"));
                m.setDireccion(rs.getString("direccion"));
                m.setCelular(rs.getString("celular"));
                m.setNacionalidad(rs.getString("nacionalidad"));
                m.setFechana(rs.getString("fnacimiento"));

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
