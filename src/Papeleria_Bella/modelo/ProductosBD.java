
package Papeleria_Bella.modelo;

import static Papeleria_Bella.modelo.PersonaBD.toBufferedImage;
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

public class ProductosBD extends ProductosMD{
    Conexion conectar = new Conexion();

    public ProductosBD() {
    }

    public ProductosBD(String codigo, String nombre, String descripcion, String proveedor, String marca, String modelo, int stock, int valorunitario, String iva, Image foto) {
        super(codigo, nombre, descripcion, proveedor, marca, modelo, stock, valorunitario, iva, foto);
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
    
    public List<ProductosMD> mostrardatos() {
        try {
            List<ProductosMD> listau = new ArrayList<ProductosMD>();
            String sql = "select * from producto";
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
                u.setValorunitario(rs.getInt("valor unitario"));
                u.setIva(rs.getString("IVA"));
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
            Logger.getLogger(ProductosBD.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(ProductosBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO productos(codigo, nombre, descripcion, proveedor, marca, modelo, stock, valorunitario, iva, foto) VALUES ('" + getCodigo()+ "','" + getNombre() + "','" + getDescripcion()+ "','" + getProveedor()+ "','" + getMarca()+ "','" + getModelo()+ "','" + getStock()+ "','" + getValorunitario()+ "','" + getIva()+ "','" + ef + "')";

         if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
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
            Logger.getLogger(ProductosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "update producto set \"nombre\"='" + getNombre() + "',\"descripcion\"='" + getDescripcion()+ "',\"proveedor\"='" + getProveedor()+ "',\"marca\"='" + getMarca()+ "',\"modelo\"='" + getModelo()+ "',\"stock\"='" + getStock()+ "',\"valorunitario\"='" + getValorunitario()+"',\"iva\"='" + getIva()+"',\"foto\"='" + ef +"'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    public List<ProductosMD> obtenerdatos(String codigo) {
        
        try {
            List<ProductosMD> lista = new ArrayList<ProductosMD>();
            String sql = "select * from producto " + " where \"codigo\"='" + codigo + "'";
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
                u.setValorunitario(rs.getInt("valor unitario"));
                u.setIva(rs.getString("IVA"));
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
        public boolean eliminar (String codigo){
        String sql = "delete from producto where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql)==null) {
            return true;
            
        }else{
            System.out.println("Error al eliminar");
            return false;
        }
    }
        
        public List<ProductosMD> buscardatos(String codigo) {
        try {
            List<ProductosMD> lista = new ArrayList<ProductosMD>();
            String sql = "select * from producto where \"codigo\" ILIKE '%" + codigo + "%'";
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
                u.setValorunitario(rs.getInt("valor unitario"));
                u.setIva(rs.getString("IVA"));
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
