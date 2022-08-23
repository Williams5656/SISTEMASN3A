package Papeleria_Bella.modelo;

import Papeleria_Bella.vista.*;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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

public class UsuarioBD extends UsuarioMD {

    public static Vusuario vista;

    public UsuarioBD() {
    }

    Conexion conectar = new Conexion();

    public DefaultComboBoxModel ROL() {
        DefaultComboBoxModel listarol = new DefaultComboBoxModel();
        ResultSet rs = conectar.query("Select * from rol order by nombre");
        try {
            while (rs.next()) {
                listarol.addElement(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listarol;
    }

    public List<UsuarioMD> mostrardatos() {
        try {
            List<UsuarioMD> listau = new ArrayList<UsuarioMD>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD u = new UsuarioMD();
                u.setCodigo(rs.getString("codigo"));
                u.setCedula(rs.getString("cedula"));
                u.setUsuario(rs.getString("usuario"));
                u.setClave(rs.getString("clave"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));

                listau.add(u);
            }
            rs.close();
            return listau;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {

        String sql = "INSERT INTO usuario(codigo, cedula, usuario, clave, rol, estado) VALUES ('" + getCodigo() + "','" + getCedula() + "','" + getUsuario() + "','" + getClave() + "','" + getRol() + "','" + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String cedula) {

        String sql = "update usuario set \"usuario\"='" + getUsuario() + "',\"clave\"='" + getClave() + "',\"rol\"='" + getRol() + "'"
                + " where \"codigo\"='" + cedula + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<UsuarioMD> obtenerdatos(String cedula) {

        try {
            List<UsuarioMD> lista = new ArrayList<UsuarioMD>();
            String sql = "select * from usuario " + " where \"codigo\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMD u = new UsuarioMD();
                u.setCodigo(rs.getString("codigo"));
                u.setCedula(rs.getString("cedula"));
                u.setUsuario(rs.getString("usuario"));
                u.setClave(rs.getString("clave"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));

                lista.add(u);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String cedula) {
        String sql = "delete from usuario where \"codigo\"='" + cedula + "'";
        if (conectar.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("Error al eliminar");
            return false;
        }
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

    public List<PersonaMD> buscardatos(String cedula) {
        PersonaMD u = new PersonaMD();
        try {
            List<PersonaMD> lista = new ArrayList<PersonaMD>();
            String sql = "select * from persona where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {

                u.setCedula(rs.getString("cedula"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setEmail(rs.getString("email"));
                byte[] is;
                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        u.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        u.setFoto(null);
                        Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    u.setFoto(null);
                }
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PersonaMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public UsuarioMD validar(String User, String Pass) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        UsuarioMD u = new UsuarioMD();
        String validar = "Select * From usuario\n"
                + "where usuario.usuario=? and usuario.clave=?;";
        try {
            con = conectar.getCon();

            st = con.prepareStatement(validar);
            st.setString(1, User);
            st.setString(2, Pass);
            rs = st.executeQuery();

            while (rs.next()) {

                u.setCodigo(rs.getString("codigo"));
                u.setCedula(rs.getString("cedula"));
                u.setUsuario(rs.getString("usuario"));
                u.setClave(rs.getString("clave"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return u;
    }
}
