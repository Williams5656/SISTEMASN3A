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

public class ClientesBD extends ClientesMD {

    public static Vclientes vistac;

    public ClientesBD() {
    }

    Conexion conectar = new Conexion();

    public List<ClientesMD> mostrardatos() {
        try {
            List<ClientesMD> listau = new ArrayList<ClientesMD>();
            String sql = "select * from clientes";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ClientesMD u = new ClientesMD();
                u.setCodigo(rs.getString("codigo"));
                u.setCedula(rs.getString("cedula"));
                u.setNombres(rs.getString("nombres"));
                u.setCelular(rs.getString("celular"));
                u.setEstado(rs.getString("direccion"));
                u.setDiscapacidad(rs.getString("discapacidad"));
                u.setPorcentaje_discapacidad(rs.getString("porcentaje_discapacidad"));

                listau.add(u);
            }
            rs.close();
            return listau;
        } catch (SQLException e) {
            Logger.getLogger(ClientesBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {

        String sql = "INSERT INTO clientes(codigo, cedula, nombres, celular, estado, discapacidad, porcentaje_discapacidad) VALUES ('" + getCodigo() + "','" + getCedula() + "','" + getNombres() + "','" + getCelular() + "','" + getEstado() + "','" + getDiscapacidad() + "','" + getPorcentaje_discapacidad() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String codigo) {

        String sql = "update clientes set \"cedula\"='" + getCedula() + "',\"nombres\"='" + getNombres() + "',\"celular\"='" + getCelular() + "',\"direccion\"='" + getEstado() + "',\"discapacidad\"='" + getDiscapacidad() + "',\"porcentaje_discapacidad\"='" + getPorcentaje_discapacidad() + "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<ClientesMD> obtenerdatos(String codigo) {

        try {
            List<ClientesMD> lista = new ArrayList<ClientesMD>();
            String sql = "select * from clientes " + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ClientesMD u = new ClientesMD();
                u.setCodigo(rs.getString("codigo"));
                u.setCedula(rs.getString("cedula"));
                u.setNombres(rs.getString("nombres"));
                u.setCelular(rs.getString("celular"));
                u.setEstado(rs.getString("direccion"));
                u.setDiscapacidad(rs.getString("discapacidad"));
                u.setPorcentaje_discapacidad(rs.getString("porcentaje_discapacidad"));

                lista.add(u);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(ClientesBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String codigo) {
        String sql = "delete from clientes where \"codigo\"='" + codigo + "'";
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

                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
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
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
