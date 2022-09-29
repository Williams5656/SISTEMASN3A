package Papeleria_Bella.modelo;

public class DetalleMD {

    int IdDetalleVenta;
    int IdVentas;
    String IdProducto;
    int Cantidad;
    double PrecioVenta;

    public DetalleMD() {
    }

    public DetalleMD(int IdDetalleVenta, int IdVentas, String IdProducto, int Cantidad, double PrecioVenta) {
        this.IdDetalleVenta = IdDetalleVenta;
        this.IdVentas = IdVentas;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.PrecioVenta = PrecioVenta;
    }

    public int getIdDetalleVenta() {
        return IdDetalleVenta;
    }

    public void setIdDetalleVenta(int IdDetalleVenta) {
        this.IdDetalleVenta = IdDetalleVenta;
    }

    public int getIdVentas() {
        return IdVentas;
    }

    public void setIdVentas(int IdVentas) {
        this.IdVentas = IdVentas;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

}
