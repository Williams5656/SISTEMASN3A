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
         
public class ProveedorBD extends ProveedorMb {
 
    Conectar conecta = new Conectar();

    public ProveedorBD() {
    }
 
    public ProveedorBD(String ruc, String nombre, String celular, String direccion, String razon) {
        super(ruc,nombre,celular,direccion,razon);
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

  
    

    public List<ProveedorMb> mostrardatos() {
        try {
            List<ProveedorMb> listaproveedor = new ArrayList<ProveedorMb>();
            String sql = "select * from proveedor";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                ProveedorMb u = new ProveedorMb();
                u.setRuc(rs.getString("ruc1"));
                u.setNombre(rs.getString("nombre"));
                u.setCelular(rs.getString("celular"));
                u.setDireccion(rs.getString("direccion"));
                u.setRazon(rs.getString("razon"));
              
                
               

                listaproveedor.add(u);
            }
            rs.close();
            return listaproveedor;
        } catch (SQLException e) {
            Logger.getLogger(ProveedorBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
  
    public boolean insertar() {
        
        
        String sql = "INSERT INTO proveedor (ruc1, nombre,celular, direccion, razon)  VALUES ('" + getRuc() + "','" + getNombre() + "','" + getCelular() + "','" + getDireccion() + "','" + getRazon() + "')";
  
        if (conecta.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
        
    public List<ProveedorMb> obtenerdatos(String ruc) {
        try {
            List<ProveedorMb> lista = new ArrayList<ProveedorMb>();
            String sql = "select * from proveedor where\"ruc1\"='" + ruc + "'";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                ProveedorMb m = new ProveedorMb();
                m.setRuc(rs.getString("ruc1"));
                m.setNombre(rs.getString("nombre"));
                m.setCelular(rs.getString("celular"));
                m.setDireccion(rs.getString("direccion"));
                m.setRazon(rs.getString("razon"));
                
          
      
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(ProveedorBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean modificar(String ruc) {
        
        
        String sql = "update proveedor set \"nombre\"='" + getNombre() +"',\"celular\"='" + getCelular()+ "',\"direccion\"='" + getDireccion() + "',\"razon\"='" + getRazon() +  "'"
                + " where \"ruc1\"='" + ruc + "'";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
 
    public boolean eliminar(String ruc) {   
        String sql = "delete  FROM proveedor where\"ruc1\"='" + ruc + "'";
        if (conecta.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }

}
