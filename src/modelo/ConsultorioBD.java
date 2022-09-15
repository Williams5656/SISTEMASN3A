package modelo;

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

public class ConsultorioBD extends ConsultorioMD {

    Conectar conectar = new Conectar();
    String ef = null;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public ConsultorioBD() {
    }

    public ConsultorioBD(String codigo, String nombre, String direccion, String telefono, Image fondo, String lema) {
        super(codigo, nombre, direccion, telefono, fondo, lema);
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

    public List<ConsultorioMD> buscardatos(String codigo) {
        try {
            List<ConsultorioMD> listaconsultorio = new ArrayList<ConsultorioMD>();
            String sql = "select * from consultorio where \"codigo\" ILIKE '%" + codigo + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ConsultorioMD cbd = new ConsultorioMD();
                cbd.setCodigo(rs.getString("CODIGO"));
                cbd.setNombre(rs.getString("NOMBRE"));
                cbd.setDireccion(rs.getString("DIRECCION"));
                cbd.setTelefono(rs.getString("TELEFONO"));
                byte[] is;
                is = rs.getBytes("FONDO");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("FONDO").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        cbd.setFondo(getImage(is, false));
                    } catch (IOException | SQLException ex) {
                        cbd.setFondo(null);
                        Logger.getLogger(ConsultorioBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    cbd.setFondo(null);
                }
                cbd.setLema(rs.getString("LEMA"));
                listaconsultorio.add(cbd);
            }
            rs.close();
            return listaconsultorio;
        } catch (SQLException e) {
            Logger.getLogger(ConsultorioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<ConsultorioMD> mostrardatos() {
        try {
            List<ConsultorioMD> listaconsultorio = new ArrayList<>();
            String sql = "select * from persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ConsultorioMD cbd = new ConsultorioMD();
                cbd.setCodigo(rs.getString("CODIGO"));
                cbd.setNombre(rs.getString("NOMBRE"));
                cbd.setDireccion(rs.getString("DIRECCION"));
                cbd.setTelefono(rs.getString("TELEFONO"));
                byte[] is;
                is = rs.getBytes("FONDO");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("FONDO").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        cbd.setFondo(getImage(is, false));
                    } catch (IOException | SQLException ex) {
                        cbd.setFondo(null);
                        Logger.getLogger(ConsultorioBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    cbd.setFondo(null);
                }
                cbd.setLema(rs.getString("LEMA"));
                listaconsultorio.add(cbd);
            }
            rs.close();
            return listaconsultorio;
        } catch (SQLException e) {
            Logger.getLogger(ConsultorioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFondo());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(ConsultorioBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        String sql = "INSERT INTO consultorio(codigo, nombre, direccion, telefono, fondo, lema)" + "VALUES ('" + getCodigo() + "','" + getNombre() + "','" + getDireccion() + "','" + getTelefono() + "','" + ef + "','" + getLema() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }

    }

    public boolean modificar(String codigo) {
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFondo());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(ConsultorioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "update consultorio set \"nombre\"='" + getNombre() + "',\"direccion\"='" + getDireccion() + "',\"telefono\"='" + getTelefono() + "',\"fondo\"='" + ef + "',\"lema\"='" + getLema() + "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");

            return false;
        }
    }

    public List<ConsultorioMD> obtenerdatos(String codigo) {
        try {
            List<ConsultorioMD> listaconsultorio= new ArrayList<>();
            String sql = "select * from consultorio" + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                   ConsultorioMD cbd= new ConsultorioMD();
                cbd.setCodigo(rs.getString("CODIGO"));
                cbd.setNombre(rs.getString("NOMBRE"));
                cbd.setDireccion(rs.getString("DIRECCION"));
                cbd.setTelefono(rs.getString("TELEFONO"));
                byte[] is;
                is = rs.getBytes("FONDO");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("FONDO").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        cbd.setFondo(getImage(is, false));
                    } catch (IOException | SQLException ex) {
                        cbd.setFondo(null);
                        Logger.getLogger(ConsultorioBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    cbd.setFondo(null);
                }
                cbd.setLema(rs.getString("LEMA"));
                listaconsultorio.add(cbd);
            }
            rs.close();
            return listaconsultorio;
        } catch (SQLException e) {
            Logger.getLogger(ConsultorioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean Eliminar(String codigo) {
        String sql = "Delete from consultorio "
                + "where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al Eliminar");
            return false;
        }
    }
}
