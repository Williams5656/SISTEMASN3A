
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

public class ProveedoresBD extends ProveedoresMD {
    Conexion conectar = new Conexion();

    public ProveedoresBD() {
    }

    public ProveedoresBD(String codigo, String ruc, String nombrecom, String representanteleg, String celular) {
        super(codigo, ruc, nombrecom, representanteleg, celular);
    }

    public List<ProveedoresMD> mostrardatos() {
        try {
            List<ProveedoresMD> listau = new ArrayList<ProveedoresMD>();
            String sql = "select * from proveedores";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ProveedoresMD u = new ProveedoresMD();
                u.setCodigo(rs.getString("codigo"));
                u.setRuc(rs.getString("ruc"));
                u.setNombrecom(rs.getString("nombrecomercial"));
                u.setRepresentanteleg(rs.getString("representantelegal"));
                u.setCelular(rs.getString("celular"));
                listau.add(u);
            }
            rs.close();
            return listau;
        } catch (SQLException e) {
            Logger.getLogger(ProveedoresBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean insertar() { 
        String sql = "INSERT INTO proveedores(codigo, ruc, nombrecomercial, representantelegal, celular) VALUES ('" + getCodigo()+ "','" + getRuc()+ "','" + getNombrecom()+ "','" + getRepresentanteleg()+ "','" + getCelular() + "')";

         if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
    public boolean modificar(String codigo) {
        String sql = "update proveedores set \"ruc\"='" + getRuc()+ "',\"nombrecomercial\"='" + getNombrecom()+ "',\"representantelegal\"='" + getRepresentanteleg()+ "',\"celular\"='" + getCelular()+  "'"
                + " where \"codigo\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    public List<ProveedoresMD> obtenerdatos(String codigo) {
        
        try {
            List<ProveedoresMD> lista = new ArrayList<ProveedoresMD>();
            String sql = "select * from proveedores " + " where \"codigo\"='" + codigo + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ProveedoresMD u = new ProveedoresMD();
                u.setCodigo(rs.getString("codigo"));
                u.setRuc(rs.getString("ruc"));
                u.setNombrecom(rs.getString("nombrecomercial"));
                u.setRepresentanteleg(rs.getString("representantelegal"));
                u.setCelular(rs.getString("celular"));
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(ProveedoresBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
        public boolean eliminar (String codigo){
        String sql = "delete from proveedores where \"codigo\"='" + codigo + "'";
        if (conectar.noQuery(sql)==null) {
            return true;
            
        }else{
            System.out.println("Error al eliminar");
            return false;
        }
    }
        public List<ProveedoresMD> buscardatos(String ruc) {
        try {
            List<ProveedoresMD> lista = new ArrayList<ProveedoresMD>();
            String sql = "select * from proveedores where \"ruc\" ILIKE '%" + ruc + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                ProveedoresMD u = new ProveedoresMD();
                u.setCodigo(rs.getString("codigo"));
                u.setRuc(rs.getString("ruc"));
                u.setNombrecom(rs.getString("nombrecomercial"));
                u.setRepresentanteleg(rs.getString("representantelegal"));
                u.setCelular(rs.getString("celular"));
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(ProveedoresBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
}
