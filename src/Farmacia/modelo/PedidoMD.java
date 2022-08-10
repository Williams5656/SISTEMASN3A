/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.modelo;

/**
 *
 * @author A
 */
public class PedidoMD {
    private String codigoP;
    private String descripcionP;
    private String fechaP;
    private String precio_unitarioP;
    private String cantidadP;
    private String totalP;

    public PedidoMD() {
    }

    public PedidoMD(String codigoP, String descripcionP, String fechaP, String precio_unitarioP, String cantidadP, String totalP) {
        this.codigoP = codigoP;
        this.descripcionP = descripcionP;
        this.fechaP = fechaP;
        this.precio_unitarioP = precio_unitarioP;
        this.cantidadP = cantidadP;
        this.totalP = totalP;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getFechaP() {
        return fechaP;
    }

    public void setFechaP(String fechaP) {
        this.fechaP = fechaP;
    }

    public String getPrecio_unitarioP() {
        return precio_unitarioP;
    }

    public void setPrecio_unitarioP(String precio_unitarioP) {
        this.precio_unitarioP = precio_unitarioP;
    }

    public String getCantidadP() {
        return cantidadP;
    }

    public void setCantidadP(String cantidadP) {
        this.cantidadP = cantidadP;
    }

    public String getTotalP() {
        return totalP;
    }

    public void setTotalP(String totalP) {
        this.totalP = totalP;
    }
    
}
