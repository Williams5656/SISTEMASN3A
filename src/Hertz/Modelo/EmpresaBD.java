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
public class EmpresaBD extends EmpresaMD{
    Conect conectar = new Conect();

    public EmpresaBD() {  
    }

    public EmpresaBD(String nombre, String ruc,String ciudad, String direccion, String email, String celular,String estado, String buscar, Image foto) {
        super(nombre,ruc, ciudad, direccion, email, celular, estado, buscar, foto);  
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
    
    public List<EmpresaMD> mostrardatos() {
        
        try {
            List<EmpresaMD> lista = new ArrayList<EmpresaMD>();
            String sql = "select * from empresa";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                
                EmpresaMD empresa = new EmpresaMD();
                empresa.setNombre(rs.getString("nombre"));
                empresa.setRuc(rs.getString("ruc"));
                empresa.setCiudad(rs.getString("ciudad"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setEmail(rs.getString("email"));
                empresa.setCelular(rs.getString("celular"));
                empresa.setEstado(rs.getString("estado"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        empresa.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        empresa.setFoto(null);
                        Logger.getLogger(EmpresaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    empresa.setFoto(null);
                }
                
                lista.add(empresa);   
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(EmpresaBD.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(EmpresaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "INSERT INTO empresa(nombre, ruc, ciudad, direccion, email , celular, estado, foto)" + 
                "VALUES ('" + 
                getNombre()+ "','" +
                getRuc()+ "','" +
                getCiudad() + "','" + 
                getDireccion().toUpperCase() + "','" + 
                getEmail()+ "','" + 
                getCelular() + "','" +
                getEstado()+ "','" +
                ef + "')"; 

        if (conectar.noQuery(sql) == null) {
            return true;
        } 
        else {
            
            JOptionPane.showMessageDialog(null, "ERROR");
            return false;
        }
    }//Fin de insertar
    
    public boolean modificar(String ruc){
        
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(EmpresaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "update empresa set " +
                "nombre = '" + getNombre().toUpperCase() + "', " +
                "ciudad = '" + getCiudad().toUpperCase() + "', " +
                "direccion = '" + getDireccion()+ "', " +
                "email = '" + getEmail().toLowerCase() + "', " +
                "celular = '" + getCelular()+ "', " +
                "estado = '" + getEstado().toUpperCase() + "', " +
                "foto = '" + ef + "' " +
                "where ruc = '" + ruc + "' "  ;

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }
    }//Fin del modificar
    
    public List<EmpresaMD> obtenerDatos(String ruc) {
        
        try {
            List<EmpresaMD> lista = new ArrayList<EmpresaMD>();
            String sql = 
                    "select * from empresa " + 
                    "where ruc ILIKE '%" + ruc + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                EmpresaMD empresa = new EmpresaMD();
                
               
                empresa.setNombre(rs.getString("nombre"));
                empresa.setRuc(rs.getString("ruc"));
                empresa.setCiudad(rs.getString("ciudad"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setEmail(rs.getString("email"));
                empresa.setCelular(rs.getString("celular"));
                empresa.setEstado(rs.getString("estado"));
                                
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        empresa.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        empresa.setFoto(null);
                        Logger.getLogger(EmpresaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    empresa.setFoto(null);
                }
                
                lista.add(empresa);
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(EmpresaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }//Fin de obtener datos
    
    public boolean eliminar(String ruc){
            String nsql = "update empresa set " + 
                "nombre = '" + getNombre() + "', " +
                "ciudad = '" + getCiudad()+ "', " +
                "direccion = '" + getDireccion()+ "', " +
                "email = '" + getEmail()+ "', " +
                "celular = '" + getCelular()+ "', " +
                "estado = 'Inactivo' " +
                "where ruc = '" + ruc + "'" ;
                
        if(conectar.noQuery(nsql) == null){
            return true;
        }
        else{
            JOptionPane.showConfirmDialog(null, "Error al eliminar");
            return false;
        }
    }//Fin de eliminar
    
}

    
    

