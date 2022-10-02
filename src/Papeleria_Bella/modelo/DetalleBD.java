package Papeleria_Bella.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetalleBD extends DetalleMD {

    Conexion conectar = new Conexion();

    public boolean insertardetalle() {

        String sql = "INSERT INTO detalleventa(idventa, idproducto, cantidad, precioventa) VALUES ('" + getIdVentas() + "','" + getIdProducto() + "','" + getCantidad() + "','" + getPrecioVenta() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean ActualizarStock(int cant, String id) {
        PreparedStatement ps;
        Connection con;
        String sql = "UPDATE productos SET stock = ? WHERE id = ?";
        try {
            con = conectar.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
