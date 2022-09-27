package V93Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleBD extends DetalleMb {

    Conectar cn = new Conectar();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List<DetalleMb> mostrardatos() {
        try {
            List<DetalleMb> listadetalle = new ArrayList<DetalleMb>();
            String sql = "select * from detalle";
            ResultSet rs = cn.query(sql);
            while (rs.next()) {
                DetalleMb u = new DetalleMb();
                u.setId(rs.getInt("ID_DETALLE"));
                u.setCod_pro(rs.getString("cod_producto"));
                u.setCantidad(rs.getInt("cantidad"));
                u.setPrecio(rs.getDouble("total"));
                u.setId_venta(Integer.parseInt(rs.getString("ID_VENTA")));

                listadetalle.add(u);
            }
            rs.close();
            return listadetalle;
        } catch (SQLException e) {
            Logger.getLogger(DetalleBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean RegistrarDetalle() {
       String sql = "INSERT INTO detalle(cod_producto, cantidad, precio, id_venta)  VALUES ('" + getCod_pro()+ "','" + getCantidad()+ "','" + getPrecio()+ "','" + getId_venta()+ "')";
  
        if (cn.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
   
        public int IdVenta() {
        int id = 0;
        String sql = "SELECT MAX(codigo_venta) FROM venta";
        try {
            ps = cn.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
    
}




