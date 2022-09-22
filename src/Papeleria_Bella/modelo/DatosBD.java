
package Papeleria_Bella.modelo;

import Papeleria_Bella.vista.*;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;
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
import javax.swing.JOptionPane;
import org.postgresql.util.Base64;


public class DatosBD extends DatosMD{
    
    public static Vdatos vistad;

    public DatosBD() {
    }

    public DatosBD(String codigo, String ruc, String nombrec, String razons, String matrizp, String celular, String estado, String email, Image foto) {
        super(codigo, ruc, nombrec, razons, matrizp, celular, estado, email, foto);
    }

    

    
    
    Conexion conectar = new Conexion();
    
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
    
    public List<DatosMD> mostrardatos() {
        try {
            List<DatosMD> listad = new ArrayList<DatosMD>();
            String sql = "select * from datos_papeleria";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                DatosMD u = new DatosMD();
                u.setCodigo(rs.getString("codigo"));
                u.setRuc(rs.getString("ruc"));
                u.setNombrec(rs.getString("nombrecomercial"));
                u.setRazons(rs.getString("razon"));
                u.setMatrizp(rs.getString("matriz"));
                u.setCelular(rs.getString("celular"));
                u.setEstado(rs.getString("estado"));
                u.setEmail(rs.getString("email"));
                
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);

                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(DatosBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }
                
                listad.add(u);
            }
            rs.close();
            return listad;
        } catch (SQLException e) {
            Logger.getLogger(DatosBD.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(DatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO datos_papeleria(codigo, ruc, nombrecomercial, razon, matriz, celular, estado,email, foto) VALUES ('" + getCodigo() + "','" + getRuc()+ "','" + getNombrec()+ "','" + getRazons()+ "','" + getMatrizp()+ "','" + getCelular()+ "','" + getEstado()+ "', '"+getEmail() + "','" + ef + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String codigo) {

        String sql = "update datos_papeleria set \"ruc\"='" + getRuc()+ "',\"nombrecomercial\"='" + getNombrec()+ "',\"razon\"='" + getRazons()+ "',\"matriz\"='" + getMatrizp()+ "',\"celular\"='" + getCelular()+ "',\"estado\"='" + getEstado()+ "',\"email\"='" + getEmail()+ "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    
      public boolean modificarestadoalguardar(String estado) {

        String sql = "update datos_papeleria set \"estado\"='Inactivo'"
                + " where \"estado\"='" + estado + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
//          public boolean modificarestado(String estado,String codigo) {
//
//        String sql = "update datos_papeleria set \"estado\"='Activo'"
//                + " where \"estado\"='" + estado + "'and \"codigo\"='" + codigo+ "'";
//
//        if (conectar.noQuery(sql) == null) {
//            return true;
//        } else {
//            System.out.println("error al editar");
//
//            return false;
//        }

    

    public List<DatosMD> obtenerdatos(String codigo) {

        try {
            List<DatosMD> listad = new ArrayList<DatosMD>();
            String sql = "select * from datos_papeleria " + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                DatosMD u = new DatosMD();
                u.setCodigo(rs.getString("codigo"));
                u.setRuc(rs.getString("ruc"));
                u.setNombrec(rs.getString("nombrecomercial"));
                u.setRazons(rs.getString("razon"));
                u.setMatrizp(rs.getString("matriz"));
                u.setCelular(rs.getString("celular"));
                u.setEstado(rs.getString("estado"));
                u.setEmail(rs.getString("email"));
                
               
                   byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(DatosBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }
                listad.add(u);

            }
            rs.close();
            return listad;
        } catch (SQLException e) {
            Logger.getLogger(DatosBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codigo) {
        String sql = "delete from datos_papeleria where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("Error al eliminar");
            return false;
        }
    }
    
    public List<DatosMD> buscardatos(String ruc) {
        DatosMD u = new DatosMD();
        try {
            List<DatosMD> listad = new ArrayList<DatosMD>();
            String sql = "select * from datos_papeleria where \"ruc\"='" + ruc + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {

                u.setRuc(rs.getString("ruc"));
                u.setNombrec(rs.getString("nombrecomercial"));
                u.setRazons(rs.getString("razon"));
                u.setMatrizp(rs.getString("matriz"));
                u.setCelular(rs.getString("celular"));
                u.setEstado(rs.getString("estado"));
                u.setEmail(rs.getString("email"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(DatosBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }
                listad.add(u);
            }
            rs.close();
            return listad;
        } catch (SQLException e) {
            Logger.getLogger(DatosMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
