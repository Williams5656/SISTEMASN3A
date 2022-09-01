package MUEBLES.Modelo;

import java.awt.Image;



public class M_productosMD {
    
    String codigo_producto;
    String tipo;
    String familia;
    String dimensiones;
    int cantidad;
    String color;
    int piezas;
    double precio;
    Image foto_mueble;
    Image foto_piezas;

    public M_productosMD(String codigo_producto, String tipo, String familia, String dimensiones, int cantidad, String color, int piezas, double precio, Image foto_mueble, Image foto_piezas) {
        this.codigo_producto = codigo_producto;
        this.tipo = tipo;
        this.familia = familia;
        this.dimensiones = dimensiones;
        this.cantidad = cantidad;
        this.color = color;
        this.piezas = piezas;
        this.precio = precio;
        this.foto_mueble = foto_mueble;
        this.foto_piezas = foto_piezas;
    }

    public M_productosMD() {
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Image getFoto_mueble() {
        return foto_mueble;
    }

    public void setFoto_mueble(Image foto_mueble) {
        this.foto_mueble = foto_mueble;
    }

    public Image getFoto_piezas() {
        return foto_piezas;
    }

    public void setFoto_piezas(Image foto_piezas) {
        this.foto_piezas = foto_piezas;
    }
    
    
}
