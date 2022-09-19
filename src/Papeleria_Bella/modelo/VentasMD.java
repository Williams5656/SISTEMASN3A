
package Papeleria_Bella.modelo;


public class VentasMD {
    String numfactura;
    String cedula;
    String codigo;
    String nombreproducto;
    int cantidad;
    String valoru;
    String iva;
    String total;

    public VentasMD() {
    }

    public VentasMD(String numfactura, String cedula, String codigo, String nombreproducto, int cantidad, String valoru, String iva, String total) {
        this.numfactura = numfactura;
        this.cedula = cedula;
        this.codigo = codigo;
        this.nombreproducto = nombreproducto;
        this.cantidad = cantidad;
        this.valoru = valoru;
        this.iva = iva;
        this.total = total;
    }

    

    

    public String getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(String numfactura) {
        this.numfactura = numfactura;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getValoru() {
        return valoru;
    }

    public void setValoru(String valoru) {
        this.valoru = valoru;
    }

    

    

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
}
