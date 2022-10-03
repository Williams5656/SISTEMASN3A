package Papeleria_Bella.modelo;

import Papeleria_Bella.vista.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class VentasBD extends VentasMD {

    public static Vventas vistav;
    Conexion conectar = new Conexion();

    public VentasBD() {
    }

    public VentasBD(int IdVentas, String numfactura, String cedulacliente, String FechaVenta, Double Monto, String Estado) {
        super(IdVentas, numfactura, cedulacliente, FechaVenta, Monto, Estado);
    }

    public String NroSerieVentas() {
        PreparedStatement st;
        ResultSet rs;
        Connection con;

        String serie = "";
        String NroSerie = "Select max(numfactura) from ventas";

        try {
            con = conectar.getCon();
            st = con.prepareStatement(NroSerie);
            rs = st.executeQuery();
            while (rs.next()) {
                serie = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return serie;

    }

    public String IdVentas() {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        String id = "";
        String sql = "Select max(idventa) from ventas";
        try {
            con = conectar.getCon();
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        return id;
    }

    public boolean insertarventas() {

        String sql = "INSERT INTO ventas(numfactura, cedula_cliente, fecha_venta, monto,estado) VALUES ('" + getNumfactura() + "','" + getCedulacliente() + "','" + getFechaVenta() + "','" + getMonto() + "','" + getEstado() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

}
