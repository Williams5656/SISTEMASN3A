
package V93Modelo;

import java.awt.Image;


public class ProductoMb {
    
    private String codigo;
    private String descripcion;
    private String proveedor;
    private int stock;
    private double precio;
    private Image foto;

    public ProductoMb(String codigo, String descripcion, String proveedor, int stock, double precio,Image foto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.stock = stock;
        this.precio = precio;
        this.foto=foto;
    }

    public ProductoMb() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

 

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
    
    
    
    
    
}
