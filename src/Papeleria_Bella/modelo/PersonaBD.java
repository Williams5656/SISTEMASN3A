package Papeleria_Bella.modelo;

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
     
public class PersonaBD extends PersonaMD {
  
    Conexion conectar = new Conexion();

    public PersonaBD(String cedula, String nombres, String apellidos, String telefono, String direccion, String email, Image foto) {
        super(cedula, nombres, apellidos, telefono, direccion, email, foto);
    }

   

    public PersonaBD() {
    }

    

     public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        
        return bimage;
    }   

    private Image getImage(byte[] bytes, boolean isThumbnail) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; 
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        if (isThumbnail) {
            param.setSourceSubsampling(4, 4, 0, 0);
        }
        return reader.read(0, param);
    }
    

    public List<PersonaMD> mostrardatos() {
        try {
            List<PersonaMD> listau = new ArrayList<PersonaMD>();
            String sql = "select * from persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PersonaMD u = new PersonaMD();
                u.setCedula(rs.getString("cedula"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setEmail(rs.getString("email"));
                
            byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);

                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }

                listau.add(u);
            }
            rs.close();
            return listau;
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

        String sql = "INSERT INTO persona(cedula, nombres, apellidos, telefono, direccion, email, foto) VALUES ('" + getCedula() + "','" + getNombres() + "','" + getApellidos() + "','" + getTelefono() + "','" + getDireccion() + "','" + getEmail() + "','" + ef + "')";

         if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
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
        String sql = "update persona set \"nombres\"='" + getNombres() + "',\"apellidos\"='" + getApellidos() + "',\"telefono\"='" + getTelefono() + "',\"direccion\"='" + getDireccion() + "',\"email\"='" + getEmail() + "',\"foto\"='" + ef +"'"
                + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<PersonaMD> obtenerdatos(String cedula) {
        
        try {
            List<PersonaMD> lista = new ArrayList<PersonaMD>();
            String sql = "select * from persona " + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PersonaMD u = new PersonaMD();
                u.setCedula(rs.getString("cedula"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                 u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setEmail(rs.getString("email"));
                
               
                   byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }
  
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean eliminar (String cedula){
        String sql = "delete from persona where \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(sql)==null) {
            return true;
            
        }else{
            System.out.println("Error al eliminar");
            return false;
        }
    }
    
    public List<PersonaMD> buscardatos(String cedula) {
        try {
            List<PersonaMD> lista = new ArrayList<PersonaMD>();
            String sql = "select * from persona where \"cedula\" ILIKE '%" + cedula + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                
                PersonaMD u = new PersonaMD();
                u.setCedula(rs.getString("cedula"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setEmail(rs.getString("email"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PersonaMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
