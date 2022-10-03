package Papeleria_Bella.modelo;

import java.util.Date;

public class VentasMD {

    int IdVentas;
    String numfactura;
    String cedulacliente;
    String FechaVenta;
    Double Monto;
    String Estado;

    public VentasMD() {
    }

    public VentasMD(int IdVentas, String numfactura, String cedulacliente, String FechaVenta, Double Monto, String Estado) {
        this.IdVentas = IdVentas;
        this.numfactura = numfactura;
        this.cedulacliente = cedulacliente;
        this.FechaVenta = FechaVenta;
        this.Monto = Monto;
        this.Estado = Estado;
    }

    public String getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(String FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public int getIdVentas() {
        return IdVentas;
    }

    public void setIdVentas(int IdVentas) {
        this.IdVentas = IdVentas;
    }

    public String getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(String numfactura) {
        this.numfactura = numfactura;
    }

    public String getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(String cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
