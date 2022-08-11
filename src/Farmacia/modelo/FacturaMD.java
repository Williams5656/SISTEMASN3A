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
public class FacturaMD {
    private String codigoF;
    private String descripcionF;
    private String fechaF;
    private String precio_unitarioF;
    private String cantidadF;
    private String totalF;

    public FacturaMD() {
    }

    public FacturaMD(String codigoF, String descripcionF, String fechaF, String precio_unitarioF, String cantidadF, String totalF) {
        this.codigoF = codigoF;
        this.descripcionF = descripcionF;
        this.fechaF = fechaF;
        this.precio_unitarioF = precio_unitarioF;
        this.cantidadF = cantidadF;
        this.totalF = totalF;
    }

    public String getCodigoF() {
        return codigoF;
    }

    public void setCodigoF(String codigoF) {
        this.codigoF = codigoF;
    }

    public String getDescripcionF() {
        return descripcionF;
    }

    public void setDescripcionF(String descripcionF) {
        this.descripcionF = descripcionF;
    }

    public String getFechaF() {
        return fechaF;
    }

    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }

    public String getPrecio_unitarioF() {
        return precio_unitarioF;
    }

    public void setPrecio_unitarioF(String precio_unitarioF) {
        this.precio_unitarioF = precio_unitarioF;
    }

    public String getCantidadF() {
        return cantidadF;
    }

    public void setCantidadF(String cantidadF) {
        this.cantidadF = cantidadF;
    }

    public String getTotalF() {
        return totalF;
    }

    public void setTotalF(String totalF) {
        this.totalF = totalF;
    }
    
    
}
