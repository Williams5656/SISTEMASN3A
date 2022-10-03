package V93Modelo;

public class CotizacionMD {
String Cliente;
String Producto;
int cantidad;
double precio;
double total;

    public CotizacionMD() {
    }

    public CotizacionMD(String Cliente, String Producto, int cantidad, double precio, double total) {
        this.Cliente = Cliente;
        this.Producto = Producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
