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
         
public class EmpresaBD extends EmpresaMb {
 
    Conectar conecta = new Conectar();

    public EmpresaBD() {
    }
 
    public EmpresaBD(String ruc, String nombre,String actividad, String direccion, String ciudad, String celular, String correo, String estado, Image foto) {
        super(ruc, nombre,actividad, direccion,ciudad, celular,correo,estado, foto);
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
    

    public List<EmpresaMb> mostrardatos() {
        try {
            List<EmpresaMb> listaempresa = new ArrayList<EmpresaMb>();
            String sql = "select * from empresa";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                EmpresaMb u = new EmpresaMb();
                u.setRuc(rs.getString("ruc"));
                u.setNombre(rs.getString("nombre"));
                u.setActividad(rs.getString("actividad"));
                u.setDireccion(rs.getString("direccion"));
                u.setCiudad(rs.getString("ciudad"));
                u.setCelular(rs.getString("celular"));
                u.setCorreo(rs.getString("correo"));
                u.setEstado(rs.getString("estado"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(EmpresaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }

                listaempresa.add(u);
            }
            rs.close();
            return listaempresa;
        } catch (SQLException e) {
            Logger.getLogger(EmpresaBD.class.getName()).log(Level.SEVERE, null, e);
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
        String sql = "INSERT INTO empresa (ruc, nombre, actividad, direccion, ciudad, celular, correo, estado, foto)  VALUES ('" + getRuc()+ "','" + getNombre() + "','" + getActividad()+ "','" + getDireccion()+ "','" + getCiudad() + "','" + getCelular() + "','" + getCorreo()+ "','" + getEstado()+ "','" +  ef + "')";
  
        if (conecta.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
        
    public List<EmpresaMb> obtenerdatos(String ruc) {
        try {
            List<EmpresaMb> lista = new ArrayList<EmpresaMb>();
            String sql = "select * from empresa " + " where \"ruc\" ILIKE '%" + ruc + "%'";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                EmpresaMb m = new EmpresaMb();
                m.setRuc(rs.getString("ruc"));
                m.setNombre(rs.getString("nombre"));
                m.setActividad(rs.getString("actividad"));
                m.setDireccion(rs.getString("direccion"));
                m.setCiudad(rs.getString("ciudad"));
                m.setCelular(rs.getString("celular"));
                m.setCorreo(rs.getString("correo"));
                m.setEstado(rs.getString("estado"));
                
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        m.setFoto(null);
                        Logger.getLogger(EmpresaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto(null);
                }
      
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(EmpresaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean modificar(String ruc) {
        
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
        String sql = "update empresa set \"nombre\"='" + getNombre() +  "',\"actividad\"='" + getActividad() +"',\"direccion\"='" + getDireccion() + "',\"ciudad\"='" + getCiudad() + "',\"celular\"='" + getCelular() +  "',\"correo\"='" + getCorreo()+  "',\"estado\"='" + getEstado()+"',\"foto\"='" + ef +"'"
                + " where \"ruc\"='" + ruc + "'";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
 
    public boolean eliminar(String ruc) {   
        String sql = "delete FROM empresa where\"ruc\"='" + ruc + "'";
        if (conecta.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }

}
