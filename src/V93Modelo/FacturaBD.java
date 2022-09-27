package V93Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FacturaBD extends FacturaMb {

    Conectar cn = new Conectar();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List<FacturaMb> mostrardatos() {
        try {
            List<FacturaMb> listafactura = new ArrayList<FacturaMb>();
            String sql = "select * from venta";
            ResultSet rs = cn.query(sql);
            while (rs.next()) {
                FacturaMb u = new FacturaMb();
                u.setId(rs.getInt("CODIGO_VENTA"));
                u.setCliente(rs.getString("cliente"));
                u.setVendedor(rs.getString("vendedor"));
                u.setTotal(rs.getDouble("total"));

                listafactura.add(u);
            }
            rs.close();
            return listafactura;
        } catch (SQLException e) {
            Logger.getLogger(FacturaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {

        String sql = "INSERT INTO venta(cliente,vendedor,total)  VALUES ('" + getCliente() + "','" + getVendedor() + "','" + getTotal() + "')";

        if (cn.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean ActualizarStock(int cant, String cod) {
        String sql = "UPDATE producto SET stock = ? WHERE codigo = ?";
        try {
            ps = cn.getCon().prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public List<FacturaMb> ListarVentas() {
        try {
            List<FacturaMb> listaventa = new ArrayList<FacturaMb>();
            String sql = "select * from venta";
            ResultSet rs = cn.query(sql);
            while (rs.next()) {
                FacturaMb vent = new FacturaMb();
                vent.setId(rs.getInt("codigo_venta"));
                vent.setCliente(rs.getString("cliente"));
                vent.setVendedor(rs.getString("vendedor"));
                vent.setTotal(rs.getDouble("total"));
                listaventa.add(vent);
            }
            rs.close();
            return listaventa;
        } catch (SQLException e) {
            Logger.getLogger(ProveedorBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

}
