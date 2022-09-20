
package Papeleria_Bella.modelo;

public class CotizacionMD {
    
    String codigo;
    String cedula;
    String codigoproductos;
    String nombreproductos;
    int cantidad;
    int valorunitario;
    String iva;
    int total;

    public CotizacionMD() {
    }

    public CotizacionMD(String codigo, String cedula, String codigoproductos, String nombreproductos, int cantidad, int valorunitario, String iva, int total) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.codigoproductos = codigoproductos;
        this.nombreproductos = nombreproductos;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
        this.iva = iva;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCodigoproductos() {
        return codigoproductos;
    }

    public void setCodigoproductos(String codigoproductos) {
        this.codigoproductos = codigoproductos;
    }

    public String getNombreproductos() {
        return nombreproductos;
    }

    public void setNombreproductos(String nombreproductos) {
        this.nombreproductos = nombreproductos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(int valorunitario) {
        this.valorunitario = valorunitario;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
