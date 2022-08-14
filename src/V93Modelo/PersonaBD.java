package V93Modelo;

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
  
public class PersonaBD extends PersonaMb {
 
    Conectar conecta = new Conectar();

    public PersonaBD() {
    }
 
    public PersonaBD(String cedula, String nombre, String direccion, String fecha_nacimiento, String ciudad, String celular, Image foto) {
        super(cedula, nombre, direccion, fecha_nacimiento, ciudad, celular, foto);
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
    

    public List<PersonaMb> mostrardatos() {
        try {
            List<PersonaMb> listausuario = new ArrayList<PersonaMb>();
            String sql = "select * from persona";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                PersonaMb u = new PersonaMb();
                u.setCedula(rs.getString("cedula"));
                u.setNombre(rs.getString("nombre"));
                u.setDireccion(rs.getString("direccion"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                u.setCiudad(rs.getString("ciudad"));
                u.setCelular(rs.getString("celular"));
                
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }

                listausuario.add(u);
            }
            rs.close();
            return listausuario;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "INSERT INTO persona (cedula, nombre, direccion, fecha_nacimiento, ciudad, celular, foto)  VALUES ('" + getCedula() + "','" + getNombre() + "','" + getDireccion() + "','" + getFecha_nacimiento() + "','" + getCiudad() + "','" + getCelular() + "','" +  ef + "')";
  
        if (conecta.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public List<PersonaMb> obtenerdatos(String cedula) {
        try {
            List<PersonaMb> lista = new ArrayList<PersonaMb>();
            String sql = "select * from persona " + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                PersonaMb m = new PersonaMb();
                m.setCedula(rs.getString("cedula"));
                m.setNombre(rs.getString("nombre"));
                m.setDireccion(rs.getString("direccion"));
                m.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                m.setCiudad(rs.getString("ciudad"));
                m.setCelular(rs.getString("celular"));
                
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        m.setFoto(null);
                        Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto(null);
                }
  
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean modificar(String cedula) {
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "update persona set \"nombre\"='" + getNombre() + "',\"direccion\"='" + getDireccion() + "',\"fecha_nacimiento\"='" + getFecha_nacimiento() + "',\"ciudad\"='" + getCiudad() + "',\"celular\"='" + getCelular() +  "',\"foto\"='" + ef +"'"
                + " where \"cedula\"='" + cedula + "'";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
 
    public boolean eliminar(String cedula) {
        String sql = "delete FROM persona where\"cedula\"='" + cedula + "'";
        if (conecta.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }

}
