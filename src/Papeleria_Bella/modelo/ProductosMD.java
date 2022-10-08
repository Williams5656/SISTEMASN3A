
package Papeleria_Bella.modelo;

import java.awt.Image;


public class ProductosMD {
    String codigo;
    String nombre;
    String descripcion;
    String proveedor;
    String marca;
    String modelo;
    int stock;
    Double valorunitario;
    String iva;
    private Image foto;

    public ProductosMD() {
    }

    public ProductosMD(String codigo, String nombre, String descripcion, String proveedor, String marca, String modelo, int stock, Double valorunitario, String iva, Image foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
        this.valorunitario = valorunitario;
        this.iva = iva;
        this.foto = foto;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(Double valorunitario) {
        this.valorunitario = valorunitario;
    }

    

  

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
    
    
}
