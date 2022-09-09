package V93Modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.swing.DefaultComboBoxModel;
import org.postgresql.util.Base64;
         
public class ProductoBD extends ProductoMb {
 
    Conectar conecta = new Conectar();

    public ProductoBD() {
    }
 
    public ProductoBD(String codigo, String descripcion,String proveedor, int stock, double precio, Image foto) {
        super(codigo, descripcion, proveedor, stock, precio,foto);
    }
    public DefaultComboBoxModel NombreProveedor() {
        DefaultComboBoxModel listaroles = new DefaultComboBoxModel();
        ResultSet rs = conecta.query("Select * from proveedor order by nombre");
        try {
            while (rs.next()) {
                listaroles.addElement(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listaroles;
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
    

    public List<ProductoMb> mostrardatos() {
        try {
            List<ProductoMb> listaproducto = new ArrayList<ProductoMb>();
            String sql = "select * from producto";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                ProductoMb u = new ProductoMb();
                u.setCodigo(rs.getString("codigo"));
                u.setDescripcion(rs.getString("descripcion"));
                u.setProveedor(rs.getString("proveedor"));
                u.setStock(rs.getInt("stock"));
                u.setPrecio(rs.getDouble("precio"));
               
                
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }

                listaproducto.add(u);
            }
            rs.close();
            return listaproducto;
        } catch (SQLException e) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
  public ProductoMb BuscarPro(String cod){
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
            ProductoMb producto = new  ProductoMb();
            
         String sql = "SELECT * FROM producto WHERE codigo = ?";
         try{
             con = conecta.getConnection();
             ps = con.prepareStatement(sql);
             ps.setString(1, cod);
             rs = ps.executeQuery();
             
             if (rs.next()){
                 producto.setCodigo(rs.getString("codigo"));
                 producto.setDescripcion(rs.getString("descripcion"));
                 producto.setProveedor(rs.getString("proveedor"));
                 producto.setStock(rs.getInt("stock"));
                 producto.setPrecio(rs.getDouble("precio"));
                   
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        producto.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        producto.setFoto(null);
                        Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    producto.setFoto(null);
                }
             }
         }catch (SQLException e){
             System.out.println(e.toString());
         }
         
         return producto;
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
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "INSERT INTO producto (codigo, descripcion, proveedor, stock, precio, foto)  VALUES ('" + getCodigo() + "','" + getDescripcion()+ "','" + getProveedor() + "','" + getStock() + "','" + getPrecio() + "','"  +  ef + "')";
  
        if (conecta.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
        
    public List<ProductoMb> obtenerdatos(String codigo) {
        try {
            List<ProductoMb> lista = new ArrayList<ProductoMb>();
            String sql = "select * from producto " + " where \"codigo\" ILIKE '%" + codigo + "%'";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                ProductoMb m = new ProductoMb();
                m.setCodigo(rs.getString("codigo"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setProveedor(rs.getString("proveedor"));
                m.setStock(rs.getInt("stock"));
                m.setPrecio(rs.getDouble("precio"));
                
                
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        m.setFoto(null);
                        Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto(null);
                }
      
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean modificar(String codigo) {
        
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "update producto set \"descripcion\"='" + getDescripcion()+ "',\"proveedor\"='" + getProveedor()+ "',\"stock\"='" + getStock()+ "',\"precio\"='" + getPrecio()+ "',\"foto\"='" + ef +"'"
                + " where \"codigo\"='" + codigo + "'";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
 
    public boolean eliminar(String codigo) {   
        String sql = "delete FROM producto where\"codigo\"='" + codigo + "'";
        if (conecta.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }

}
