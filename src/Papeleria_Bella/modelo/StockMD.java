
package Papeleria_Bella.modelo;


public class StockMD {
    String codigo;
    String codigo_producto;
    int stock;
    String nombre_producto;

    public StockMD() {
    }

    
    
    public StockMD(String codigo, String codigo_producto, int stock, String nombre_producto) {
        this.codigo = codigo;
        this.codigo_producto = codigo_producto;
        this.stock = stock;
        this.nombre_producto = nombre_producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    
}
