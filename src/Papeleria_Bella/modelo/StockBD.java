
package Papeleria_Bella.modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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


public class StockBD extends StockMD{
    Conexion conectar = new Conexion();

      
      public StockBD(String codigo, String codigo_producto, int stock, String nombre_producto) {
        super(codigo, codigo_producto, stock, nombre_producto);
    }
    
       public StockBD() {
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
    
       public List<StockMD> mostrardatos() {
        try {
            List<StockMD> lista = new ArrayList<StockMD>();
            String sql = "select * from stock";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                StockMD u = new StockMD();
                u.setCodigo(rs.getString("codigo"));
                u.setCodigo_producto(rs.getString("codigoproducto"));
                u.setStock(rs.getInt("stock"));
                u.setNombre_producto(rs.getString("nombre"));
                
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(StockBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean insertar() { 
        String sql = "INSERT INTO stock(codigo, codigoproducto, stock, nombre) VALUES ('" + getCodigo()+ "','" + getCodigo_producto()+ "','" + getStock()+ "','" + getNombre_producto()+  "')";

         if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
    public boolean modificar(String codigo) {
        String sql = "update stock set \"codigoproducto\"='" + getCodigo_producto()+ "',\"codigoproducto\"='" + getCodigo_producto()+ "',\"stock\"='" + getStock()+ "',\"nombre\"='" + getNombre_producto()+  "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    public List<StockMD> obtenerdatos(String codigo) {
        
        try {
            List<StockMD> lista = new ArrayList<StockMD>();
            String sql = "select * from stock " + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                StockMD u = new StockMD();
                u.setCodigo(rs.getString("codigo"));
                u.setCodigo_producto(rs.getString("codigoproducto"));
                u.setStock(rs.getInt("stock"));
                u.setNombre_producto(rs.getString("nombre"));
                
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(StockBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
        public boolean eliminar (String codigo){
        String sql = "delete from stock where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql)==null) {
            return true;
            
        }else{
            System.out.println("Error al eliminar");
            return false;
        }
    }
       
       public List<ProductosMD> buscardatos(String nombre) {
        try {
            List<ProductosMD> lista = new ArrayList<ProductosMD>();
            String sql = "select * from producto where \"nombre\" ILIKE '%" + nombre + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                
                ProductosMD u = new ProductosMD();
                u.setCodigo(rs.getString("codigo"));
                u.setNombre(rs.getString("nombre"));
                u.setDescripcion(rs.getString("descripcion"));
                u.setProveedor(rs.getString("proveedor"));
                u.setMarca(rs.getString("marca"));
                u.setModelo(rs.getString("modelo"));
                u.setStock(rs.getInt("stock"));
                u.setValorunitario(rs.getDouble("valorunitario"));
                u.setIva(rs.getString("iva"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);

                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(ProductosBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(ProductosBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
       
}
