/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hertz.Modelo;
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
import javax.swing.ImageIcon;

/**
 *
 * @author ESTEBAN
 */
public class ServiciosBD extends ServiciosMD{
    Conect conectar = new Conect();

    public ServiciosBD() {  
    }

    public ServiciosBD(String codigo, String nombre, String descripcion, String actividad, String recursos, String precio, String buscar, Image foto) {
        super(codigo, nombre, descripcion, actividad, recursos, precio, buscar, foto);
    
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
    
    public List<ServiciosMD> mostrardatos() {
        
        try {
            List<ServiciosMD> lista = new ArrayList<ServiciosMD>();
            String sql = "select * from servicios";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                
                ServiciosMD servicios = new ServiciosMD();
                servicios.setCodigo(rs.getString("codigo"));
                servicios.setNombre(rs.getString("nombre"));
                servicios.setDescripcion(rs.getString("descripcion"));
                servicios.setActividad(rs.getString("actividad"));
                servicios.setRecursos(rs.getString("recursos"));
                servicios.setPrecio(rs.getString("precio"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        servicios.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        servicios.setFoto(null);
                        Logger.getLogger(ServiciosBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    servicios.setFoto(null);
                }
                
                lista.add(servicios);   
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(ServiciosBD.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(ServiciosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "INSERT INTO servicios(codigo, nombre, descripcion, actividad, recursos , precio, foto)" + 
                "VALUES ('" + 
                getCodigo()+ "','" +
                getNombre()+ "','" +
                getDescripcion()+ "','" + 
                getActividad().toUpperCase() + "','" + 
                getRecursos()+ "','" + 
                getPrecio()+ "','" +
                ef + "')"; 

        if (conectar.noQuery(sql) == null) {
            return true;
        } 
        else {
            
            JOptionPane.showMessageDialog(null, "ERROR");
            return false;
        }
    }//Fin de insertar
    
    public boolean modificar(String codigo){
        
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(ServiciosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "update servicios set " +
                "nombre = '" + getNombre().toUpperCase() + "', " +
                "descripcion = '" + getDescripcion()+ "', " +
                "actividad = '" + getActividad().toLowerCase() + "', " +
                "recursos = '" + getRecursos()+ "', " +
                "precio = '" + getPrecio().toUpperCase() + "', " +
                "foto = '" + ef + "' " +
                "where codigo = '" + codigo + "' "  ;

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }
    }//Fin del modificar
    
    public List<ServiciosMD> obtenerDatos(String codigo) {
        
        try {
            List<ServiciosMD> lista = new ArrayList<ServiciosMD>();
            String sql = 
                    "select * from servicios " + 
                    "where codigo ILIKE '%" + codigo + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ServiciosMD servicios = new ServiciosMD();
                
               
                servicios.setCodigo(rs.getString("codigo"));
                servicios.setNombre(rs.getString("nombre"));
                servicios.setDescripcion(rs.getString("descripcion"));
                servicios.setActividad(rs.getString("actividad"));
                servicios.setRecursos(rs.getString("recursos"));
                servicios.setPrecio(rs.getString("precio"));
                                                
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        servicios.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        servicios.setFoto(null);
                        Logger.getLogger(ServiciosBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    servicios.setFoto(null);
                }
                
                lista.add(servicios);
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(ServiciosBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }//Fin de obtener datos
    
    public boolean eliminar(String codigo){
            String nsql = "update servicios set " + 
                "nombre = '" + getNombre() + "', " +
                "descripcion = '" + getDescripcion()+ "', " +
                "actividad = '" + getActividad()+ "', " +
                "recursos = '" + getRecursos()+ "', " +
                "precio = '" + getPrecio()+ "', " +
                "where codigo = '" + codigo + "'" ;
                
        if(conectar.noQuery(nsql) == null){
            return true;
        }
        else{
            JOptionPane.showConfirmDialog(null, "Error al eliminar");
            return false;
        }
    }//Fin de eliminar
    
}

    
    

