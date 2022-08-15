package modelo;

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
import javax.swing.JOptionPane;
import org.postgresql.util.Base64;
import vista.*;

public class PersonaBD extends PersonaMD {

    Conectar conectar = new Conectar();
    public static V_Persona Vistapersona;
    String ef = null;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public PersonaBD() {
    }

    public PersonaBD(String cedula, String nombres, String apellidos, String usuario, String clave, String telefono, String correo, String rol, Image foto_perfil) {
        super(cedula, nombres, apellidos, usuario, clave, telefono, correo, rol, foto_perfil);
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

    public List<PersonaMD> mostrardatos() {
        try {
            List<PersonaMD> listapersona = new ArrayList<>();
            String sql = "select * from persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PersonaMD m = new PersonaMD();
                m.setCedula(rs.getString("CEDULA"));
                m.setNombres(rs.getString("NOMBRES"));
                m.setApellidos(rs.getString("APELLIDOS"));
                m.setUsuario(rs.getString("USUARIO"));
                m.setClave(rs.getString("CLAVE"));
                m.setTelefono(rs.getString("TELEFONO"));
                m.setCorreo(rs.getString("CORREO_ELECTRONICO"));
                m.setRol(rs.getString("ROL"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto_perfil(getImage(is, false));
                    } catch (IOException | SQLException ex) {
                        m.setFoto_perfil(null);
                        Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto_perfil(null);
                }
                listapersona.add(m);
            }
            rs.close();
            return listapersona;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto_perfil());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "INSERT INTO persona(cedula, nombres, apellidos, usuario, clave, telefono, correo_electronico, rol,foto)" + "VALUES ('" + getCedula() + "','" + getNombres() + "','" + getApellidos() + "','" + getUsuario() + "','" + getClave() + "','" + getTelefono() + "','" + getCorreo() + "','" + getRol() + "','" + ef + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }

    }

    public boolean modificar(String cedula) {
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto_perfil());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "update persona set \"nombres\"='" + getNombres() + "',\"apellidos\"='" + getApellidos() + "',\"usuario\"='" + getUsuario() + "',\"clave\"='" + getClave() + "',\"telefono\"='" + getTelefono() + "',\"correo_electronico\"='" + getCorreo() + "',\"rol\"='" + getRol() + "',\"foto\"='" + ef + "'"
                + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");

            return false;
        }
    }

    public List<PersonaMD> obtenerdatos(String cedula) {
        try {
            List<PersonaMD> listapersona = new ArrayList<>();
            String sql = "select * from persona" + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PersonaMD m = new PersonaMD();
                m.setCedula(rs.getString("CEDULA"));
                m.setNombres(rs.getString("NOMBRES"));
                m.setApellidos(rs.getString("APELLIDOS"));
                m.setUsuario(rs.getString("USUARIO"));
                m.setClave(rs.getString("CLAVE"));
                m.setTelefono(rs.getString("TELEFONO"));
                m.setCorreo(rs.getString("CORREO_ELECTRONICO"));
                m.setRol(rs.getString("ROL"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setFoto_perfil(getImage(is, false));
                    } catch (IOException | SQLException ex) {
                        m.setFoto_perfil(null);
                        Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setFoto_perfil(null);
                }
                listapersona.add(m);
            }
            rs.close();
            return listapersona;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean Eliminar(String cedula) {
        String sql = "Delete from persona "
                + "where \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al Eliminar");
            return false;
        }
    }

    public PersonaMD validar(String User, String Pass) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        PersonaMD m = new PersonaMD();
        String validar = "Select * From persona\n"
                + "where persona.usuario=? and persona.clave=?;";
        try {
            con = conectar.getCon();
            st = con.prepareStatement(validar);
            st.setString(1, User);
            st.setString(2, Pass);
            rs = st.executeQuery();
            while (rs.next()) {
                m.setCedula(rs.getString("CEDULA"));
                m.setNombres(rs.getString("NOMBRES"));
                m.setApellidos(rs.getString("APELLIDOS"));
                m.setUsuario(rs.getString("USUARIO"));
                m.setClave(rs.getString("CLAVE"));
                m.setTelefono(rs.getString("TELEFONO"));
                m.setCorreo(rs.getString("CORREO_ELECTRONICO"));
                m.setRol(rs.getString("ROL"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return m;
    }

}
