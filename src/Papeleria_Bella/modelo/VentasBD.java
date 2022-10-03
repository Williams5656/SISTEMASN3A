package Papeleria_Bella.modelo;

import Papeleria_Bella.vista.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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

    public int IdVenta() {
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        int id = 0;
        String sql = "SELECT MAX(idventa) FROM ventas";
        try {
            con = conectar.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
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
